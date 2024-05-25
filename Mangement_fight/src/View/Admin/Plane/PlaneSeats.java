package View.Admin.Plane;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class PlaneSeats extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PlaneSeats() {
		setBounds(0, 0, 756, 455);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 756, 455);
		add(panel);

	}
}
