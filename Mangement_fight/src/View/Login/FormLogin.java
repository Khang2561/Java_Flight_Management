package View.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.View;

import View.Login.loggin_form;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Label;
import java.awt.Canvas;
import java.awt.Color;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set tittle
		setTitle("Flight Airline");
		
		
		setBounds(300, 100, 750, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//add anh login
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FormLogin.class.getResource("/Resource/flight500x572.jpg")));
		lblNewLabel.setBounds(0, 0, 375, 488);
		contentPane.add(lblNewLabel);
		/*//hien thi form dang nhap
		JPanel panel = new loggin_form();
        panel.setBounds(418, 56, 408, 382);
        contentPane.add(panel);*/
		/*// quen mat khau 1
        JPanel panel_forgot1 = new ForgotPassword1();
        panel_forgot1.setBounds(418, 56, 408, 382);
        contentPane.add(panel_forgot1);*/
		/*//quen mat khau 2 
		JPanel panel_forgot2 = new ForgotPassword2();
        panel_forgot2.setBounds(418, 56, 408, 382);
        contentPane.add(panel_forgot2);*/
		//quen mat khau 3
		//JPanel panel_forgot3 = new ForgotPassword3();
        //panel_forgot3.setBounds(372, 36, 408, 382);
        //contentPane.add(panel_forgot3);
		
	}
}
