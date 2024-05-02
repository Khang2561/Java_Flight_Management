package View.Admin.AccountAndPermission;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AAADAO;
import DAO.AirportDAO;
import DAO.ParametersDAO;
import DAO.PermissionDAO;
import Model.Account;
import Model.Airport;
import Model.Permission;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractButton;
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

	public static final long serialVersionUID = 1L;
	public JTable table;
	public JTextField tfHoVaTen;
	public JTextField tfEmail;
	public JTextField tfSDT;
	public JTextField tfMK;
	static JPanel contentPane ;
	public DefaultTableModel modelAccount;
	private Component rdbtnSQTChatBox;
	private JRadioButton rdbtnSQTChuyenBay;
	private JComponent rdbtnQTChuyenBay;
	private JRadioButton rdbtnBGDChuyenBay;
	private JRadioButton rdbtnNhanVien1;
	private JComponent rdbtnSQTVeChuyenBay;
	private JRadioButton rdbtnQTVeChuyenBay;
	private JComponent rdbtnBGDVeChuyenBay;
	private JRadioButton rdbtnNhanVien2;
	private JComponent rdbtnSQTMayBay;
	private JRadioButton rdbtnQTMayBay;
	private JComponent rdbtnBGDMayBay;
	private JRadioButton rdbtnNhanVien3;
	private JRadioButton rdbtnSQLTKvaPP;
	private JComponent rdbtnQTTKvaPQ;
	private JRadioButton rdbtnBGDTKvaPQ;
	private JRadioButton rdbtnNhanVien4;
	private JRadioButton rdbtnSQTCaiDat;
	private JRadioButton rdbtnQTCaiDat;
	private JRadioButton rdbtnBGDCaiDat;
	private JRadioButton rdbtnNhanVien5;
	private JComponent rdbtnQTChatBox;
	private JRadioButton rdbtnBGDChatBox;
	private JRadioButton rdbtnNhanVien6;
	

	

	/**
	 * Create the panel.
	 */
	public AccountAndPermission() throws ClassNotFoundException, SQLException{
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
		
		rdbtnSQTChuyenBay = new JRadioButton("");
		rdbtnSQTChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTChuyenBay.setBounds(223, 55, 21, 41);
		panel.add(rdbtnSQTChuyenBay);
		
		rdbtnQTChuyenBay = new JRadioButton("");
		rdbtnQTChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTChuyenBay.setBounds(223, 108, 21, 41);
		panel.add(rdbtnQTChuyenBay);
		
		rdbtnBGDChuyenBay = new JRadioButton("");
		rdbtnBGDChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDChuyenBay.setBounds(223, 156, 21, 41);
		panel.add(rdbtnBGDChuyenBay);
		
		rdbtnNhanVien1 = new JRadioButton("");
		rdbtnNhanVien1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien1.setBounds(223, 204, 21, 41);
		panel.add(rdbtnNhanVien1);
		
		rdbtnSQTVeChuyenBay = new JRadioButton("");
		rdbtnSQTVeChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTVeChuyenBay.setBounds(414, 55, 21, 41);
		panel.add(rdbtnSQTVeChuyenBay);
		
		rdbtnQTVeChuyenBay = new JRadioButton("");
		rdbtnQTVeChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTVeChuyenBay.setBounds(414, 108, 21, 41);
		panel.add(rdbtnQTVeChuyenBay);
		
		rdbtnBGDVeChuyenBay = new JRadioButton("");
		rdbtnBGDVeChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDVeChuyenBay.setBounds(414, 156, 21, 41);
		panel.add(rdbtnBGDVeChuyenBay);
		
		rdbtnNhanVien2 = new JRadioButton("");
		rdbtnNhanVien2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien2.setBounds(414, 204, 21, 41);
		panel.add(rdbtnNhanVien2);
		
		rdbtnSQTMayBay = new JRadioButton("");
		rdbtnSQTMayBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTMayBay.setBounds(595, 55, 21, 41);
		panel.add(rdbtnSQTMayBay);
		
		rdbtnQTMayBay = new JRadioButton("");
		rdbtnQTMayBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTMayBay.setBounds(595, 108, 21, 41);
		panel.add(rdbtnQTMayBay);
		
		rdbtnBGDMayBay = new JRadioButton("");
		rdbtnBGDMayBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDMayBay.setBounds(595, 156, 21, 41);
		panel.add(rdbtnBGDMayBay);
		
		rdbtnNhanVien3 = new JRadioButton("");
		rdbtnNhanVien3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien3.setBounds(595, 204, 21, 41);
		panel.add(rdbtnNhanVien3);
		
		rdbtnSQLTKvaPP = new JRadioButton("");
		rdbtnSQLTKvaPP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQLTKvaPP.setBounds(842, 55, 21, 41);
		panel.add(rdbtnSQLTKvaPP);
		
		rdbtnQTTKvaPQ = new JRadioButton("");
		rdbtnQTTKvaPQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTTKvaPQ.setBounds(842, 108, 21, 41);
		panel.add(rdbtnQTTKvaPQ);
		
		rdbtnBGDTKvaPQ = new JRadioButton("");
		rdbtnBGDTKvaPQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDTKvaPQ.setBounds(842, 156, 21, 41);
		panel.add(rdbtnBGDTKvaPQ);
		
		rdbtnNhanVien4 = new JRadioButton("");
		rdbtnNhanVien4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien4.setBounds(842, 204, 21, 41);
		panel.add(rdbtnNhanVien4);
		
		rdbtnSQTCaiDat = new JRadioButton("");
		rdbtnSQTCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTCaiDat.setBounds(1129, 55, 21, 41);
		panel.add(rdbtnSQTCaiDat);
		
		rdbtnQTCaiDat = new JRadioButton("");
		rdbtnQTCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTCaiDat.setBounds(1129, 116, 21, 41);
		panel.add(rdbtnQTCaiDat);
		
		rdbtnBGDCaiDat = new JRadioButton("");
		rdbtnBGDCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDCaiDat.setBounds(1129, 164, 21, 41);
		panel.add(rdbtnBGDCaiDat);
		
		rdbtnNhanVien5 = new JRadioButton("");
		rdbtnNhanVien5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien5.setBounds(1129, 204, 21, 41);
		panel.add(rdbtnNhanVien5);
		
		rdbtnSQTChatBox = new JRadioButton("");
		rdbtnSQTChatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTChatBox.setBounds(1377, 55, 21, 41);
		panel.add(rdbtnSQTChatBox);
		
		rdbtnQTChatBox = new JRadioButton("");
		rdbtnQTChatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTChatBox.setBounds(1377, 108, 21, 41);
		panel.add(rdbtnQTChatBox);
		
		rdbtnBGDChatBox = new JRadioButton("");
		rdbtnBGDChatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDChatBox.setBounds(1377, 156, 21, 41);
		panel.add(rdbtnBGDChatBox);
		
		rdbtnNhanVien6 = new JRadioButton("");
		rdbtnNhanVien6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien6.setBounds(1377, 204, 21, 41);
		panel.add(rdbtnNhanVien6);
		
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
		Object [] column = {"Tên tài khoản","Email","Nhóm quyền"};
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
		loadPermit();
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
	//LOAD QUYEN 
	public void loadPermit() throws ClassNotFoundException, SQLException {
		Permission SQT = new Permission();
		Permission QT = new Permission();
		Permission BGD = new Permission();
		Permission NV = new Permission();
		
		SQT = PermissionDAO.getInstance().setPMS("RL0001");
		QT	= PermissionDAO.getInstance().setPMS("RL0002");
		BGD = PermissionDAO.getInstance().setPMS("RL0003");
		NV = PermissionDAO.getInstance().setPMS("RL0004");
		
		//HIEN THI CAC NUT SIEU QUANT TRI 
		int roleIdInt = Integer.parseInt(SQT.getPermissionCode());
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnSQTChatBox).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnSQTCaiDat).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnSQLTKvaPP).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnSQTMayBay).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnSQTVeChuyenBay ).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnSQTChuyenBay).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		
		//HIEN THI CAC NUT QUANT TRI 
		roleIdInt = Integer.parseInt(QT.getPermissionCode());
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnQTChatBox).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnQTCaiDat).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnQTTKvaPQ).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnQTMayBay).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnQTVeChuyenBay ).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnQTChuyenBay).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		
		//HIEN THI CAC NUT BAN GIAM DOC
		roleIdInt = Integer.parseInt(BGD.getPermissionCode());
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnBGDChatBox).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnBGDCaiDat).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnBGDTKvaPQ).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnBGDMayBay).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnBGDVeChuyenBay ).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnBGDChuyenBay).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		//HIEN THI CAC NUT NHAN VIEN 
		roleIdInt = Integer.parseInt(NV.getPermissionCode());
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnNhanVien6).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnNhanVien5).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnNhanVien4).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnNhanVien3).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnNhanVien2 ).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		if (roleIdInt % 10 == 1) {
			((AbstractButton) rdbtnNhanVien1).setSelected(true);
		}
		roleIdInt = roleIdInt/10;
		
		
	} 
}

