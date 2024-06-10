package View.Admin.TicketPlane;

import javax.swing.JPanel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import CustomUI.BtnCS;
import CustomUI.CurrencyTableCellRenderer;
import CustomUI.JtfCS;
import CustomUI.Table.JTblCS;
import CustomUI.Table.TableActionCellEditor;
import CustomUI.Table.TableActionCellRender;
import CustomUI.Table.TableActionEvent;
import CustomUI.Table.TablePanelAction;
import DAO.AAADAO;
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
                return column == 9; // Only the action column is editable
            }
        };

        table.setModel(model);

        try (ResultSet rs = TicketDAO.findTicketAll()) {
            loadRsToTable(rs);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // Set the custom cell renderer for the action column
        table.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                // Handle edit action
            }

            @Override
            public void onDelete(int row) {
                // Handle delete action
            }

            @Override
            public void onBookTicket(int row) {
                // Handle book ticket action
            }

            @Override
            public void onCancelTicket(int row) {
                // Get the TicketID from the table model
                String ticketID = (String) table.getModel().getValueAt(row, 0);
                
                // Show a confirmation dialog
                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Bạn có chắc chắn muốn hủy vé có mã: " + ticketID + "?",
                    "Xác nhận hủy vé",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                // Check if the user confirmed the cancellation
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        // Call the cancelTicket method from TicketDAO
                        int result = TicketDAO.cancelTicket(ticketID);
                        if (result > 0) {
                            // If the ticket is successfully cancelled, remove the row from the table
                            ((DefaultTableModel) table.getModel()).removeRow(row);
                            JOptionPane.showMessageDialog(null, "Hủy vé thành công");
                        } else {
                            JOptionPane.showMessageDialog(null, "Hủy vé thất bại.");
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi hủy vé!");
                    }
                }
            }
        }));

        // Set the custom cell renderer for the "Giá tiền" column
        table.getColumnModel().getColumn(8).setCellRenderer(new CurrencyTableCellRenderer());

        // Center align all other columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 8 && i != 9) { // Skip the "Giá tiền" and action columns
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }

        // Center align the header
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTableHeader header = table.getTableHeader();
        for (int i = 0; i < header.getColumnModel().getColumnCount(); i++) {
            header.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    
    //tải toàn bộ dữ liệu vé máy bay 
    public void loadRsToTable(ResultSet rs) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        while (rs.next()) {
            String email = rs.getString("Email");
            if (AAADAO.getCurrentAccount().getRoleID().equals("RL0003")) {
                if (email.equals(AAADAO.getCurrentAccount().getEmail())) {
                    double price = rs.getDouble("Price") / 100; // Reduce the price by a factor of 100
                    Object[] row = new Object[] {
                        rs.getString("TicketID"),
                        rs.getString("FlightID"),
                        rs.getString("FullName"),
                        rs.getString("IDCard"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Email"),
                        rs.getString("SeatID"),
                        rs.getString("TicketClassName"),
                        price, // Use the reduced price
                    };
                    model.addRow(row);
                }
            } else {
                double price = rs.getDouble("Price") / 100; // Reduce the price by a factor of 100
                Object[] row = new Object[] {
                    rs.getString("TicketID"),
                    rs.getString("FlightID"),
                    rs.getString("FullName"),
                    rs.getString("IDCard"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Email"),
                    rs.getString("SeatID"),
                    rs.getString("TicketClassName"),
                    price, // Use the reduced price
                };
                model.addRow(row);
            }
        }
    }

}
