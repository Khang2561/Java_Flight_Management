package View.Login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Button;

public class ForgotPassword2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtOTP;

	/**
	 * Create the panel.
	 */
	public ForgotPassword2() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);
		

        JLabel lbl1 = new JLabel("Nhập mã OTP");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl1.setBounds(69, 38, 186, 29);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Đã gửi mã OTP");
        lbl2.setForeground(new Color(113, 113, 122));
        lbl2.setBackground(new Color(255, 255, 255));
        lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lbl2.setBounds(98, 68, 91, 15);
        add(lbl2);
        
        txtOTP = new JTextField();
        txtOTP.setBounds(38, 110, 225, 30);
        add(txtOTP);
        txtOTP.setColumns(10);
        
        Button btnAccept = new Button("Xác nhận");
        btnAccept.setForeground(new Color(255, 255, 255));
        btnAccept.setBackground(new Color(128, 152, 249));
        btnAccept.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnAccept.setBounds(38, 179, 225, 30);
        add(btnAccept);
        
        JLabel lblResend = new JLabel("Gửi lại OTP");
        lblResend.setForeground(new Color(128, 152, 249));
        lblResend.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblResend.setBounds(200, 146, 80, 15);
        add(lblResend);
        
		JLabel lblReturn = new JLabel("");
		lblReturn.setIcon(new ImageIcon(FormLogin.class.getResource("/Resource/return.png")));
		lblReturn.setBounds(10, 10, 38, 22);
		add(lblReturn);
        
	}
}
