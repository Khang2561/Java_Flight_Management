package View.Login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Button;

public class loggin_form extends JPanel {

    public static final long serialVersionUID = 1L;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblForgotPassword;
    private JLabel lbl2;
    private JLabel lblSignUp;

    public loggin_form() {
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setBounds(38, 110, 225, 28);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(38, 162, 225, 28);
		add(txtPassword);
		
		JLabel lbl1 = new JLabel("Đăng nhập");
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl1.setBounds(86, 41, 138, 29);
		add(lbl1);
		
		lblForgotPassword = new JLabel("Quên mật khẩu");
	
		lblForgotPassword.setForeground(new Color(128, 152, 249));
		lblForgotPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblForgotPassword.setBounds(163, 203, 105, 17);
		add(lblForgotPassword);
		
		lbl2 = new JLabel("Chưa có tài khoản?");
		lbl2.setForeground(new Color(113, 113, 122));
		lbl2.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl2.setBounds(66, 295, 112, 15);
		add(lbl2);
		
		lblSignUp = new JLabel("Đăng ký");
		lblSignUp.setForeground(new Color(128, 152, 249));
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 12));
		lblSignUp.setBounds(179, 295, 58, 15);
		add(lblSignUp);
		
		Button btnLogin = new Button("Đăng nhập");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		btnLogin.setBackground(new Color(128, 152, 249));
		btnLogin.setBounds(38, 245, 225, 32);
		add(btnLogin);
    }
}