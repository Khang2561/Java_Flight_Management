package View.Admin.Setting;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DALs.AirportDAL;
import DAO.AAADAO;
import DAO.AirportDAO;
import DAO.TicketClassDAO;
import Model.Airport;
import libData.JDBCUtil;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setting extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTable table;
	private JTextField inputNameAirport;
	private JTextField inputNameCity;
	private JTextField inputNameCountry;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField inputNameClass;
	private JTextField inputNamePercent;
	private JTable table_1;
	static JPanel contentPane;
	DefaultTableModel model;
	private DefaultTableModel modelTicketLevel;
	
	/**
	 * Create the panel.
	 * @param table_1 
	 */
	public Setting() {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);
		
		
		//Pannel san bay 
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1520, 297);
		add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("SÂN BAY");
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(741, 5, 88, 25);
		panel.add(lblNewLabel);
		// Tạo bảng cho dữ liệu sân bay
		table = new JTable(); // Tạo một JTable mới
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
        model = new DefaultTableModel();
        Object[] column = {"Tên sân bay", "Tên thành phố", "Tên đất nước"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
		
		table.setRowHeight(30);
		
		//LẤY DANH SÁCH SÂN BAY TỪ AIRPORTDAL
        try {
        	ResultSet rs = AirportDAO.selectAll();
        	loadRsToTable(rs);      
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
		
        // Thêm bảng vào panel và panel vào frame
        panel.add(new JScrollPane(table));
        add(panel);

		// Tạo thanh cuộn cho bảng
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 770, 257); // Thiết lập vị trí và kích thước của thanh cuộn

		// Thêm thanh cuộn vào panel
		panel.add(scrollPane);
		
		//pannal sửa sân bay
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(790, 40, 706, 257);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelNameAirport = new JLabel("Tên sân bay :");
		labelNameAirport.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelNameAirport.setBounds(35, 25, 99, 26);
		panel_1.add(labelNameAirport);
		
		JLabel lbNameCity = new JLabel("Tên thành phố :");
		lbNameCity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNameCity.setBounds(35, 87, 199, 26);
		panel_1.add(lbNameCity);
		
		JLabel lbNameCountry = new JLabel("Tên đất nước :");
		lbNameCountry.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNameCountry.setBounds(35, 147, 99, 26);
		panel_1.add(lbNameCountry);
		
		inputNameAirport = new JTextField();
		inputNameAirport.setBounds(161, 25, 334, 24);
		panel_1.add(inputNameAirport);
		inputNameAirport.setColumns(10);
		
		inputNameCity = new JTextField();
		inputNameCity.setColumns(10);
		inputNameCity.setBounds(161, 87, 334, 24);
		panel_1.add(inputNameCity);
		
		inputNameCountry = new JTextField();
		inputNameCountry.setColumns(10);
		inputNameCountry.setBounds(161, 147, 334, 24);
		panel_1.add(inputNameCountry);
		
		//btn insert Airport
		Button btInsertAirport = new Button("Thêm ");
		btInsertAirport.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Kiểm tra xem sân bay có trùng không
		            boolean isAirportExists = AirportDAO.isAirportExists(inputNameAirport.getText(), inputNameCity.getText(), inputNameCountry.getText());
		            
		            if (isAirportExists) {
		                JOptionPane.showMessageDialog(null, "Sân bay đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            } else {
		                // Nếu sân bay chưa tồn tại, tiến hành thêm mới
		                ResultSet rs = AirportDAO.countAirport();
		                if (rs.next()) {
		                    int airportCount = rs.getInt(1);
		                    String inputAirportId = "AP0" + (airportCount + 1);

		                    Airport air = new Airport();
		                    air.setAirportID(inputAirportId);
		                    air.setAirportName(inputNameAirport.getText());
		                    air.setCityName(inputNameCity.getText());
		                    air.setCountryName(inputNameCountry.getText());
		                    AirportDAO.getInstance().insert(air);
		                    
		                    // Thông báo nhập thành công
		                    JOptionPane.showMessageDialog(null, "Đã thêm sân bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		                    
		                    // Xóa nội dung trong các trường nhập liệu
		                    inputNameAirport.setText("");
		                    inputNameCity.setText("");
		                    inputNameCountry.setText("");
		                    // Load lại dữ liệu lên JTable
		                    ResultSet updatedRs = AirportDAO.selectAll();
		                    loadRsToTable(updatedRs);
		                } else {
		                    // Xử lý trường hợp không có kết quả từ phương thức countAirport()
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            // Xử lý ngoại lệ khi có lỗi xảy ra khi truy vấn cơ sở dữ liệu
		        } catch (ClassNotFoundException ex) {
		            // Xử lý ngoại lệ ClassNotFoundException
		            ex.printStackTrace();
		            // Hoặc thông báo lỗi cho người dùng
		            JOptionPane.showMessageDialog(null, "Không tìm thấy lớp cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		
		btInsertAirport.setForeground(new Color(255, 255, 255));
		btInsertAirport.setBackground(new Color(3, 4, 94));
		btInsertAirport.setBounds(95, 210, 99, 37);
		panel_1.add(btInsertAirport);
		
		Button btUpdate = new Button("Cập nhập");
		btUpdate.setForeground(new Color(255, 255, 255));
		btUpdate.setBackground(new Color(3, 4, 94));
		btUpdate.setBounds(253, 210, 99, 37);
		panel_1.add(btUpdate);
		
		Button btDelete = new Button("Xóa");
		btDelete.setForeground(new Color(255, 255, 255));
		btDelete.setBackground(new Color(192, 192, 192));
		btDelete.setBounds(396, 210, 99, 37);
		panel_1.add(btDelete);
		
		//cai dat co ban 
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(10, 338, 590, 290);
		add(panel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Thời gian bay tối thiểu ");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 10, 174, 26);
		panel_1_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số sân bay trung gian tối đa");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 46, 198, 26);
		panel_1_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Thời gian dừng tối thiểu");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(10, 82, 187, 26);
		panel_1_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Thời gian dừng tối đa ");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(10, 118, 198, 26);
		panel_1_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Thời gian đặt vé chậm nhất ");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(10, 154, 198, 26);
		panel_1_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Thời gian hủy đặt vé chậm nhất ");
		lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(10, 190, 210, 26);
		panel_1_1.add(lblNewLabel_1_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(255, 15, 81, 19);
		panel_1_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(255, 51, 81, 19);
		panel_1_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(255, 87, 81, 19);
		panel_1_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(255, 123, 81, 19);
		panel_1_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(255, 159, 81, 19);
		panel_1_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(255, 195, 81, 19);
		panel_1_1.add(textField_11);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Phút");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(356, 10, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Phút");
		lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_1.setBounds(356, 82, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Phút");
		lblNewLabel_1_3_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2.setBounds(356, 118, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_1_3_1_2_1 = new JLabel("Ngày");
		lblNewLabel_1_3_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1.setBounds(356, 154, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1);
		
		JLabel lblNewLabel_1_3_1_2_1_1 = new JLabel("Ngày");
		lblNewLabel_1_3_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1_1.setBounds(356, 190, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1_1);
		
		JLabel lblNewLabel_1_3_1_2_1_2 = new JLabel("Sân");
		lblNewLabel_1_3_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1_2.setBounds(356, 46, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1_2);
		
		Button button_3 = new Button("Lưu");
		button_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(3, 4, 94));
		button_3.setBounds(10, 243, 570, 37);
		panel_1_1.add(button_3);
		
		
		//HANG VE
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_2.setBounds(639, 338, 836, 290);
		add(panel_1_2);
		
		JLabel lbNameClass = new JLabel("Tên hạng vé :");
		lbNameClass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNameClass.setBounds(416, 59, 99, 26);
		panel_1_2.add(lbNameClass);
		
		JLabel lbNamePercent = new JLabel("Phần trăm đơn giá :");
		lbNamePercent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNamePercent.setBounds(416, 121, 199, 26);
		panel_1_2.add(lbNamePercent);
		
		inputNameClass = new JTextField();
		inputNameClass.setColumns(10);
		inputNameClass.setBounds(558, 62, 221, 24);
		panel_1_2.add(inputNameClass);
		
		inputNamePercent = new JTextField();
		inputNamePercent.setColumns(10);
		inputNamePercent.setBounds(558, 124, 221, 24);
		panel_1_2.add(inputNamePercent);
		
		Button btnThemTicketClass = new Button("Thêm ");
		btnThemTicketClass.setForeground(Color.WHITE);
		btnThemTicketClass.setBackground(new Color(3, 4, 94));
		btnThemTicketClass.setBounds(426, 180, 99, 37);
		panel_1_2.add(btnThemTicketClass);
		
		Button btnUpdateTicketClass = new Button("Cập nhập");
		btnUpdateTicketClass.setForeground(Color.WHITE);
		btnUpdateTicketClass.setBackground(new Color(3, 4, 94));
		btnUpdateTicketClass.setBounds(584, 180, 99, 37);
		panel_1_2.add(btnUpdateTicketClass);
		
		Button button_2_1 = new Button("Hủy");
		button_2_1.setForeground(Color.WHITE);
		button_2_1.setBackground(Color.LIGHT_GRAY);
		button_2_1.setBounds(727, 180, 99, 37);
		panel_1_2.add(button_2_1);
		
		JLabel lbHangVe = new JLabel("HẠNG VÉ");
		lbHangVe.setHorizontalAlignment(SwingConstants.CENTER);
		lbHangVe.setForeground(new Color(0, 0, 160));
		lbHangVe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbHangVe.setBounds(0, 10, 696, 25);
		panel_1_2.add(lbHangVe);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(10, 45, 382, 235);
		panel_1_2.add(scrollPane_1);
		
		//table ticket class
		table_1 = new JTable();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		Object [] column1 = {"Tên hạng vé","Phần trăm"};
		modelTicketLevel = new DefaultTableModel();
		modelTicketLevel.setColumnIdentifiers(column1);
		table_1.setModel(modelTicketLevel);
		//upload data
		try {
			ResultSet rs = TicketClassDAO.selectAll();
			loadRsToTableTicketLevel(rs);
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		scrollPane_1.setViewportView(table_1);
		
	}
	
	//load data len teable tai bang setting 
	public void loadRsToTable(ResultSet rs) throws SQLException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		while(rs.next()) {
			model.addRow(new Object[] {
					rs.getString("AirportID"),
					rs.getString("AirportName"),
					rs.getString("CountryName"),
					
			});
		}
	}
	
	// Phương thức để load dữ liệu lên bảng hạng vé
	public void loadRsToTableTicketLevel(ResultSet rs) throws SQLException {
	    DefaultTableModel modelTicketLevel = (DefaultTableModel) table_1.getModel();
	    modelTicketLevel.setRowCount(0);
	    while (rs.next()) {
	        modelTicketLevel.addRow(new Object[] {
	            rs.getString("TicketClassName"),
	            rs.getString("PricePercentage"),
	        });
	    }
	}
	
}
