package View.Admin.Flight;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPanel panelMainContent;
	/**
	 * Create the panel.
	 */
	public FlightUC()throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 1500, 70);
		add(panel);

		JButton btnListFlight = new JButton("Danh Sách Chuyến Bay");
		btnListFlight.setBounds(41, 21, 232, 50);
		btnListFlight.setBackground(null);
		btnListFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnListFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanel("FlightList");
			}
		});

		JButton btnNewFlight = new JButton("Tạo Chuyến Bay Mới");
		btnNewFlight.setBounds(321, 21, 211, 50);
		btnNewFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewFlight.setBackground(null);
		btnNewFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanel("OperationFlight");
			}
		});


		JButton btnDetailFlight = new JButton("Chi Tiết Chuyến Bay");
		btnDetailFlight.setBounds(1241, 21, 209, 50);
		btnDetailFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnDetailFlight.setBackground(null);
		btnDetailFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanel("DetailFlight");
			}
		});
        panelMainContent = new JPanel(new CardLayout());
        panelMainContent.setBounds(0, 70, 1500, 610);
        add(panelMainContent);

        // Add different panels to the card layout
        panelMainContent.add(new FlightListUC(), "FlightList");
        panelMainContent.add(new OperationFlightUC(), "OperationFlight");
        // Assuming DetailFlightUC exists
        panelMainContent.add(new DetailFlightUC(), "DetailFlight");

		panel.setLayout(null);
		panel.add(btnListFlight);
		panel.add(btnNewFlight);
		panel.add(btnDetailFlight);

	}
    private void switchPanel(String panelName) {
        CardLayout cl = (CardLayout)(panelMainContent.getLayout());
        cl.show(panelMainContent, panelName);
    }
}
