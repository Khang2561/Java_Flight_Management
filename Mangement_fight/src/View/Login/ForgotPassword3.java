package View.Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ForgotPassword3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JPasswordField txtNewPassword;
	private static JPasswordField txtConfirmPassword;
	static String email;
	Button btnAccept;
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

		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 300, 406);
        add(layeredPane);

        JLabel lbl1 = new JLabel("Nhập mật khẩu mới");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lbl1.setBounds(53, 41, 237, 29);
        add(lbl1);

        btnAccept = new Button("Xác nhận");
        btnAccept.setBackground(new Color(128, 152, 249));
        btnAccept.setForeground(new Color(255, 255, 255));
        btnAccept.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnAccept.setBounds(39, 217, 225, 32);
        layeredPane.add(btnAccept);

        txtNewPassword = new JPasswordField();
        txtNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        txtNewPassword.setBounds(38, 124, 225, 30);
        layeredPane.add(txtNewPassword, JLayeredPane.DEFAULT_LAYER);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        txtConfirmPassword.setBounds(38, 176, 225, 30);
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
		add(lblNewLabel);

        JLabel lblShowAndHidePassword_1 =  Utils.lblShowAndHidePassword(txtNewPassword, 20, 20);
        lblShowAndHidePassword_1.setBounds(240, 127, 20, 20);  // Adjust the position as needed
        layeredPane.add(lblShowAndHidePassword_1, JLayeredPane.POPUP_LAYER);

        JLabel lblShowAndHidePassword_2 = Utils.lblShowAndHidePassword(txtConfirmPassword, 20, 20);
        lblShowAndHidePassword_2.setBounds(240, 179, 20, 20);
        layeredPane.add(lblShowAndHidePassword_2, JLayeredPane.POPUP_LAYER);

        JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
        lblNewLabel_1.setForeground(new Color(128, 128, 128));
        lblNewLabel_1.setBounds(38, 109, 87, 14);
        layeredPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu");
        lblNewLabel_1_1.setForeground(Color.GRAY);
        lblNewLabel_1_1.setBounds(38, 162, 110, 14);
        layeredPane.add(lblNewLabel_1_1);
	}
}
