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

public class AccountAndPermission extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tài Khoản Và Quyền ");
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
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Chiêu Cuối");
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
