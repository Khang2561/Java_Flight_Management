package View.Admin.Flight;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

import View.Admin.FormAdmin;
import View.Admin.Plane.OperationPlaneUC;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

import javax.swing.JPanel;

public class FlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPanel contentPanel;
	/**
	 * Create the panel.
	 */
	public FlightUC()throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 70, 1500, 650);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 1500, 69);
		add(panel);
		
		contentPanel = new JPanel();
        contentPanel.setBounds(42, 73, 1365, 520);
        add(contentPanel);
        contentPanel.setLayout(null);

		JButton btnListFlight = new JButton("Danh Sách Chuyến Bay");
		btnListFlight.setBounds(41, 21, 232, 50);
		btnListFlight.setBackground(null);
		btnListFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnListFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
                FlightListUC ap = new FlightListUC();
                contentPanel.add(ap);
                ap.setLocation(0, 0);
                ap.setSize(1365, 520);
                contentPanel.revalidate();
                contentPanel.repaint();
			}
		});

		JButton btnNewFlight = new JButton("Tạo Chuyến Bay Mới");
		btnNewFlight.setBounds(321, 21, 211, 50);
		btnNewFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewFlight.setBackground(null);
		btnNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
                OperationFlightUC ap = new OperationFlightUC();
                contentPanel.add(ap);
                ap.setLocation(0, 0);
                ap.setSize(1365, 520);
                contentPanel.revalidate();
                contentPanel.repaint();
			}
		});


		JButton btnDetailFlight = new JButton("Chi Tiết Chuyến Bay");
		btnDetailFlight.setBounds(1199, 21, 209, 50);
		btnDetailFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnDetailFlight.setBackground(null);
		btnDetailFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnListFlight);
		panel.add(btnNewFlight);
		panel.add(btnDetailFlight);
	}

}
