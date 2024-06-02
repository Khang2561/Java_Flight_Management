package View.Admin;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ParametersDAO;
import DAO.TicketClassDAO;
import Model.Parameters;
import View.Admin.AccountAndPermission.AccountAndPermission;
import View.Admin.ChatBox.ChatBox;
import View.Admin.Flight.FlightListUC;
import View.Admin.Flight.FlightUC;
import View.Admin.Setting.Setting;
import View.Login.ForgotPassword3;

public class FormAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	/**
	 * Launch the application..
	 */
	public static void ResetSetting() {
		
	}
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
		HomeAdmin framehome = new HomeAdmin();
		contentPane.add(framehome);
		contentPane.add(header1);
		
		
		
		setContentPane(contentPane);
		this.setVisible(true);
	}

}
