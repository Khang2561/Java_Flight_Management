package View.Login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JPasswordField;

public class ForgotPassword3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmPassword;

	/**
	 * Create the panel.
	 */
	public ForgotPassword3() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);

        JLabel lbl1 = new JLabel("Nhập mật khẩu mới");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lbl1.setBounds(53, 41, 237, 29);
        add(lbl1);
        
        Button btnAccept = new Button("Xác nhận");
        btnAccept.setBackground(new Color(128, 152, 249));
        btnAccept.setForeground(new Color(255, 255, 255));
        btnAccept.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnAccept.setBounds(39, 217, 225, 32);
        add(btnAccept);
        
        txtNewPassword = new JPasswordField();
        txtNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        txtNewPassword.setBounds(38, 124, 225, 30);
        add(txtNewPassword);
        
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        txtConfirmPassword.setBounds(38, 165, 225, 30);
        add(txtConfirmPassword);
        
		JLabel lblReturn = new JLabel("");
		lblReturn.setIcon(new ImageIcon(FormLogin.class.getResource("/Resource/return.png")));
		lblReturn.setBounds(10, 10, 38, 22);
		add(lblReturn);
		
		JLabel lblNewLabel = new JLabel("Hoàn thành việc khôi phục mật khẩu của bạn");
		lblNewLabel.setForeground(new Color(113, 113, 122));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 81, 252, 15);
		add(lblNewLabel);
	}
}
