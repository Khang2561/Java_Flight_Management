package View.Admin.Plane;

import javax.swing.JPanel;

import View.Admin.FormAdmin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Font;

public class PlaneUC extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPanel;

	/**
	 * Create the panel.
	 */
	public PlaneUC() {
		setLayout(null);
		setBounds(0,70,1500,653);
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
		btnNewPlane.setBounds(229, 0, 175, 53);
		panel.add(btnNewPlane);
		
		JButton btnPlaneOperation = new JButton("Chi tiết máy bay");
		btnPlaneOperation.setEnabled(false);
		btnPlaneOperation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneOperation.setBounds(1190, 0, 175, 53);
		panel.add(btnPlaneOperation);
		
		contentPanel = new JPanel();
        contentPanel.setBounds(62, 73, 1365, 520);
        add(contentPanel);
        contentPanel.setLayout(null);
		
		btnPlaneOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
                OperationPlaneUC ap = new OperationPlaneUC();
                contentPanel.add(ap);
                ap.setLocation(0, 0);
                ap.setSize(1365, 520);
                contentPanel.revalidate();
                contentPanel.repaint();
				
			}
		});
		
		
		btnPlaneList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
                PlaneListUC ap = new PlaneListUC();
                contentPanel.add(ap);
                ap.setLocation(0, 0);
                ap.setSize(1365, 520);
                contentPanel.revalidate();
                contentPanel.repaint();
				
			}
		});
		btnNewPlane.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
                CreatePlane ap = new CreatePlane();
                contentPanel.add(ap);
                ap.setLocation(0, 0);
                ap.setSize(1365, 520);
                contentPanel.revalidate();
                contentPanel.repaint();
				
			}
		});
		

	}
}
