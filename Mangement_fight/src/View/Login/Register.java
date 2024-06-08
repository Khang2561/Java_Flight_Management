package View.Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CustomUI.BtnCS;
import CustomUI.JpwfCS;
import CustomUI.JtfCS;
import CustomUI.LayeredPaneRound;
import CustomUI.PanelRound;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JPanel {

	private static final long serialVersionUID = 1L;
    private static JtfCS txtUsername;
    private static JpwfCS txtPassword;
    private static JpwfCS txtConfirmPassword;
    private static JtfCS txtEmail;
    private static JtfCS txtPhoneNumber;
    public JLabel lblLogin;
    private JLabel lblNewLabel;
    private JLabel lblEmail;
    private JLabel lblS;
    private JLabel lblMtKhu;
    private JLabel lblNhpLiMt;
    BtnCS btnSignUp;
    
    public static String getUsernameText() {
    	return txtUsername.getText();
    }
    
    public static String getPhoneNumberText() {
    	return txtPhoneNumber.getText();
    }
    
    public static String getEmailText() {
    	return txtEmail.getText();
    }
    
    public static String getPasswordText() {
    	return txtPassword.getText();
    }
    
    public static String getConfirmPasswordText() {
    	return txtConfirmPassword.getText();
    }

	/**
	 * Create the panel.
	 */
	public Register() {
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);
		setBackground(null);
		
		  // Create a JLayeredPane
		LayeredPaneRound layeredPane = new LayeredPaneRound();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setRoundTopRight(50);
		layeredPane.setRoundTopLeft(50);
		layeredPane.setRoundBottomRight(50);
		layeredPane.setRoundBottomLeft(50);
        layeredPane.setLayout(null);
        layeredPane.setBounds(0, 0, 300, 406);
        add(layeredPane);
		
		JLabel lbl1 = new JLabel("Tạo tài khoản");
		lbl1.setForeground(new Color(0, 0, 128));
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl1.setBounds(73, 22, 149, 29);
		layeredPane.add(lbl1);
		
		txtUsername = new JtfCS();
		txtUsername.setRound(20);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setBounds(38, 74, 225, 40);
		layeredPane.add(txtUsername, JLayeredPane.DEFAULT_LAYER);
		txtUsername.setColumns(10);
		
		txtPassword = new JpwfCS();
		txtPassword.setRound(20);
		txtPassword.setBounds(38, 224, 225, 39);
		layeredPane.add(txtPassword, JLayeredPane.DEFAULT_LAYER);
		
		txtConfirmPassword = new JpwfCS();
		txtConfirmPassword.setRound(20);
		txtConfirmPassword.setBounds(38, 276, 225, 39);
		layeredPane.add(txtConfirmPassword, JLayeredPane.DEFAULT_LAYER);
		
		txtEmail = new JtfCS();
		txtEmail.setRound(20);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(38, 124, 225, 41);
		layeredPane.add(txtEmail, JLayeredPane.DEFAULT_LAYER);
		
		txtPhoneNumber = new JtfCS();
		txtPhoneNumber.setRound(20);
		txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(38, 175, 225, 39);
		layeredPane.add(txtPhoneNumber, JLayeredPane.DEFAULT_LAYER);
		
		btnSignUp = new BtnCS();
		btnSignUp.setRadius(30);
		btnSignUp.setText("Đăng ký");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 18));
		btnSignUp.setBackground(new Color(3, 4, 94));
		btnSignUp.setBounds(38, 339, 225, 32);
		layeredPane.add(btnSignUp);
		
		JLabel lbl2 = new JLabel("Đã có tài khoản?");
		lbl2.setForeground(new Color(113, 113, 122));
		lbl2.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl2.setBounds(73, 381, 112, 15);
		layeredPane.add(lbl2);
		
		lblLogin = new JLabel("Đăng nhập");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblLogin.setForeground(new Color(128, 152, 249));
		lblLogin.setFont(new Font("Arial", Font.BOLD, 12));
		lblLogin.setBounds(168, 381, 73, 15);
		layeredPane.add(lblLogin, JLayeredPane.DEFAULT_LAYER);
		
		JLabel lblShowAndHidePassword_1 = Utils.lblShowAndHidePassword(txtPassword, 20, 20);
		lblShowAndHidePassword_1.setBounds(238, 233, 20, 20);
		layeredPane.add(lblShowAndHidePassword_1, JLayeredPane.POPUP_LAYER);
		
		JLabel lblShowAndHidePassword_2 = Utils.lblShowAndHidePassword(txtConfirmPassword, 20, 20);
		lblShowAndHidePassword_2.setBounds(238, 285, 20, 20);
		layeredPane.add(lblShowAndHidePassword_2, JLayeredPane.POPUP_LAYER);
		
		lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(38, 61, 73, 14);
		layeredPane.add(lblNewLabel);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBounds(38, 112, 73, 14);
		layeredPane.add(lblEmail);
		
		lblS = new JLabel("Số điện thoại");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblS.setForeground(new Color(0, 0, 0));
		lblS.setBounds(38, 162, 73, 14);
		layeredPane.add(lblS);
		
		lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMtKhu.setForeground(new Color(0, 0, 0));
		lblMtKhu.setBounds(38, 213, 73, 14);
		layeredPane.add(lblMtKhu);
		
		lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNhpLiMt.setForeground(new Color(0, 0, 0));
		lblNhpLiMt.setBounds(38, 262, 106, 14);
		layeredPane.add(lblNhpLiMt);
	}
}
