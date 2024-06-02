package View.Admin.TicketPlane;

import javax.swing.JPanel;

import View.Admin.Flight.FlightUC;

import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FlightTicket extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public FlightTicket() {
		setBounds(0, 71, 1500, 642);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 0, 1500, 82);
		add(panel);
		panel.setLayout(null);
		
		
		//------------------------------header--------------------------------------- 
		Button button = new Button("Tạo vé máy bay ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAndShow(new CreateFlightTicket());
			}
		});
		button.setBounds(10, 10, 145, 49);
		panel.add(button);
		
		Button button_1 = new Button("Tra cứu ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAndShow(new SearchFlightTicket());
			}
		});
		button_1.setBounds(190, 10, 117, 49);
		panel.add(button_1);
		
		
		//--------------------------------nội dung--------------------------------- 
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(0, 82, 1500, 560);
		add(panel_1);
		panel_1.setLayout(null);
		
		
	}
	
	private void clearAndShow(JPanel newPanel) {
		panel_1.removeAll(); // Xóa tất cả các thành phần trên contentPane
		panel_1.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 560);
        newPanel.setLocation(0, 0);
        panel_1.revalidate(); // Cập nhật giao diện
        panel_1.repaint(); // Vẽ lại giao diện
    }
}
