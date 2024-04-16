package View.Admin.AccountAndPermission;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.Scrollbar;
import java.awt.Panel;
import javax.swing.JRadioButton;

public class AccountAndPermission extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public AccountAndPermission() {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 642);
		setLayout(null);
		//PHAN QUYEN CHO CÁC TÀI KHOẢN
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 35, 1500, 262);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhóm quyền \r\n");
		lblNewLabel_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 0, 124, 49);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chuyến Bay");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1.setBounds(165, 0, 146, 49);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Vé Chuyến Bay");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1.setBounds(336, 0, 174, 49);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Máy Bay");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1.setBounds(520, 0, 169, 49);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tài Khoản Và Phân Quyền ");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1_1.setBounds(699, 0, 310, 49);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Cài Đặt ");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1_1_1.setBounds(1019, 0, 243, 49);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Chat Box");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(1279, 0, 221, 49);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Siêu quản trị ");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_2.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2.setBounds(0, 59, 146, 49);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Quản trị ");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_2_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2_1.setBounds(0, 108, 146, 49);
		panel.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Ban Giám Đốc ");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_2_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2_1_1.setBounds(0, 156, 146, 49);
		panel.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Nhân Viên ");
		lblNewLabel_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_2_1_2.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2_1_2.setBounds(0, 204, 146, 49);
		panel.add(lblNewLabel_1_1_2_1_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(223, 55, 21, 41);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(223, 108, 21, 41);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(223, 156, 21, 41);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_3.setBounds(223, 204, 21, 41);
		panel.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_4.setBounds(414, 55, 21, 41);
		panel.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("");
		rdbtnNewRadioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_5.setBounds(414, 108, 21, 41);
		panel.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("");
		rdbtnNewRadioButton_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_6.setBounds(414, 156, 21, 41);
		panel.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("");
		rdbtnNewRadioButton_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_7.setBounds(414, 204, 21, 41);
		panel.add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("");
		rdbtnNewRadioButton_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_8.setBounds(595, 55, 21, 41);
		panel.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("");
		rdbtnNewRadioButton_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_9.setBounds(595, 108, 21, 41);
		panel.add(rdbtnNewRadioButton_9);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("");
		rdbtnNewRadioButton_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_10.setBounds(595, 156, 21, 41);
		panel.add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("");
		rdbtnNewRadioButton_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_11.setBounds(595, 204, 21, 41);
		panel.add(rdbtnNewRadioButton_11);
		
		JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("");
		rdbtnNewRadioButton_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_12.setBounds(842, 55, 21, 41);
		panel.add(rdbtnNewRadioButton_12);
		
		JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("");
		rdbtnNewRadioButton_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_13.setBounds(842, 108, 21, 41);
		panel.add(rdbtnNewRadioButton_13);
		
		JRadioButton rdbtnNewRadioButton_14 = new JRadioButton("");
		rdbtnNewRadioButton_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_14.setBounds(842, 156, 21, 41);
		panel.add(rdbtnNewRadioButton_14);
		
		JRadioButton rdbtnNewRadioButton_15 = new JRadioButton("");
		rdbtnNewRadioButton_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_15.setBounds(842, 204, 21, 41);
		panel.add(rdbtnNewRadioButton_15);
		
		JRadioButton rdbtnNewRadioButton_16 = new JRadioButton("");
		rdbtnNewRadioButton_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_16.setBounds(1129, 55, 21, 41);
		panel.add(rdbtnNewRadioButton_16);
		
		JRadioButton rdbtnNewRadioButton_17 = new JRadioButton("");
		rdbtnNewRadioButton_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_17.setBounds(1129, 116, 21, 41);
		panel.add(rdbtnNewRadioButton_17);
		
		JRadioButton rdbtnNewRadioButton_18 = new JRadioButton("");
		rdbtnNewRadioButton_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_18.setBounds(1129, 164, 21, 41);
		panel.add(rdbtnNewRadioButton_18);
		
		JRadioButton rdbtnNewRadioButton_19 = new JRadioButton("");
		rdbtnNewRadioButton_19.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_19.setBounds(1129, 204, 21, 41);
		panel.add(rdbtnNewRadioButton_19);
		
		JRadioButton rdbtnNewRadioButton_20 = new JRadioButton("");
		rdbtnNewRadioButton_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_20.setBounds(1377, 55, 21, 41);
		panel.add(rdbtnNewRadioButton_20);
		
		JRadioButton rdbtnNewRadioButton_21 = new JRadioButton("");
		rdbtnNewRadioButton_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_21.setBounds(1377, 108, 21, 41);
		panel.add(rdbtnNewRadioButton_21);
		
		JRadioButton rdbtnNewRadioButton_22 = new JRadioButton("");
		rdbtnNewRadioButton_22.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_22.setBounds(1377, 156, 21, 41);
		panel.add(rdbtnNewRadioButton_22);
		
		JRadioButton rdbtnNewRadioButton_23 = new JRadioButton("");
		rdbtnNewRadioButton_23.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_23.setBounds(1377, 204, 21, 41);
		panel.add(rdbtnNewRadioButton_23);
		


		
		
		
		JLabel lblNewLabel = new JLabel("QUYỀN HẠNG CỦA CÁC NHÓM TÀI KHOẢN");
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 480, 35);
		add(lblNewLabel);
		
		JLabel lblQuynHngCa = new JLabel("QUYỀN HẠNG CỦA CÁC TÀI KHOẢN");
		lblQuynHngCa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuynHngCa.setForeground(new Color(0, 0, 160));
		lblQuynHngCa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuynHngCa.setBounds(10, 331, 376, 35);
		add(lblQuynHngCa);
		
		// QUYEN CUA CAC TAI KHOAN
		JTable table = new JTable(); // Tạo một JTable mới
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		table.setModel(new DefaultTableModel( // Thiết lập mô hình mặc định cho bảng
		    new Object[][] {
		        {"sadfS", "sadfS","sadfS"}, // Dữ liệu ban đầu, bạn có thể thêm các dòng khác tại đây
		    },
		    new String[] {
		        "Tên tài khoản", "Ngày tạo", "Nhóm quyền" // Tiêu đề của các cột
		    }
		));
		table.setBounds(207, 491, 1, 1);
		table.getColumnModel().getColumn(0).setPreferredWidth(200); // Thiết lập độ rộng ưu tiên cho cột 0 (Tên sân bay)
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Thiết lập độ rộng ưu tiên cho cột 1 (Tên thành phố)
		table.getColumnModel().getColumn(2).setPreferredWidth(200); // Thiết lập độ rộng ưu tiên cho cột 2 (Tên đất nước)
	
		
		table.setRowHeight(30);

		// Tạo thanh cuộn cho bảng
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 368, 630, 274); // Thiết lập vị trí và kích thước của thanh cuộn

		// Thêm thanh cuộn vào panel
		add(scrollPane);
	
		//pannel tạo tài khoảng
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(693, 333, 786, 299);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Họ và tên ");
		lblNewLabel_1_3.setBounds(10, 10, 140, 30);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Email");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1_3_1.setBounds(10, 50, 140, 30);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_3_2.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1_3_2.setBounds(10, 90, 140, 30);
		panel_1.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Mật khẩu");
		lblNewLabel_1_3_3.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1_3_3.setBounds(10, 130, 140, 30);
		panel_1.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Nhóm phân quyền ");
		lblNewLabel_1_3_4.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1_3_4.setBounds(10, 170, 173, 30);
		panel_1.add(lblNewLabel_1_3_4);
		
		textField = new JTextField();
		textField.setBounds(232, 10, 522, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(232, 50, 522, 28);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(232, 90, 522, 28);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(232, 130, 522, 28);
		panel_1.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Siêu quản trị ", "Quản trị ", "Ban giám đốc ", "Nhân viên "}));
		comboBox.setBounds(232, 170, 522, 30);
		panel_1.add(comboBox);
		
		Button button = new Button("Tạo tài khoản");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 0, 160));
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBounds(25, 249, 735, 40);
		panel_1.add(button);
		
	}
}
