package View.Admin.Flight;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

import View.Admin.FormAdmin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class FlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FlightUC()throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 1500, 69);
		add(panel);
		
		JButton btnListFlight = new JButton("Danh Sách Chuyến Bay");
		btnListFlight.setBounds(41, 21, 232, 50);
		btnListFlight.setBackground(null);
		btnListFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnListFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnNewFlight = new JButton("Tạo Chuyến Bay Mới");
		btnNewFlight.setBounds(321, 21, 211, 50);
		btnNewFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewFlight.setBackground(null);
		btnNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		JButton btnDetailFlight = new JButton("Chi Tiết Chuyến Bay");
		btnDetailFlight.setBounds(1241, 21, 209, 50);
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
