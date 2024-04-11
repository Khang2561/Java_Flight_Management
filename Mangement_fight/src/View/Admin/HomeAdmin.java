package View.Admin;

import javax.swing.JPanel;

import View.Login.FormLogin;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class HomeAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	//chung to da thay doi 
	/**
	 * Create the panel.
	 */
	public HomeAdmin() {
		setBounds(0, 71, 1500, 642);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeAdmin.class.getResource("/Resource/HomeAdminImg-removebg-preview.png")));
		lblNewLabel.setBounds(331, 221, 883, 283);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ HOẠT ĐỘNG BAY HIỆU QUẢ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 93, 1512, 88);
		add(lblNewLabel_1);
	}

}
