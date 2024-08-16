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


public class RegisterOTP extends PanelRound {

	private static final long serialVersionUID = 1L;
	private static JtfCS txtOTP;
	JLabel lblReturn;
	JLabel lblResend;
	BtnCS btnAcceptOTP;
	
	public static String getOTPText() {
		return txtOTP.getText();
	}
	
	/**
	 * Create the panel.
	 */
	public RegisterOTP() {
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
        txtOTP.setBounds(38, 110, 225, 44);
        add(txtOTP);
        txtOTP.setColumns(10);
        
        btnAcceptOTP = new BtnCS();
        btnAcceptOTP.setRadius(30);
        btnAcceptOTP.setText("Xác nhận");
        btnAcceptOTP.setForeground(new Color(255, 255, 255));
        btnAcceptOTP.setBackground(new Color(3, 4, 94));
        btnAcceptOTP.setFont(new Font("Times New Roman", Font.BOLD, 19));
        btnAcceptOTP.setBounds(38, 179, 225, 30);
        add(btnAcceptOTP);
        
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
         
	}
}
