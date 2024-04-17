package View.Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ForgotPassword1 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtEmail;
	public JLabel lblReturn;

	/**
	 * Create the panel.
	 */
	public ForgotPassword1() {

		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lbl1 = new JLabel("Quên mật khẩu");
		lbl1.setFont(new Font("Arial", Font.BOLD, 24));
		lbl1.setBounds(64, 41, 186, 29);
		add(lbl1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(38, 110, 225, 30);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập email của bạn và nhận mã OTP để xác minh ");
		lblNewLabel.setForeground(new Color(113, 113, 122));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(38, 81, 282, 15);
		add(lblNewLabel);
		
		Button btnGetOTP = new Button("Lấy mã OTP");
		btnGetOTP.setBackground(new Color(128, 152, 249));
		btnGetOTP.setForeground(new Color(255, 255, 255));
		btnGetOTP.setBounds(38, 162, 225, 32);
		add(btnGetOTP);
		
		lblReturn = new JLabel("");
		lblReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblReturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblReturn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblReturn.setIcon(new ImageIcon(FormLogin.class.getResource("/Resource/return.png")));
		lblReturn.setBounds(10, 10, 38, 22);
		add(lblReturn);
	}

}
