package View.Admin.TicketPlane;

import javax.swing.JPanel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import CustomUI.BtnCS;
import CustomUI.CurrencyTableCellRenderer;
import CustomUI.JtfCS;
import CustomUI.Table.JTblCS;
import CustomUI.Table.TableActionCellEditor;
import CustomUI.Table.TableActionCellRender;
import CustomUI.Table.TableActionEvent;
import CustomUI.Table.TablePanelAction;
import DAO.AirportDAO;
import DAO.TicketDAO;
import combo_suggestion.ComboBoxSuggestion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SearchFlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private JtfCS textField;
    private JTblCS table;
    private BtnCS button;

    /**
     * Create the panel.
     */
    public SearchFlightTicket() {
        setBackground(new Color(240, 240, 240));
        setBounds(0, 0, 1500, 560);
        setLayout(null);

        // Initialize UI components
        initializeComponents();
        // Set up table model and renderers
        setupTable();
        
    }

    
    private void initializeComponents() {
    	ComboBoxSuggestion<String> comboBox = new ComboBoxSuggestion<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Tìm kiếm theo mã vé", "Tìm kiếm theo mã chuyến bay "}));
        comboBox.setBounds(25, 10, 216, 36);
        add(comboBox);

        textField = new JtfCS();
        textField.setBounds(286, 10, 248, 36);
        add(textField);
        textField.setColumns(10);

        button = new BtnCS();
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setForeground(new Color(255, 255, 255));
        button.setText("Tìm ");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textField.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        		}
        		else {
        			if(comboBox.getSelectedIndex()==0) {
        				ResultSet rs;
						try {
							rs = TicketDAO.findTicketID(textField.getText());
							loadRsToTable(rs);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				
        			}
        			else {
        				ResultSet rs;
						try {
							rs = TicketDAO.findFlightID(textField.getText());
							loadRsToTable(rs);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        	}
        });
        button.setBounds(588, 10, 134, 36);
        add(button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 71, 1451, 447);
        add(scrollPane);

        table = new JTblCS("SearchFlightTicket");
        table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
        scrollPane.setViewportView(table);
        table.fixTable(scrollPane);
        table.setRowHeight(50);
    }

    
    //model của table 
    private void setupTable() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Mã vé", "Mã chuyến bay", "Họ và tên", "CMND/CCCD", "Số điện thoại", "Email", "Ghế", "Hạng vé", "Giá tiền", "Thao tác"
            }
        ) {
      	  @Override
          public boolean isCellEditable(int row, int column) {
              if (column == 9)
              {
            	  return true;
              }
              return false;
    	  }

        };
        
        table.setModel(model);

        try (ResultSet rs = TicketDAO.findTicketAll()) {
            loadRsToTable(rs);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
		table.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
             
            }

			@Override
			public void onDelete(int row) {
				// TODO Auto-generated method stub
			
			}

			@Override
			public void onBookTicket(int row) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCancelTicket(int row) {
				// TODO Auto-generated method stub
				
			}


        }));

        // Set the custom cell renderer for the "Giá tiền" column (9th column, index 8)
        table.getColumnModel().getColumn(8).setCellRenderer(new CurrencyTableCellRenderer());

        // Center align all other columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 8 && i!= 9) { // Skip the "Giá tiền" column
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }
    
    
    //tải toàn bộ dữ liệu vé máy bay 
    public void loadRsToTable(ResultSet rs) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        while (rs.next()) {
            Object[] row = new Object[] {
                rs.getString("TicketID"),
                rs.getString("FlightID"),
                rs.getString("FullName"),
                rs.getString("IDCard"),
                rs.getString("PhoneNumber"),
                rs.getString("Email"),
                rs.getString("SeatID"),
                rs.getString("TicketClassName"),
                rs.getDouble("Price"), // Ensure this is a numeric value for the currency renderer
            };
            model.addRow(row);
        }
    }
}
