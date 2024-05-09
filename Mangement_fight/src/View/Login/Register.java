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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JPanel {

	private static final long serialVersionUID = 1L;
    private static JTextField txtUsername;
    private static JPasswordField txtPassword;
    private static JPasswordField txtConfirmPassword;
    private static JTextField txtEmail;
    private static JTextField txtPhoneNumber;
    public JLabel lblLogin;
    private JLabel lblNewLabel;
    private JLabel lblEmail;
    private JLabel lblS;
    private JLabel lblMtKhu;
    private JLabel lblNhpLiMt;
    Button btnSignUp;
    
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
		
		  // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 300, 406);
        add(layeredPane);
		
		JLabel lbl1 = new JLabel("Tạo tài khoản");
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl1.setBounds(73, 41, 149, 29);
		add(lbl1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setBounds(38, 85, 225, 28);
		layeredPane.add(txtUsername, JLayeredPane.DEFAULT_LAYER);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(38, 202, 225, 28);
		layeredPane.add(txtPassword, JLayeredPane.DEFAULT_LAYER);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(38, 247, 225, 28);
		layeredPane.add(txtConfirmPassword, JLayeredPane.DEFAULT_LAYER);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(38, 124, 225, 28);
		layeredPane.add(txtEmail, JLayeredPane.DEFAULT_LAYER);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(38, 163, 225, 28);
		layeredPane.add(txtPhoneNumber, JLayeredPane.DEFAULT_LAYER);
		
		btnSignUp = new Button("Đăng ký");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSignUp.setBackground(new Color(128, 152, 249));
		btnSignUp.setBounds(38, 281, 225, 32);
		layeredPane.add(btnSignUp);
		
		JLabel lbl2 = new JLabel("Đã có tài khoản?");
		lbl2.setForeground(new Color(113, 113, 122));
		lbl2.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl2.setBounds(73, 323, 112, 15);
		add(lbl2);
		
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
		lblLogin.setBounds(168, 323, 73, 15);
		layeredPane.add(lblLogin, JLayeredPane.DEFAULT_LAYER);
		
		JLabel lblShowAndHidePassword_1 = Utils.lblShowAndHidePassword(txtPassword, 20, 20);
		lblShowAndHidePassword_1.setBounds(240, 205, 20, 20);
		layeredPane.add(lblShowAndHidePassword_1, JLayeredPane.POPUP_LAYER);
		
		JLabel lblShowAndHidePassword_2 = Utils.lblShowAndHidePassword(txtConfirmPassword, 20, 20);
		lblShowAndHidePassword_2.setBounds(240, 250, 20, 20);
		layeredPane.add(lblShowAndHidePassword_2, JLayeredPane.POPUP_LAYER);
		
		lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setBounds(38, 72, 73, 14);
		layeredPane.add(lblNewLabel);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setBounds(38, 112, 73, 14);
		layeredPane.add(lblEmail);
		
		lblS = new JLabel("Số điện thoại");
		lblS.setForeground(Color.GRAY);
		lblS.setBounds(38, 150, 73, 14);
		layeredPane.add(lblS);
		
		lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setForeground(Color.GRAY);
		lblMtKhu.setBounds(38, 191, 73, 14);
		layeredPane.add(lblMtKhu);
		
		lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setForeground(Color.GRAY);
		lblNhpLiMt.setBounds(38, 233, 106, 14);
		layeredPane.add(lblNhpLiMt);
	}
}
