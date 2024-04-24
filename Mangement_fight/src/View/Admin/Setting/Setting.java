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
import DAO.AirportDAO;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.Component;
import javax.swing.JScrollBar;

public class Setting extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table_1;
	static JPanel contentPane;
	
	/**
	 * Create the panel.
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
		JTable table = new JTable(); // Tạo một JTable mới
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		table.setModel(new DefaultTableModel( // Thiết lập mô hình mặc định cho bảng
		    new Object[][] {
		        {"", "",""}, // Dữ liệu ban đầu, bạn có thể thêm các dòng khác tại đây
		    },
		    new String[] {
		        "Tên sân bay", "Tên thành phố", "Tên đất nước" // Tiêu đề của các cột
		    }
		));
		
		table.setRowHeight(30);
		
		//LẤY DANH SÁCH SÂN BAY TỪ AIRPORTDAL
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Tên sân bay :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 25, 99, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên thành phố :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(35, 87, 199, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên đất nước :");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(35, 147, 99, 26);
		panel_1.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(161, 25, 334, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 87, 334, 24);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 147, 334, 24);
		panel_1.add(textField_2);
		
		Button button = new Button("Thêm ");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(3, 4, 94));
		button.setBounds(95, 210, 99, 37);
		panel_1.add(button);
		
		Button button_1 = new Button("Cập nhập");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(3, 4, 94));
		button_1.setBounds(253, 210, 99, 37);
		panel_1.add(button_1);
		
		Button button_2 = new Button("Hủy");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(192, 192, 192));
		button_2.setBounds(396, 210, 99, 37);
		panel_1.add(button_2);
		
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
		
		JLabel lblNewLabel_1_9 = new JLabel("Tên hạng vé :");
		lblNewLabel_1_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_9.setBounds(416, 59, 99, 26);
		panel_1_2.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phần trăm đơn giá :");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(416, 121, 199, 26);
		panel_1_2.add(lblNewLabel_1_1_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(558, 62, 221, 24);
		panel_1_2.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(558, 124, 221, 24);
		panel_1_2.add(textField_13);
		
		Button button_4 = new Button("Thêm ");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(3, 4, 94));
		button_4.setBounds(426, 180, 99, 37);
		panel_1_2.add(button_4);
		
		Button button_1_1 = new Button("Cập nhập");
		button_1_1.setForeground(Color.WHITE);
		button_1_1.setBackground(new Color(3, 4, 94));
		button_1_1.setBounds(584, 180, 99, 37);
		panel_1_2.add(button_1_1);
		
		Button button_2_1 = new Button("Hủy");
		button_2_1.setForeground(Color.WHITE);
		button_2_1.setBackground(Color.LIGHT_GRAY);
		button_2_1.setBounds(727, 180, 99, 37);
		panel_1_2.add(button_2_1);
		
		JLabel lblHngV = new JLabel("HẠNG VÉ");
		lblHngV.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngV.setForeground(new Color(0, 0, 160));
		lblHngV.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHngV.setBounds(0, 10, 696, 25);
		panel_1_2.add(lblHngV);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(10, 45, 382, 235);
		panel_1_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên hạng vé", "Phần trăm", 
			}
		));
		scrollPane_1.setViewportView(table_1);
	}
	public static void loadRsToTable(ResultSet rs) throws SQLException {
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
}
