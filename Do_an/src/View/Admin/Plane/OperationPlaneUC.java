package View.Admin.Plane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;

public class OperationPlaneUC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperationPlaneUC frame = new OperationPlaneUC();
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
	public OperationPlaneUC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 536, 576);
		contentPane.add(leftPanel);
		leftPanel.setLayout(new GridLayout(0, 2, 20, 20));
		
		JPanel planeinfoPanel = new JPanel();
		leftPanel.add(planeinfoPanel);
		planeinfoPanel.setLayout(null);
		
		JLabel planeinfoLabel = new JLabel("Thông tin máy bay");
		planeinfoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		planeinfoLabel.setBounds(54, 10, 150, 20);
		planeinfoPanel.add(planeinfoLabel);
		
		JPanel ticketinfoPanel = new JPanel();
		leftPanel.add(ticketinfoPanel);
		ticketinfoPanel.setLayout(null);
		
		JLabel ticketinfoLabel = new JLabel("Hạng vé");
		ticketinfoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		ticketinfoLabel.setBounds(90, 10, 78, 20);
		ticketinfoPanel.add(ticketinfoLabel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(556, 10, 720, 576);
		contentPane.add(rightPanel);
	}
}
