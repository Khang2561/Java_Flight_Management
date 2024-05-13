package View.Admin.Plane;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PlaneUC extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PlaneUC() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(62, 10, 1365, 53);
		add(panel);
		panel.setLayout(null);
		
		JButton btnPlaneList = new JButton("Danh sách \r\nmáy bay");
		btnPlaneList.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlaneList.setBounds(0, 0, 175, 53);
		panel.add(btnPlaneList);
		
		JButton btnNewPlane = new JButton("Tạo mới máy bay");
		btnNewPlane.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewPlane.setBounds(229, 2, 175, 53);
		panel.add(btnNewPlane);
		
		JButton btnPlaneOperation = new JButton("Chi tiết máy bay");
		btnPlaneOperation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneOperation.setBounds(1190, 0, 175, 53);
		panel.add(btnPlaneOperation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(62, 73, 1365, 520);
		add(panel_1);

	}
}
