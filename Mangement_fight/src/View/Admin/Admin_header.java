package View.Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import View.Admin.AccountAndPermission.AccountAndPermission;
import View.Admin.ChatBox.ChatBox;
import View.Admin.Setting.Setting;
import View.Login.FormLogin;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;

public class Admin_header extends JPanel {

	public static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	
	
	public Admin_header() {
		setBackground(new Color(245, 245, 248));
		setBounds(0, 0, 1500, 80);
		setLayout(null);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//logo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin_header.class.getResource("/Resource/LogoMAT_180x40.png")));
		add(lblNewLabel);
		
		Button button = new Button("Chuyến bay ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		button.setBackground(new Color(245, 245, 248));
		button.setForeground(new Color(0, 0, 0));
		add(button);
		
		Button button_1 = new Button("Vé máy bay");
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setBackground(new Color(245, 245, 248));
		add(button_1);
		
		Button button_1_1 = new Button("Máy bay");
		button_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		button_1_1.setForeground(new Color(0, 0, 0));
		button_1_1.setBackground(new Color(245, 245, 248));
		add(button_1_1);
		
		Button button_1_1_1 = new Button("Tài khoảng và quyền ");
		button_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		button_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel aap = new AccountAndPermission();
				aap.setSize(1500, 653);
				aap.setLocation(0, 70);
		        FormAdmin.contentPane.add(aap);
		        FormAdmin.contentPane.revalidate();
		        FormAdmin.contentPane.repaint();
			}
		});
		button_1_1_1.setForeground(new Color(0, 0, 0));
		button_1_1_1.setBackground(new Color(245, 245, 248));
		add(button_1_1_1);
		
		Button button_1_1_1_1_1 = new Button("Cài đặt");
		button_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel setting = new Setting();
				setting.setSize(1500, 653);
				setting.setLocation(0, 70);
		        FormAdmin.contentPane.add(setting);
		        FormAdmin.contentPane.revalidate();
		        FormAdmin.contentPane.repaint();
			}
		});
		button_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		button_1_1_1_1_1.setForeground(new Color(0, 0, 0));
		button_1_1_1_1_1.setBackground(new Color(245, 245, 248));
		add(button_1_1_1_1_1);
		
		Button button_1_1_1_1 = new Button("Chat Box");
		button_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel chatbox = new ChatBox();
		        chatbox.setSize(1500, 653);
		        chatbox.setLocation(0, 70);
		        FormAdmin.contentPane.add(chatbox);
		        FormAdmin.contentPane.revalidate();
		        FormAdmin.contentPane.repaint();
			}
		});
		button_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		button_1_1_1_1.setForeground(new Color(0, 0, 0));
		button_1_1_1_1.setBackground(new Color(245, 245, 248));
		add(button_1_1_1_1);
		
		//test
		
		
	}
}
