package View.Admin.TicketPlane;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateFlightTicket extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CreateFlightTicket() throws ClassNotFoundException, SQLException {
        setBackground(new Color(240, 240, 240));
        setBounds(0, 71, 1500, 610);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1500, 568);
        add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("MINH DEMO");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(50, 67, 117, 29);
        panel.add(btnNewButton);
	}
}
