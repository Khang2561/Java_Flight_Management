package View.Admin.AccountAndPermission;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import CustomUI.BtnCS;
import CustomUI.JtfCS;
import CustomUI.PanelRound;
import CustomUI.RadioButtonCustom;
import CustomUI.Table.JTblCS;
import CustomUI.Table.TableActionCellEditor;
import CustomUI.Table.TableActionCellRender;
import CustomUI.Table.TableActionEvent;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class AccountAndPermission extends JPanel {

	public static final long serialVersionUID = 1L;
	//account
	public JTblCS table;
	public JtfCS tfHoVaTen;
	public JtfCS tfEmail;
	public JtfCS tfSDT;
	public JtfCS tfMK;
	private BtnCS buttonCapNhap;
	private BtnCS buttonXoa;
	private BtnCS buttonHuy;
	
	//main pane
	static JPanel contentPane ;
	
	//permission for account
	public DefaultTableModel modelAccount;
	private RadioButtonCustom rdbtnSQTChatBox;
	private RadioButtonCustom rdbtnSQTChuyenBay;
	private RadioButtonCustom rdbtnQTChuyenBay;
	private RadioButtonCustom rdbtnBGDChuyenBay;
	private RadioButtonCustom rdbtnNhanVien1;
	private RadioButtonCustom rdbtnSQTVeChuyenBay;
	private RadioButtonCustom rdbtnQTVeChuyenBay;
	private RadioButtonCustom rdbtnBGDVeChuyenBay;
	private RadioButtonCustom rdbtnNhanVien2;
	private RadioButtonCustom rdbtnSQTMayBay;
	private RadioButtonCustom rdbtnQTMayBay;
	private RadioButtonCustom rdbtnBGDMayBay;
	private RadioButtonCustom rdbtnNhanVien3;
	private RadioButtonCustom rdbtnSQLTKvaPP;
	private RadioButtonCustom rdbtnQTTKvaPQ;
	private RadioButtonCustom rdbtnBGDTKvaPQ;
	private RadioButtonCustom rdbtnNhanVien4;
	private RadioButtonCustom rdbtnSQTCaiDat;
	private RadioButtonCustom rdbtnQTCaiDat;
	private RadioButtonCustom rdbtnBGDCaiDat;
	private RadioButtonCustom rdbtnNhanVien5;
	private RadioButtonCustom rdbtnQTChatBox;
	private RadioButtonCustom rdbtnBGDChatBox;
	private RadioButtonCustom rdbtnNhanVien6;
	private BtnCS buttonCreateAccount;
	private BtnCS buttonLuuAp;
	private PanelRound panel;
	private PanelRound panel_1;
	private JComboBox cbQuyen;
	
	//main AccountAndPermission
	public AccountAndPermission() throws ClassNotFoundException, SQLException{
		
		//-------------------------setting basic for pane----------------------------------
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 642);
		setLayout(null);
		panel = new PanelRound();
		panel.setRoundTopRight(20);
		panel.setRoundTopLeft(20);
		panel.setRoundBottomRight(20);
		panel.setRoundBottomLeft(90);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 54, 1468, 253);
		add(panel);
		panel.setLayout(null);
		
		
		//-----------------------------label---------------------------------------------------- 
		JLabel lblNewLabel_1 = new JLabel("Nhóm quyền \r\n");
		lblNewLabel_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 0, 124, 49);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chuyến Bay");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1.setBounds(165, 0, 146, 49);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Vé Chuyến Bay");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1.setBounds(336, 0, 174, 49);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Máy Bay");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1.setBounds(520, 0, 169, 49);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tài Khoản Và Phân Quyền ");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1_1.setBounds(699, 0, 310, 49);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Cài Đặt ");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1_1_1.setBounds(1019, 0, 243, 49);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Chat Box");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(1269, 0, 221, 49);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Siêu quản trị ");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2.setBounds(0, 49, 146, 49);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Quản trị ");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2_1.setBounds(0, 108, 146, 49);
		panel.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Khách hàng ");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2_1_1.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2_1_1.setBounds(0, 156, 146, 49);
		panel.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Nhân Viên ");
		lblNewLabel_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2_1_2.setBackground(new Color(114, 114, 114));
		lblNewLabel_1_1_2_1_2.setBounds(0, 204, 146, 49);
		panel.add(lblNewLabel_1_1_2_1_2);
		
		JLabel lblNewLabel = new JLabel("QUYỀN HẠNG CỦA CÁC NHÓM TÀI KHOẢN");
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 9, 429, 35);
		add(lblNewLabel);
		
		JLabel lblQuynHngCa = new JLabel("QUYỀN HẠNG CỦA CÁC TÀI KHOẢN");
		lblQuynHngCa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuynHngCa.setForeground(new Color(0, 0, 160));
		lblQuynHngCa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuynHngCa.setBounds(10, 317, 366, 35);
		add(lblQuynHngCa);
		
		
		//-------------------radio button for permission-------------------------------------------
		rdbtnSQTChuyenBay = new RadioButtonCustom();
		rdbtnSQTChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTChuyenBay.setBounds(223, 55, 21, 41);
		panel.add(rdbtnSQTChuyenBay);
		
		rdbtnQTChuyenBay = new RadioButtonCustom();
		rdbtnQTChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTChuyenBay.setBounds(223, 108, 21, 41);
		panel.add(rdbtnQTChuyenBay);
		
		rdbtnBGDChuyenBay = new RadioButtonCustom();
		rdbtnBGDChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDChuyenBay.setBounds(223, 156, 21, 41);
		panel.add(rdbtnBGDChuyenBay);
		
		rdbtnNhanVien1 = new RadioButtonCustom();
		rdbtnNhanVien1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien1.setBounds(223, 204, 21, 41);
		panel.add(rdbtnNhanVien1);
		
		rdbtnSQTVeChuyenBay = new RadioButtonCustom();
		rdbtnSQTVeChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTVeChuyenBay.setBounds(414, 55, 21, 41);
		panel.add(rdbtnSQTVeChuyenBay);
		
		rdbtnQTVeChuyenBay = new RadioButtonCustom();
		rdbtnQTVeChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTVeChuyenBay.setBounds(414, 108, 21, 41);
		panel.add(rdbtnQTVeChuyenBay);
		
		rdbtnBGDVeChuyenBay = new RadioButtonCustom();
		rdbtnBGDVeChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDVeChuyenBay.setBounds(414, 156, 21, 41);
		panel.add(rdbtnBGDVeChuyenBay);
		
		rdbtnNhanVien2 = new RadioButtonCustom();
		rdbtnNhanVien2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien2.setBounds(414, 204, 21, 41);
		panel.add(rdbtnNhanVien2);
		
		rdbtnSQTMayBay = new RadioButtonCustom();
		rdbtnSQTMayBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTMayBay.setBounds(595, 55, 21, 41);
		panel.add(rdbtnSQTMayBay);
		
		rdbtnQTMayBay = new RadioButtonCustom();
		rdbtnQTMayBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTMayBay.setBounds(595, 108, 21, 41);
		panel.add(rdbtnQTMayBay);
		
		rdbtnBGDMayBay = new RadioButtonCustom();
		rdbtnBGDMayBay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDMayBay.setBounds(595, 156, 21, 41);
		panel.add(rdbtnBGDMayBay);
		
		rdbtnNhanVien3 = new RadioButtonCustom();
		rdbtnNhanVien3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien3.setBounds(595, 204, 21, 41);
		panel.add(rdbtnNhanVien3);
		
		rdbtnSQLTKvaPP = new RadioButtonCustom();
		rdbtnSQLTKvaPP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQLTKvaPP.setBounds(842, 55, 21, 41);
		panel.add(rdbtnSQLTKvaPP);
		
		rdbtnQTTKvaPQ = new RadioButtonCustom();
		rdbtnQTTKvaPQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTTKvaPQ.setBounds(842, 108, 21, 41);
		panel.add(rdbtnQTTKvaPQ);
		
		rdbtnBGDTKvaPQ = new RadioButtonCustom();
		rdbtnBGDTKvaPQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDTKvaPQ.setBounds(842, 156, 21, 41);
		panel.add(rdbtnBGDTKvaPQ);
		
		rdbtnNhanVien4 = new RadioButtonCustom();
		rdbtnNhanVien4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien4.setBounds(842, 204, 21, 41);
		panel.add(rdbtnNhanVien4);
		
		rdbtnSQTCaiDat = new RadioButtonCustom();
		rdbtnSQTCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTCaiDat.setBounds(1129, 55, 21, 41);
		panel.add(rdbtnSQTCaiDat);
		
		rdbtnQTCaiDat = new RadioButtonCustom();
		rdbtnQTCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTCaiDat.setBounds(1129, 108, 21, 41);
		panel.add(rdbtnQTCaiDat);
		
		rdbtnBGDCaiDat = new RadioButtonCustom();
		rdbtnBGDCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDCaiDat.setBounds(1129, 156, 21, 41);
		panel.add(rdbtnBGDCaiDat);
		
		rdbtnNhanVien5 = new RadioButtonCustom();
		rdbtnNhanVien5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien5.setBounds(1129, 204, 21, 41);
		panel.add(rdbtnNhanVien5);
		
		rdbtnSQTChatBox = new RadioButtonCustom();
		rdbtnSQTChatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSQTChatBox.setBounds(1377, 55, 21, 41);
		panel.add(rdbtnSQTChatBox);
		
		rdbtnQTChatBox = new RadioButtonCustom();
		rdbtnQTChatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnQTChatBox.setBounds(1377, 108, 21, 41);
		panel.add(rdbtnQTChatBox);
		
		rdbtnBGDChatBox = new RadioButtonCustom();
		rdbtnBGDChatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnBGDChatBox.setBounds(1377, 156, 21, 41);
		panel.add(rdbtnBGDChatBox);
		
		rdbtnNhanVien6 = new RadioButtonCustom();
		rdbtnNhanVien6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNhanVien6.setBounds(1377, 204, 21, 41);
		panel.add(rdbtnNhanVien6);
		
		
		//--------------table for account ----------------------------------
		//create account table
		table = new JTblCS(); 
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		//setting basic for table
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); 
		modelAccount = new DefaultTableModel() {
			  @Override
	      	  public boolean isCellEditable(int row, int column) {
	              if (column == 3)
	              {
	            	  return true;
	              }
	              return false;
	          }
		};
		Object [] column = {"Tên tài khoản","Email","Nhóm quyền", "Thao tác"};
		modelAccount.setColumnIdentifiers(column);
		table.setModel(modelAccount);
		table.setRowHeight(40);
		//load data to table from database
		try {
			ResultSet rs = AAADAO.selectAll();
			loadRsToTable(rs);
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		// Create scrollpane for account table
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 351, 630, 270); 
		add(scrollPane);
		scrollPane.setViewportView(table);
		table.fixTable(scrollPane);
		
		table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (row != -1) { // Check if a row is selected
                    String email = table.getValueAt(row, 1).toString(); // Get the value of the "Email" column
                    try (ResultSet rs = AAADAO.findACbyEmail(email)) {
                        // Process ResultSet to extract data
                        if (rs.next()) {
                            // Example: get data from ResultSet
                            tfHoVaTen.setText(rs.getString("Name"));
                            tfEmail.setText(rs.getString("Email"));
                            tfSDT.setText(rs.getString("Phone"));
                            tfMK.setText(rs.getString("Password"));
                            if ("RL0001".equals(rs.getString("RoleID"))) {
                                cbQuyen.setSelectedIndex(0);
                            }
                            if ("RL0002".equals(rs.getString("RoleID"))) {
                                cbQuyen.setSelectedIndex(1);
                            }
                            if ("RL0003".equals(rs.getString("RoleID"))) {
                                cbQuyen.setSelectedIndex(2);
                            }
                            if ("RL0004".equals(rs.getString("RoleID"))) {
                                cbQuyen.setSelectedIndex(3);
                            }
                            buttonCreateAccount.setVisible(false);
                            tfEmail.setEditable(false); // Set the text field to non-editable
                            // Display account information or perform other actions here
                        } else {
                            // No account found
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                        // Handle exception
                    }
                }
            }

			@Override
			public void onDelete(int row) {
				// TODO Auto-generated method stub
				
				int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản này?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					 // Get the email from the selected row
				    String email = table.getValueAt(row, 1).toString();

				    // Delete the account associated with the email
				    AAADAO.deleteByEmail(email);

				    // Clear the text fields
				    tfHoVaTen.setText("");
				    tfEmail.setText("");
				    tfSDT.setText("");
				    tfMK.setText("");

				    // Reset the combo box and make the create account button visible
				    cbQuyen.setSelectedIndex(0);
				    buttonCreateAccount.setVisible(true);

				    // Make the email text field editable
				    tfEmail.setEditable(true);

				    // Reload data to table
				    ResultSet updatedRs;
				    try {
				        updatedRs = AAADAO.selectAll();
				        loadRsToTable(updatedRs);
				    } catch (ClassNotFoundException | SQLException e1) {
				        e1.printStackTrace();
				    }
				}
				else return;
			}
        }));
		
		
		//-------------------create panel to add account---------------------------------
		panel_1 = new PanelRound();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 64, 64), null, null, null));
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setRoundTopRight(30);
		panel_1.setRoundBottomRight(30);
		panel_1.setRoundBottomLeft(30);
		panel_1.setRoundTopLeft(30);
		panel_1.setBounds(693, 333, 786, 299);
		add(panel_1);
		panel_1.setLayout(null);
		
		//add jlabel for account panel
		JLabel lbHoVaTen = new JLabel("Họ và tên ");
		lbHoVaTen.setBounds(10, 21, 140, 30);
		lbHoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_1.add(lbHoVaTen);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbEmail.setBounds(10, 73, 140, 30);
		panel_1.add(lbEmail);
		
		JLabel lbSDT = new JLabel("Số điện thoại");
		lbSDT.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbSDT.setBounds(10, 122, 140, 30);
		panel_1.add(lbSDT);
		
		JLabel lbMK = new JLabel("Mật khẩu");
		lbMK.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbMK.setBounds(10, 167, 140, 30);
		panel_1.add(lbMK);
		
		JLabel lbNhomQuyen = new JLabel("Nhóm phân quyền ");
		lbNhomQuyen.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lbNhomQuyen.setBounds(10, 207, 173, 30);
		panel_1.add(lbNhomQuyen);
		
		//jtextfile for account pannel
		tfHoVaTen = new JtfCS();
		tfHoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tfHoVaTen.setBounds(232, 10, 522, 43);
		panel_1.add(tfHoVaTen);
		tfHoVaTen.setColumns(10);
		
		tfEmail = new JtfCS();
		tfEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(232, 63, 522, 43);
		panel_1.add(tfEmail);
		
		tfSDT = new JtfCS();
		tfSDT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tfSDT.setColumns(10);
		tfSDT.setBounds(232, 114, 522, 43);
		panel_1.add(tfSDT);
		
		tfMK = new JtfCS();
		tfMK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tfMK.setColumns(10);
		tfMK.setBounds(232, 164, 522, 42);
		panel_1.add(tfMK);
		//combo box for add permission
		cbQuyen = new JComboBox();
		cbQuyen.setFont(new Font("Times New Roman", Font.BOLD, 17));
		cbQuyen.setModel(new DefaultComboBoxModel(new String[] {"Siêu quản trị", "Quản trị", "Ban giám đốc", "Nhân viên"}));
		cbQuyen.setBounds(232, 208, 522, 30);
		panel_1.add(cbQuyen);
		
		
		//--------------------create button to add account--------------------------------
		buttonCreateAccount = new BtnCS();
		buttonCreateAccount.setRadius(30);
		buttonCreateAccount.setColor(new Color(3, 4, 94));
		buttonCreateAccount.setText("THÊM ");
		buttonCreateAccount.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            if (tfHoVaTen.getText().isEmpty() || tfEmail.getText().isEmpty() || tfSDT.getText().isEmpty() || tfMK.getText().isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Xin vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            } else {
		                // Kiểm tra định dạng email
		                String emailPattern = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$"; // Biểu thức chính quy kiểm tra định dạng email
		                Pattern emailPattern1 = Pattern.compile(emailPattern);
		                Matcher emailMatcher = emailPattern1.matcher(tfEmail.getText());

		                if (!emailMatcher.matches()) {
		                    JOptionPane.showMessageDialog(null, "Địa chỉ email không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                } else {
		                    // Kiểm tra định dạng số điện thoại
		                    String phonePattern = "^\\d{10}$"; // Biểu thức chính quy kiểm tra số điện thoại có 10 số
		                    Pattern phonePattern1 = Pattern.compile(phonePattern);
		                    Matcher phoneMatcher = phonePattern1.matcher(tfSDT.getText());

		                    if (!phoneMatcher.matches()) {
		                        JOptionPane.showMessageDialog(null, "Số điện thoại phải có 10 số!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                    } else {
		                        // must fill full info
		                        boolean isAccountExists = AAADAO.isEmail(tfEmail.getText());
		                        if (isAccountExists) {
		                            JOptionPane.showMessageDialog(null, "Email đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                        } else {
		                            // continue if have not account
		                            String inputAccountId = generateUniqueAccountId(); // create id for new account not duplicate
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

		                            // success info
		                            JOptionPane.showMessageDialog(null, "Đã thêm tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		                            // delete form 
		                            tfHoVaTen.setText("");
		                            tfEmail.setText("");
		                            tfSDT.setText("");
		                            tfMK.setText("");

		                            // reload data to table
		                            ResultSet updatedRs = AAADAO.selectAll();
		                            loadRsToTable(updatedRs);
		                        }
		                    }
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            // process if error in database
		        } catch (ClassNotFoundException ex) {
		            ex.printStackTrace();
		            // ClassNotFoundException
		            JOptionPane.showMessageDialog(null, "Không tìm thấy lớp cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		//setting view for button
		buttonCreateAccount.setForeground(new Color(255, 255, 255));
		buttonCreateAccount.setBackground(new Color(3, 4, 94));
		buttonCreateAccount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonCreateAccount.setBounds(10, 247, 751, 44);
		panel_1.add(buttonCreateAccount);
		
		//update button
		buttonCapNhap = new BtnCS();
		buttonCapNhap.setColorOver(new Color(0, 0, 160));
		buttonCapNhap.setColorClick(new Color(0, 0, 160));
		buttonCapNhap.setColor(new Color(3, 4, 94));
		buttonCapNhap.setText("CẬP NHẬT");
		buttonCapNhap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve existing email
		        String existingEmail = tfEmail.getText();
		        Account AC = new Account();
		        AC.setName(tfHoVaTen.getText());
		        AC.setEmail(existingEmail); // Set existing email
		        AC.setPhone(tfSDT.getText());
		        AC.setPassword(tfMK.getText());

		        String selectedRole = (String) cbQuyen.getSelectedItem();
		        if (selectedRole.equals("Siêu quản trị")) {
		            AC.setRoleID("RL0001");
		        } else if (selectedRole.equals("Quản trị")) {
		            AC.setRoleID("RL0002");
		        } else if (selectedRole.equals("Ban giám đốc")) {
		            AC.setRoleID("RL0003");
		        } else if (selectedRole.equals("Nhân viên")) {
		            AC.setRoleID("RL0004");
		        } else {
		            AC.setRoleID("RL0004");
		        }
		        // return table after update 
		        AAADAO.updateAC(AC);
		        tfHoVaTen.setText("");
		        tfEmail.setText("");
		        tfSDT.setText("");
		        tfMK.setText("");
		        cbQuyen.setSelectedIndex(0);
		        buttonCreateAccount.setVisible(true);
		        tfEmail.setEditable(true);
		        // Load lại dữ liệu lên JTable
		        ResultSet updatedRs;
		        try {
		            updatedRs = AAADAO.selectAll();
		            loadRsToTable(updatedRs);
		        } catch (ClassNotFoundException | SQLException e1) {
		            // Handle exception
		            e1.printStackTrace();
		        }
		    }
		});
		//setting view for update button
		buttonCapNhap.setForeground(Color.WHITE);
		buttonCapNhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonCapNhap.setBackground(new Color(3, 4, 94));
		buttonCapNhap.setBounds(25, 250, 249, 39);
		panel_1.add(buttonCapNhap);
		
		//create delete button
		buttonXoa = new BtnCS();
		buttonXoa.setColorOver(new Color(217,217,217));
		buttonXoa.setColorClick(new Color(217,217,217));
		buttonXoa.setColor(new Color(192, 192, 192));
		buttonXoa.setBorderColor(new Color(192, 192, 192));
		buttonXoa.setText("XÓA ");
		buttonXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AAADAO.deleteByEmail(tfEmail.getText());
				tfHoVaTen.setText("");
                tfEmail.setText("");
                tfSDT.setText("");
                tfMK.setText("");
                cbQuyen.setSelectedIndex(0);
                buttonCreateAccount.setVisible(true);
                tfEmail.setEditable(true);
                // reload data to table
                ResultSet updatedRs;
				try {
					updatedRs = AAADAO.selectAll();
					loadRsToTable(updatedRs);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
			}
		});
		//setting view for delete view
		buttonXoa.setForeground(Color.WHITE);
		buttonXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonXoa.setBackground(new Color(192, 192, 192));
		buttonXoa.setBounds(311, 250, 212, 39);
		panel_1.add(buttonXoa);
		
		//create cancel button
		buttonHuy = new BtnCS();
		buttonHuy.setColorClick(new Color(156, 156, 156));
		buttonHuy.setColor(new Color(128, 128, 128));
		buttonHuy.setBorderColor(new Color(128, 128, 128));
		buttonHuy.setColorOver(new Color(156,156,156));
		buttonHuy.setText("HỦY");
		buttonHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clear form
                tfHoVaTen.setText("");
                tfEmail.setText("");
                tfSDT.setText("");
                tfMK.setText("");
                cbQuyen.setSelectedIndex(0);
                buttonCreateAccount.setVisible(true);
                tfEmail.setEditable(true);
			}
		});
		//setting view for cancel button
		buttonHuy.setForeground(Color.WHITE);
		buttonHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonHuy.setBackground(new Color(128, 128, 128));
		buttonHuy.setBounds(552, 250, 202, 39);
		panel_1.add(buttonHuy);
		
		
		//-----------Create and process for save permission group -----------------------------------
		buttonLuuAp = new BtnCS();
		buttonLuuAp.setColor(new Color(3, 4, 94));
		buttonLuuAp.setBorderColor(new Color(3, 4, 94));
		buttonLuuAp.setText("LƯU");
		buttonLuuAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//string to save permission flag
				String ACNV = "";
				String ACSQT = "";
				String ACQT = "";
				String ACBGD ="";
				//list radio button
				RadioButtonCustom[] nhanVienRadios = {rdbtnNhanVien1, rdbtnNhanVien2, rdbtnNhanVien3, rdbtnNhanVien4, rdbtnNhanVien5, rdbtnNhanVien6};
				RadioButtonCustom[] sieuQuanTriRadios = {rdbtnSQTChuyenBay, rdbtnSQTVeChuyenBay,rdbtnSQTMayBay, rdbtnSQLTKvaPP, rdbtnSQTCaiDat,rdbtnSQTChatBox};
				RadioButtonCustom[] quanTriRadios = {rdbtnQTChuyenBay, rdbtnQTVeChuyenBay, rdbtnQTMayBay, rdbtnQTTKvaPQ, rdbtnQTCaiDat, rdbtnQTChatBox};
				RadioButtonCustom[] bGDRadios = {rdbtnBGDChuyenBay, rdbtnBGDVeChuyenBay, rdbtnBGDMayBay, rdbtnBGDTKvaPQ, rdbtnBGDCaiDat, rdbtnBGDChatBox};
				
				//super admin
				boolean tkvaPPSelected = rdbtnSQLTKvaPP.isSelected();
				if(tkvaPPSelected == false) {
					
					try {
						JOptionPane.showMessageDialog(null, "Không được tắt quyền Tài Khoảng và Phân Quyền trên Siêu Quản Trị");
						loadPermit();
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					for (RadioButtonCustom radioButton : sieuQuanTriRadios) {
			            if (radioButton.isSelected()) {
			                ACSQT+= "1";
			            } else {
			                ACSQT += "0";
			            }
			        }
					
					//Admin
					for (RadioButtonCustom radioButton : quanTriRadios) {
			            if (radioButton.isSelected()) {
			                ACQT += "1";
			            } else {
			                ACQT += "0";
			            }
			        }
					//CEO
					for (RadioButtonCustom radioButton : bGDRadios) {
			            if (radioButton.isSelected()) {
			                ACBGD += "1";
			            } else {
			                ACBGD += "0";
			            }
			        }
					//Staff
			        for (RadioButtonCustom radioButton : nhanVienRadios) {
			            if (radioButton.isSelected()) {
			                ACNV += "1";
			            } else {
			                ACNV += "0";
			            }
			        }   
			        try {
						PermissionDAO.setFlagPermit(ACSQT,"RL0001");
						PermissionDAO.setFlagPermit(ACQT,"RL0002");
						PermissionDAO.setFlagPermit(ACBGD,"RL0003");
						PermissionDAO.setFlagPermit(ACNV,"RL0004");
						JOptionPane.showMessageDialog(null, "Lưu thành công!");
						loadPermit();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		//setting view for save
		buttonLuuAp.setForeground(Color.WHITE);
		buttonLuuAp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonLuuAp.setBackground(new Color(3, 4, 94));
		buttonLuuAp.setBounds(1328, 5, 151, 39);
		add(buttonLuuAp);
		
		//click row in account table event
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow(); // Lấy dòng được chọn
		        if (row != -1) { // Kiểm tra xem một dòng nào đó đã được chọn không
		            String email = table.getValueAt(row, 1).toString(); // Lấy giá trị của cột "Email"
		            try (ResultSet rs = AAADAO.findACbyEmail(email)) {
		                // Xử lý ResultSet để trích xuất dữ liệu
		                if (rs.next()) {
		                    // Ví dụ: lấy dữ liệu từ ResultSet
		                	tfHoVaTen.setText(rs.getString("Name"));
		                	tfEmail.setText(rs.getString("Email"));
		                	tfSDT.setText(rs.getString("Phone"));
		                	tfMK.setText(rs.getString("Password"));
		                	if ("RL0001".equals(rs.getString("RoleID"))) {
		                	    cbQuyen.setSelectedIndex(0);
		                	}
		                	if ("RL0002".equals(rs.getString("RoleID"))) {
		                	    cbQuyen.setSelectedIndex(1);
		                	}
		                	if ("RL0003".equals(rs.getString("RoleID"))) {
		                	    cbQuyen.setSelectedIndex(2);
		                	}
		                	if ("RL0004".equals(rs.getString("RoleID"))) {
		                	    cbQuyen.setSelectedIndex(3);
		                	}
		                	buttonCreateAccount.setVisible(false);
		                	tfEmail.setEditable(false); // Đặt trường văn bản thành không thể chỉnh sửa
		                    // Hiển thị thông tin tài khoản hoặc thực hiện các thao tác khác ở đây
		                } else {
		                    // Không có tài khoản nào được tìm thấy
		                }
		            } catch (SQLException | ClassNotFoundException ex) {
		                ex.printStackTrace();
		                // Xử lý ngoại lệ
		            }
		        }
			}
		});
		
		loadPermit();
	}
	
	//--------------------------function-------------------------------------------
	//function generate account function
	public static String generateUniqueAccountId() {
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
		private static String generateRandomDigits(int length) {
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

