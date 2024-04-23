package View.Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JPanel {

	private static final long serialVersionUID = 1L;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JTextField txtEmail;
    private JTextField txtPhoneNumber;
    public JLabel lblLogin;

	/**
	 * Create the panel.
	 */
	public Register() {
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);
		
		JLabel lbl1 = new JLabel("Tạo tài khoản");
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl1.setBounds(73, 41, 149, 29);
		add(lbl1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setBounds(38, 91, 225, 28);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(38, 208, 225, 28);
		add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(38, 247, 225, 28);
		add(txtConfirmPassword);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(38, 130, 225, 28);
		add(txtEmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(38, 169, 225, 28);
		add(txtPhoneNumber);
		
		Button btnSignUp = new Button("Đăng ký");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSignUp.setBackground(new Color(128, 152, 249));
		btnSignUp.setBounds(38, 281, 225, 32);
		add(btnSignUp);
		
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
		add(lblLogin);
	}
}
