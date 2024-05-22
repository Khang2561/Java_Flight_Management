package View.Admin.TicketPlane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

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
        	@Override
			public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(50, 67, 117, 29);
        panel.add(btnNewButton);
	}
}
