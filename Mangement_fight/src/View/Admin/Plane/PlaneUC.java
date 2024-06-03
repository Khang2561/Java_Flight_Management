package View.Admin.Plane;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class PlaneUC extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPanel;

	public static JPanel panel;
	private static JButton selectedButton = null;
	public static JButton btnPlaneOperation;


	/**
	 * Create the panel.
	 */
	public PlaneUC() {
		setLayout(null);
		setBounds(0,70,1500,653);
		panel = new JPanel();
		panel.setBounds(62, 10, 1365, 53);
		add(panel);
		panel.setLayout(null);
		
		JButton btnPlaneList = new JButton("Danh sách \r\nmáy bay");
		btnPlaneList.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneList.setBackground(new Color(245, 245, 248)); 
		btnPlaneList.setForeground(new Color(0, 0, 0)); 
		btnPlaneList.setBounds(0, 0, 175, 53);
		panel.add(btnPlaneList);
		
		JButton btnNewPlane = new JButton("Tạo mới máy bay");
		btnNewPlane.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewPlane.setBackground(new Color(245, 245, 248)); 
		btnNewPlane.setForeground(new Color(0, 0, 0)); 
		btnNewPlane.setBounds(229, 0, 175, 53);
		panel.add(btnNewPlane);
		
		btnPlaneOperation = new JButton("Chi tiết máy bay");
		btnPlaneOperation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneOperation.setEnabled(true);
		btnPlaneOperation.setBackground(Color.LIGHT_GRAY);
		btnPlaneOperation.setEnabled(false);
		btnPlaneOperation.setBounds(1190, 0, 175, 53); 

		panel.add(btnPlaneOperation);
		
		contentPanel = new JPanel();
        contentPanel.setBounds(62, 73, 1365, 520);
        add(contentPanel);
        contentPanel.setLayout(null);
       
		
		
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
                highlightButton(btnPlaneList);
                btnPlaneOperation.setBackground(Color.LIGHT_GRAY);
                btnPlaneOperation.setEnabled(false);
				
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
                highlightButton(btnNewPlane);
                btnPlaneOperation.setBackground(Color.LIGHT_GRAY);
                btnPlaneOperation.setEnabled(false); 
			}
		});
		

	}
	public static void highlightButton(JButton button) {
        if (selectedButton != null) {
            selectedButton.setBackground(new Color(245, 245, 248)); // Reset background color of previously selected button
            selectedButton.setForeground(new Color(0, 0, 0)); // Reset text color of previously selected button
        }
        button.setBackground(new Color(3, 4, 94)); // Highlight the currently selected button with blue background
        button.setForeground(new Color(255, 255, 255)); // Set text color to white
        selectedButton = button; // Update the currently selected button
    }
	public static void setOpeButtonEnable(Boolean temp) {
		btnPlaneOperation.setEnabled(temp);
	}

}
