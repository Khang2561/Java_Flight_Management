package View.Login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.JTextField;

import CustomUI.BtnCS;
import CustomUI.JpwfCS;
import CustomUI.JtfCS;
import CustomUI.LayeredPaneRound;
import DAO.AAADAO;
import DAO.PermissionDAO;
import Model.Account;
import View.Admin.Admin_header;
import View.Admin.FormAdmin;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;



public class loggin_form extends JPanel {

    public static final long serialVersionUID = 1L;
    private JLabel lblShowAndHidePassword;
    private JtfCS txtUsername;
    private JpwfCS txtPassword;
    public JLabel lblForgotPassword;
    private JLabel lbl2;
    public JLabel lblSignUp;
    
    public loggin_form(FormLogin formLogin, FormAdmin formAdmin) {
    	
    	setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);
		
        // Create a JLayeredPane
		LayeredPaneRound layeredPane = new LayeredPaneRound();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setRoundTopRight(50);
		layeredPane.setRoundTopLeft(50);
		layeredPane.setRoundBottomRight(50);
		layeredPane.setRoundBottomLeft(50);
        layeredPane.setBounds(0, 0, 300, 406);
        add(layeredPane);
        layeredPane.setLayout(null);
		
        txtUsername = new JtfCS();
        txtUsername.setBounds(38, 110, 225, 44);
        txtUsername.setRound(20);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        layeredPane.add(txtUsername, JLayeredPane.DEFAULT_LAYER);  // Add to default layer
        txtUsername.setColumns(10);
		
        txtPassword = new JpwfCS();
        txtPassword.setRound(20);
        txtPassword.setBounds(38, 176, 225, 44);
        layeredPane.add(txtPassword, JLayeredPane.DEFAULT_LAYER);
		
		lblForgotPassword = new JLabel("Quên mật khẩu");
		lblForgotPassword.setBounds(158, 221, 105, 17);
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotPassword.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblForgotPassword.setForeground(new Color(128, 152, 249));
		lblForgotPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		layeredPane.add(lblForgotPassword);
		
		lbl2 = new JLabel("Chưa có tài khoản?");
		lbl2.setBackground(new Color(0, 0, 0));
		lbl2.setForeground(new Color(113, 113, 122));
		lbl2.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl2.setBounds(66, 295, 112, 15);
		layeredPane.add(lbl2);
		
		lblSignUp = new JLabel("Đăng ký");
		lblSignUp.setBounds(179, 295, 58, 15);
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblSignUp.setForeground(new Color(128, 152, 249));
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 12));
		layeredPane.add(lblSignUp);
		
		BtnCS btnLogin = new BtnCS();
		btnLogin.setBounds(38, 245, 225, 32);
		btnLogin.setRadius(30);
		btnLogin.setText("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String username = txtUsername.getText();
					String password = txtPassword.getText();
					
					 // Create an instance of AAADAO
		            AAADAO dao = AAADAO.getInstance();
		            
		            // Call the login method
		            Account account = dao.login(username, password, formLogin, formAdmin);
		            
		            PermissionDAO permisson = new PermissionDAO();
		            
		            String permissonCode = permisson.getPMS(account.getRoleID());
		            
		            // Get the single instance of Admin_header
	                Admin_header adminHeader = Admin_header.getInstance();
		            
		            permisson.setPermsionAccess(permissonCode, adminHeader.buttons);
					
				}catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnLogin.setBackground(new Color(3, 4, 94));
		layeredPane.add(btnLogin, JLayeredPane.DEFAULT_LAYER);
		
        // Create the show/hide password label
        lblShowAndHidePassword =  Utils.lblShowAndHidePassword(txtPassword, 20, 20);
        lblShowAndHidePassword.setBounds(238, 185, 20, 20);  // Adjust the position as needed
        layeredPane.add(lblShowAndHidePassword, JLayeredPane.POPUP_LAYER);
        
        JLabel lblNewLabel = new JLabel("Email hoặc số điện thoại");
        lblNewLabel.setBounds(38, 95, 165, 14);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setForeground(new Color(128, 128, 128));
        layeredPane.add(lblNewLabel);
        
        JLabel lblMtKhu = new JLabel("Mật khẩu");
        lblMtKhu.setBounds(38, 153, 165, 14);
        lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMtKhu.setForeground(Color.GRAY);
        layeredPane.add(lblMtKhu);
        
        JLabel lbl1 = new JLabel("Đăng nhập");
        lbl1.setBounds(78, 39, 138, 29);
        layeredPane.add(lbl1);
        lbl1.setForeground(new Color(3, 4, 94));
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
    }
}