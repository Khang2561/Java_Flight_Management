package View.Admin.AccountAndPermission;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AAADAO;
import DAO.AirportDAO;
import Model.Account;
import Model.Airport;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.Scrollbar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.awt.Panel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
public class AccountAndPermission extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfHoVaTen;
	private JTextField tfEmail;
	private JTextField tfSDT;
	private JTextField tfMK;
	static JPanel contentPane ;
	private DefaultTableModel modelAccount;
	

	

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
		panel.setBounds(0, 45, 1500, 262);
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
		
		//BANG CHUA QUYEN CUA CAC TAI KHOAN
		table = new JTable(); // Tạo một JTable mới
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		modelAccount = new DefaultTableModel();
		Object [] column = {"Tên tài khoản","Ngày tạo","Nhóm quyền"};
		modelAccount.setColumnIdentifiers(column);
		table.setModel(modelAccount);
		
		
		table.setRowHeight(30);
		//LAY DANH SACH TAI KHOANG TU DATA 
		try {
			ResultSet rs = AAADAO.selectAll();
			loadRsToTable(rs);
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}

		// Tạo thanh cuộn cho bảng
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 368, 630, 264); // Thiết lập vị trí và kích thước của thanh cuộn

		// Thêm thanh cuộn vào panel
		add(scrollPane);
		scrollPane.setViewportView(table);
		//pannel tạo tài khoảng
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(693, 333, 786, 299);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbHoVaTen = new JLabel("Họ và tên ");
		lbHoVaTen.setBounds(10, 10, 140, 30);
		lbHoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_1.add(lbHoVaTen);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbEmail.setBounds(10, 50, 140, 30);
		panel_1.add(lbEmail);
		
		JLabel lbSDT = new JLabel("Số điện thoại");
		lbSDT.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbSDT.setBounds(10, 90, 140, 30);
		panel_1.add(lbSDT);
		
		JLabel lbMK = new JLabel("Mật khẩu");
		lbMK.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbMK.setBounds(10, 130, 140, 30);
		panel_1.add(lbMK);
		
		JLabel lbNhomQuyen = new JLabel("Nhóm phân quyền ");
		lbNhomQuyen.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbNhomQuyen.setBounds(10, 170, 173, 30);
		panel_1.add(lbNhomQuyen);
		
		tfHoVaTen = new JTextField();
		tfHoVaTen.setBounds(232, 10, 522, 28);
		panel_1.add(tfHoVaTen);
		tfHoVaTen.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(232, 50, 522, 28);
		panel_1.add(tfEmail);
		
		tfSDT = new JTextField();
		tfSDT.setColumns(10);
		tfSDT.setBounds(232, 90, 522, 28);
		panel_1.add(tfSDT);
		
		tfMK = new JTextField();
		tfMK.setColumns(10);
		tfMK.setBounds(232, 130, 522, 28);
		panel_1.add(tfMK);
		
		JComboBox cbQuyen = new JComboBox();
		cbQuyen.setFont(new Font("Times New Roman", Font.BOLD, 17));
		cbQuyen.setModel(new DefaultComboBoxModel(new String[] {"Siêu quản trị", "Quản trị", "Ban giám đốc", "Nhân viên"}));
		cbQuyen.setBounds(232, 171, 522, 30);
		panel_1.add(cbQuyen);
		
		Button buttonCreateAccount = new Button("Tạo tài khoản");
		buttonCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			        // Kiểm tra xem tài khoản có tồn tại không
			        boolean isAccountExists = AAADAO.isAccountExists(tfEmail.getText(), tfSDT.getText());
			        if (isAccountExists) {
			            JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			        } else {
			            // Nếu tài khoản chưa tồn tại, tiến hành thêm mới
			            String inputAccountId = generateUniqueAccountId(); // Tạo mã tài khoản mới không trùng
			            Account acc = new Account();
			            acc.setAccountID(inputAccountId);
			            acc.setName(tfHoVaTen.getText());
			            acc.setEmail(tfEmail.getText());
			            acc.setPhone(tfSDT.getText());
			            acc.setPassword(tfMK.getText());
			            acc.setCreated1();
			            String selectedRole = (String) cbQuyen.getSelectedItem();
			            if (selectedRole.equals("Siêu quản trị")) {
			                acc.setRoleID("RL0001");
			            } else if (selectedRole.equals("Quản trị")) {
			                acc.setRoleID("RL0002");
			            } else if (selectedRole.equals("Ban giám đốc")) {
			                acc.setRoleID("RL0003");
			            } else if (selectedRole.equals("Nhân viên")) {
			                acc.setRoleID("RL0004");
			            } else {
			                acc.setRoleID("RL0004");
			            }

			            AAADAO.getInstance().insert(acc);
			            
			            // Thông báo thêm thành công
			            JOptionPane.showMessageDialog(null, "Đã thêm tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			            
			            // Xóa nội dung trong các trường nhập liệu
			            tfHoVaTen.setText("");
			            tfEmail.setText("");
			            tfSDT.setText("");
			            tfMK.setText("");
			            
			            // Load lại dữ liệu lên JTable
			            ResultSet updatedRs = AAADAO.selectAll();
			            loadRsToTable(updatedRs);
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        // Xử lý ngoại lệ khi có lỗi xảy ra khi truy vấn cơ sở dữ liệu
			    } catch (ClassNotFoundException ex) {
			        ex.printStackTrace();
			        // Xử lý ngoại lệ ClassNotFoundException
			        JOptionPane.showMessageDialog(null, "Không tìm thấy lớp cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		buttonCreateAccount.setForeground(new Color(255, 255, 255));
		buttonCreateAccount.setBackground(new Color(0, 0, 160));
		buttonCreateAccount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonCreateAccount.setBounds(25, 249, 735, 40);
		panel_1.add(buttonCreateAccount);
		
		Button buttonLuuAp = new Button("Lưu");
		buttonLuuAp.setForeground(Color.WHITE);
		buttonLuuAp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonLuuAp.setBackground(new Color(0, 0, 160));
		buttonLuuAp.setBounds(1328, 0, 151, 39);
		add(buttonLuuAp);
			
	}
	private String generateUniqueAccountId() {
		String accountIdPrefix = "AC"; // Tiền tố của mã tài khoản
		int accountIdDigits = 3; // Số chữ số sau tiền tố
		String accountId = "";
		boolean isUnique = false;
			    
		while (!isUnique) {
			accountId = accountIdPrefix + generateRandomDigits(accountIdDigits); // Tạo mã tài khoản mới
			// Kiểm tra xem mã tài khoản mới đã tồn tại hay chưa
			 try {
			            isUnique = !AAADAO.isAccountIdExists(accountId);
			        } catch (SQLException | ClassNotFoundException e) {
			            e.printStackTrace();
			        }
			    }
			    
			    return accountId;
			}
			// Phương thức để tạo chuỗi số ngẫu nhiên với độ dài cho trước
		private String generateRandomDigits(int length) {
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				sb.append(random.nextInt(10)); // Thêm một chữ số ngẫu nhiên vào chuỗi
			}
			return sb.toString();
		}
	//LOAD DATA TO ACCOUNT TABLE 
	public void loadRsToTable(ResultSet rs) throws SQLException {
		DefaultTableModel modelAccount = (DefaultTableModel) table.getModel();
		modelAccount.setRowCount(0);
		while(rs.next()) {
			modelAccount.addRow(new Object[] {
					rs.getString("Name"),
					rs.getString("Email"),
					rs.getString("RoleName"),
					
			});
		}
	}
}

