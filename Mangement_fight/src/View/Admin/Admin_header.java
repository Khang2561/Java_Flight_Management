package View.Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import View.Login.FormLogin;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_header extends JPanel {

	public static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	
	
	public Admin_header() {
		setBackground(new Color(245, 245, 248));
		setBounds(0, 0, 1500, 80);
		setLayout(null);
		setLayout(null);
		
		Button button = new Button("Chuyến bay ");
		button.setBackground(new Color(245, 245, 248));
		button.setForeground(new Color(0, 0, 0));
		button.setBounds(228, 21, 128, 38);
		add(button);
		
		Button button_1 = new Button("Vé máy bay");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(245, 245, 248));
		button_1.setBounds(441, 21, 128, 38);
		add(button_1);
		
		Button button_1_1 = new Button("Máy bay");
		
		button_1_1.setForeground(Color.BLACK);
		button_1_1.setBackground(new Color(245, 245, 248));
		button_1_1.setBounds(676, 21, 128, 38);
		add(button_1_1);
		
		Button button_1_1_1 = new Button("Tài khoảng và quyền ");
		button_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1_1_1.setForeground(Color.BLACK);
		button_1_1_1.setBackground(new Color(245, 245, 248));
		button_1_1_1.setBounds(911, 21, 128, 38);
		add(button_1_1_1);
		
		Button button_1_1_1_1 = new Button("Cài đặt");
		button_1_1_1_1.setForeground(Color.BLACK);
		button_1_1_1_1.setBackground(new Color(245, 245, 248));
		button_1_1_1_1.setBounds(1125, 21, 128, 38);
		add(button_1_1_1_1);
		//logo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin_header.class.getResource("/Resource/LogoMAT_180x40.png")));
		lblNewLabel.setBounds(0, 0, 140, 80);
		add(lblNewLabel);
		
		
		
		
	}
}
