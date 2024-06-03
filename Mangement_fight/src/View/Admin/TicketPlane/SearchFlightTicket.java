package View.Admin.TicketPlane;

import javax.swing.JPanel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import CustomUI.BtnCS;
import CustomUI.CurrencyTableCellRenderer;
import CustomUI.JtfCS;
import CustomUI.TableActionCellRender;
import DAO.TicketDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SearchFlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private JtfCS textField;
    private JTable table;
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
        JComboBox<String> comboBox = new JComboBox<>();
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

        table = new JTable();
        table.setEnabled(false);
        scrollPane.setViewportView(table);

        table.setRowHeight(45);
    }

    
    //model của table 
    private void setupTable() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
            },
            new String[] {
                "Mã vé", "Mã chuyến bay", "Họ và tên", "CMND/CCCD", "Số điện thoại", "Email", "Ghế", "Hạng vé", "Giá tiền", "Thao tác"
            }
        );
        table.setModel(model);

        try (ResultSet rs = TicketDAO.findTicketAll()) {
            loadRsToTable(rs);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // Set the custom cell renderer for the "Thao tác" column (10th column, index 9)
        table.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());

        // Set the custom cell renderer for the "Giá tiền" column (9th column, index 8)
        table.getColumnModel().getColumn(8).setCellRenderer(new CurrencyTableCellRenderer());

        // Center align all other columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 8) { // Skip the "Giá tiền" column
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }
    
    
    //tải toàn bộ dữ liệu vé máy bay 
    public void loadRsToTable(ResultSet rs) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        while (rs.next()) {
            model.addRow(new Object[] {
                rs.getString("TicketID"),
                rs.getString("FlightID"),
                rs.getString("FullName"),
                rs.getString("IDCard"),
                rs.getString("PhoneNumber"),
                rs.getString("Email"),
                rs.getString("SeatID"),
                rs.getString("TicketClassName"),
                rs.getDouble("Price"), // Ensure this is a numeric value for the currency renderer
                "Thao tác" // Placeholder for actions
            });
        }
    }
}
