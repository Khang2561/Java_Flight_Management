 package View.Admin;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.Admin.AccountAndPermission.AccountAndPermission;
import View.Admin.ChatBox.ChatBox;
import View.Admin.Plane.OperationPlaneUC;
import View.Admin.Plane.PlaneListUC;
import View.Admin.Plane.PlaneUC;
import View.Admin.Setting.Setting;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import java.awt.Font;

public class Admin_header extends JPanel {

	public static final long serialVersionUID = 1L;
	public static Button[] buttons = new Button[6];

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
		//button chuyen bay 
		buttons[0] = new Button("Chuyến bay ");
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		button.setBackground(new Color(245, 245, 248));
//		button.setForeground(new Color(0, 0, 0));
//		add(button);
		//button ve may bay
		buttons[1] = new Button("Vé máy bay");
//		button_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		button_1.setForeground(new Color(0, 0, 0));
//		button_1.setBackground(new Color(245, 245, 248));
//		add(button_1);
		
		//button may bay
		buttons[2] = new Button("Máy bay");
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAndShow(new PlaneUC());
				
			}
		});
//		button_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		button_1_1.setForeground(new Color(0, 0, 0));
//		button_1_1.setBackground(new Color(245, 245, 248));
//		add(button_1_1);
		
		//button tai khoan va phan quyen
		buttons[3] = new Button("Tài khoảng và quyền ");
//		button_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JPanel aap = new AccountAndPermission();
				aap.setSize(1500, 653);
				aap.setLocation(0, 70);
				FormAdmin.contentPane.removeAll();
		        FormAdmin.contentPane.add(aap);
		        FormAdmin.contentPane.revalidate();
		        FormAdmin.contentPane.repaint();*/
				try {
					clearAndShow(new AccountAndPermission());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
//		button_1_1_1.setForeground(new Color(0, 0, 0));
//		button_1_1_1.setBackground(new Color(245, 245, 248));
//		add(button_1_1_1);
		
		//buttion cai dat
		buttons[4] = new Button("Cài đặt");
		buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JPanel setting = new Setting();
				setting.setSize(1500, 653);
				setting.setLocation(0, 70);
		        FormAdmin.contentPane.add(setting);
		        FormAdmin.contentPane.revalidate();
		        FormAdmin.contentPane.repaint();*/
				try {
					clearAndShow(new Setting());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
//		button_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		button_1_1_1_1_1.setForeground(new Color(0, 0, 0));
//		button_1_1_1_1_1.setBackground(new Color(245, 245, 248));
//		add(button_1_1_1_1_1);
		
		//button box chat 
		buttons[5] = new Button("Chat Box");
		buttons[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JPanel chatbox = new ChatBox();
		        chatbox.setSize(1500, 653);
		        chatbox.setLocation(0, 70);
		        FormAdmin.contentPane.add(chatbox);
		        FormAdmin.contentPane.revalidate();
		        FormAdmin.contentPane.repaint();*/
				clearAndShow(new ChatBox());
			}
		});
//		button_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		button_1_1_1_1.setForeground(new Color(0, 0, 0));
//		button_1_1_1_1.setBackground(new Color(245, 245, 248));
//		add(button_1_1_1_1);
		
		//test
		
		for (Button button : buttons) {
		    button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		    button.setBackground(new Color(245, 245, 248));
		    button.setForeground(new Color(0, 0, 0));
		    add(button);
		}
		
	}
	//ham xoa va tao form moi
	private void clearAndShow(JPanel newPanel) {
        FormAdmin.contentPane.removeAll(); // Xóa tất cả các thành phần trên contentPane
        FormAdmin.contentPane.add(this); // Thêm lại Admin_header vào contentPane
        FormAdmin.contentPane.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 653);
        newPanel.setLocation(0, 70);
        FormAdmin.contentPane.revalidate(); // Cập nhật giao diện
        FormAdmin.contentPane.repaint(); // Vẽ lại giao diện
    }
}
