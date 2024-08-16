package View.Login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JPasswordField;

import CustomUI.BtnCS;
import CustomUI.JpwfCS;
import CustomUI.LayeredPaneRound;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPassword3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JpwfCS txtNewPassword;
	private static JpwfCS txtConfirmPassword;
	static String email;
	BtnCS btnAccept;
	JLabel lblReturn;
	
	public static String getNewPasswordText() {
		return txtNewPassword.getText();
	}
	
	public static String getConfirmPasswordText() {
		return txtConfirmPassword.getText();
	}
	/**
	 * Create the panel.
	 */
	public ForgotPassword3() {
		
		setBackground(null);
		setBounds(100, 100, 300, 406);
		setLayout(null);
		
        // Create a JLayeredPane
		LayeredPaneRound layeredPane = new LayeredPaneRound();
		layeredPane.setRoundTopRight(50);
		layeredPane.setRoundTopLeft(50);
		layeredPane.setRoundBottomRight(50);
		layeredPane.setRoundBottomLeft(50);
        layeredPane.setBounds(0, 0, 300, 406);
        layeredPane.setBackground(Color.WHITE);
        layeredPane.setLayout(null);
        add(layeredPane);

        JLabel lbl1 = new JLabel("Nhập mật khẩu mới");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lbl1.setBounds(53, 41, 237, 29);
        layeredPane.add(lbl1);
        
        btnAccept = new BtnCS();
        btnAccept.setRadius(30);
        btnAccept.setText("Xác nhận");
        btnAccept.setBackground(new Color(3,4,94));
        btnAccept.setForeground(new Color(255, 255, 255));
        btnAccept.setFont(new Font("Times New Roman", Font.BOLD, 19));
        btnAccept.setBounds(38, 243, 225, 32);
        layeredPane.add(btnAccept, JLayeredPane.DEFAULT_LAYER);
        
        txtNewPassword = new JpwfCS();
        txtNewPassword.setRound(20);
        txtNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        txtNewPassword.setBounds(38, 124, 225, 44);
        layeredPane.add(txtNewPassword, JLayeredPane.DEFAULT_LAYER);
        
        txtConfirmPassword = new JpwfCS();
        txtConfirmPassword.setRound(20);
        txtConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        txtConfirmPassword.setBounds(38, 188, 225, 44);
        layeredPane.add(txtConfirmPassword, JLayeredPane.DEFAULT_LAYER);
        
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
		layeredPane.add(lblReturn, JLayeredPane.DEFAULT_LAYER);
		
		JLabel lblNewLabel = new JLabel("Hoàn thành việc khôi phục mật khẩu của bạn");
		lblNewLabel.setForeground(new Color(113, 113, 122));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 81, 252, 15);
		layeredPane.add(lblNewLabel);
		
        JLabel lblShowAndHidePassword_1 =  Utils.lblShowAndHidePassword(txtNewPassword, 20, 20);
        lblShowAndHidePassword_1.setBounds(238, 133, 20, 20);  // Adjust the position as needed
        layeredPane.add(lblShowAndHidePassword_1, JLayeredPane.POPUP_LAYER);
        
        JLabel lblShowAndHidePassword_2 = Utils.lblShowAndHidePassword(txtConfirmPassword, 20, 20);
        lblShowAndHidePassword_2.setBounds(238, 197, 20, 20);
        layeredPane.add(lblShowAndHidePassword_2, JLayeredPane.POPUP_LAYER);
        
        JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNewLabel_1.setForeground(new Color(128, 128, 128));
        lblNewLabel_1.setBounds(38, 109, 87, 14);
        layeredPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNewLabel_1_1.setForeground(Color.GRAY);
        lblNewLabel_1_1.setBounds(38, 167, 110, 14);
        layeredPane.add(lblNewLabel_1_1);
	}
}
