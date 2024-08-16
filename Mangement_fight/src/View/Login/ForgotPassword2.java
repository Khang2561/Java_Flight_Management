package View.Login;

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

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ForgotPassword2 extends PanelRound {

	private static final long serialVersionUID = 1L;
	private static JtfCS txtOTP;
	JLabel lblReturn;
	JLabel lblResend;
	BtnCS btnAccept;
	
	public static String getOTPText() {
		return txtOTP.getText();
	}
	
	/**
	 * Create the panel.
	 */
	public ForgotPassword2() {
		setRoundTopRight(50);
		setRoundTopLeft(50);
		setRoundBottomRight(50);
		setRoundBottomLeft(50);
		
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
        
        txtOTP = new JtfCS();
        txtOTP.setRound(20);
        txtOTP.setBounds(38, 110, 225, 44);
        add(txtOTP);
        txtOTP.setColumns(10);
        
        btnAccept = new BtnCS();
        btnAccept.setRadius(30);
        btnAccept.setText("Xác nhận");
        btnAccept.setForeground(new Color(255, 255, 255));
        btnAccept.setBackground(new Color(3, 4, 94));
        btnAccept.setFont(new Font("Times New Roman", Font.BOLD, 19));
        btnAccept.setBounds(38, 179, 225, 30);
        add(btnAccept);
        
        lblResend = new JLabel("Gửi lại OTP");
        lblResend.addMouseListener(new MouseAdapter() {       	
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblResend.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblResend.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        });
        lblResend.setForeground(new Color(128, 152, 249));
        lblResend.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblResend.setBounds(197, 154, 80, 15);
        add(lblResend);
        
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
