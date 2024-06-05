package View.Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CustomUI.BtnCS;
import CustomUI.JtfCS;
import CustomUI.PanelRound;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ForgotPassword1 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static JtfCS txtEmail;
	public JLabel lblReturn;
	BtnCS btnGetOTP;
		
	public static String getEmailText() {
	    return txtEmail.getText();
	}


	/**
	 * Create the panel.
	 */
	public ForgotPassword1() {

		setBackground(new Color(0, 255, 0));
		setLayout(null);
		setBackground(null);
		
		PanelRound panel = new PanelRound();
		panel.setRoundTopRight(50);
		panel.setRoundTopLeft(50);
		panel.setRoundBottomRight(50);
		panel.setRoundBottomLeft(50);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 10, 296, 386);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbl1 = new JLabel("Quên mật khẩu");
		lbl1.setFont(new Font("Arial", Font.BOLD, 24));
		lbl1.setBounds(66, 46, 172, 28);
		panel.add(lbl1);
		
		txtEmail = new JtfCS();
		txtEmail.setBounds(41, 104, 225, 40);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập email của bạn và nhận mã OTP để xác minh ");
		lblNewLabel.setForeground(new Color(113, 113, 122));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(31, 79, 242, 15);
		panel.add(lblNewLabel);
		
		btnGetOTP = new BtnCS();
		btnGetOTP.setRadius(30);
		btnGetOTP.setFont(new Font("Arial", Font.BOLD, 17));
		btnGetOTP.setText("Lấy mã OTP");
		
		btnGetOTP.setBackground(new Color(3, 4, 94));
		btnGetOTP.setForeground(new Color(255, 255, 255));
		btnGetOTP.setBounds(41, 154, 225, 40);
		panel.add(btnGetOTP);
		
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
		lblReturn.setBounds(10, 5, 24, 24);
		panel.add(lblReturn);
		
		
	}
}
