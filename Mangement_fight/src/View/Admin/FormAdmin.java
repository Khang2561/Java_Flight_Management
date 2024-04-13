package View.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.Admin.AccountAndPermission.AccountAndPermission;
import View.Admin.Flight.FlightListUC;
import View.Admin.Flight.FlightUC;
import View.Admin.Setting.Setting;
import View.Login.ForgotPassword3;

public class FormAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAdmin frame = new FormAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//test
	/**
	 * Create the frame.
	 */
	public FormAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(10, 10, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//header
		JPanel header1 = new Admin_header();
		header1.setBounds(0, 0, 1500, 70);
		contentPane.add(header1);
		//tai khoang va phan quyen 
		//JPanel accountPermit = new AccountAndPermission();
		//accountPermit.setLocation(0, 71);
		//contentPane.add(accountPermit);
		//FLIGHT
		//JPanel flightuc = new FlightUC();
		//flightuc.setSize(1500, 50);
		//flightuc.setLocation(0, 70);
		//contentPane.add(flightuc);
		//fight list
		//JPanel FlightListUC = new FlightListUC();
		//FlightListUC.setSize(1500, 600);
		//FlightListUC.setLocation(0, 118);
		//contentPane.add(FlightListUC);
		//flight operation flight
		//HomeAdmin
		//JPanel homeadmin = new HomeAdmin();
		//flightuc.setSize(1500, 50);
		//homeadmin.setLocation(0, 70);
		//contentPane.add(homeadmin);
		//Setting 
		//JPanel setting = new Setting();
		//setting.setSize(1500, 653);
		//setting.setLocation(0, 70);
		//contentPane.add(setting);
		//tai khoang va phan quyen 
		JPanel accountadnpermission = new AccountAndPermission();
		accountadnpermission.setSize(1500, 653);
		accountadnpermission.setLocation(0, 70);
		contentPane.add(accountadnpermission);
		
		
		setContentPane(contentPane);
	}

}
