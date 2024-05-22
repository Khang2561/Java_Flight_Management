package View.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class FormAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	/**
	 * Launch the application..
	 */
	public static void ResetSetting() {

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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