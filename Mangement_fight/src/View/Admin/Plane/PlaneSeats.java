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
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PlaneSeats() {
		setBounds(0, 0, 756, 455);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 736, 392);
		add(panel);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.setBounds(116, 9, 85, 21);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numButtons = Integer.parseInt(textField.getText());
				for (int i = 0; i < numButtons; i++) {
		             JButton button = new JButton("Button " + (i + 1));
		             button.setPreferredSize(new Dimension(60, 40)); // Kích thước cố định
		             panel.add(button);
		         }
				
			}
		});

	}
}
