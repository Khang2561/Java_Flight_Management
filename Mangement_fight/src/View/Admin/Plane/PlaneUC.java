package View.Admin.Plane;

import javax.swing.JPanel;
import javax.swing.UIManager;

import CustomUI.BtnCS;
import View.Admin.TicketPlane.CreateFlightTicket;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class PlaneUC extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPanel;

	public static JPanel panel;
	private static JButton selectedButton = null;
	public static BtnCS btnPlaneOperation;
	private BtnCS btnPlaneList;
	private BtnCS btnNewPlane;


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
		//----------------------------------------------------------
		btnPlaneList = new BtnCS();
		btnPlaneList.setRadius(30);
		btnPlaneList.setText("Danh sách \r\nmáy bay");
		btnPlaneList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectButton(btnPlaneList);
				clearAndShow(new PlaneListUC());
				btnNewPlane.setBackground(new Color(255, 255, 255));
				/*
                highlightButton(btnPlaneList);
                btnPlaneOperation.setBackground(Color.LIGHT_GRAY);
                btnPlaneOperation.setEnabled(false);
                */
			}
		});
		addHoverEffect(btnPlaneList);
		btnPlaneList.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneList.setBackground(new Color(245, 245, 248)); 
		btnPlaneList.setForeground(new Color(0, 0, 0)); 
		btnPlaneList.setBounds(0, 0, 175, 53);
		panel.add(btnPlaneList);
		
		
		//---------------
		btnNewPlane = new BtnCS();
		btnNewPlane.setRadius(30);
		btnNewPlane.setText("Tạo mới máy bay");
		btnNewPlane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAndShow(new CreatePlane());
				selectButton(btnNewPlane);
				btnPlaneList.setBackground(new Color(255, 255, 255));
				/*
                highlightButton(btnNewPlane);
                btnPlaneOperation.setBackground(Color.LIGHT_GRAY);
                btnPlaneOperation.setEnabled(false); 
                */
			}
		});
		addHoverEffect(btnNewPlane);
		btnNewPlane.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewPlane.setBackground(new Color(245, 245, 248)); 
		btnNewPlane.setForeground(new Color(0, 0, 0)); 
		btnNewPlane.setBounds(229, 0, 175, 53);
		panel.add(btnNewPlane);
		
		
		//------------------------
		btnPlaneOperation = new BtnCS();
		btnPlaneOperation.setRadius(30);
		btnPlaneOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectButton(btnPlaneOperation);
			}
		});
		addHoverEffect(btnPlaneOperation);
		btnPlaneOperation.setText("Chi tiết máy bay");
		btnPlaneOperation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaneOperation.setEnabled(false);
		btnPlaneOperation.setBackground(Color.LIGHT_GRAY);
		btnPlaneOperation.setEnabled(false);
		btnPlaneOperation.setBounds(1190, 0, 175, 53); 

		panel.add(btnPlaneOperation);
		
		//-----------------------------------------------------------
		contentPanel = new JPanel();
        contentPanel.setBounds(62, 73, 1365, 520);
        add(contentPanel);
        contentPanel.setLayout(null);
       
	}
	
	//----------------------------------------------------
	public static void highlightButton(JButton button) {
        if (selectedButton != null) {
            selectedButton.setBackground(new Color(245, 245, 248)); // Reset background color of previously selected button
            selectedButton.setForeground(new Color(0, 0, 0)); // Reset text color of previously selected button
        }
        button.setBackground(new Color(3, 4, 94)); // Highlight the currently selected button with blue background
        button.setForeground(new Color(255, 255, 255)); // Set text color to white
        selectedButton = button; // Update the currently selected button
    }
	//-----------------------------------------------------
	public static void setOpeButtonEnable(Boolean temp) {
		btnPlaneOperation.setEnabled(temp);
	}
	//-----------------------------------------------------
	private void clearAndShow(JPanel newPanel) {
		contentPanel.removeAll(); // Xóa tất cả các thành phần trên contentPane
		contentPanel.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1365, 520);
        newPanel.setLocation(0, 0);
        contentPanel.revalidate(); // Cập nhật giao diện
        contentPanel.repaint(); // Vẽ lại giao diện
    }
	//------------------------------------------------------
	private void selectButton(BtnCS button) {
        if (selectedButton != null) {
            selectedButton.setBackground(Color.WHITE); // Reset background color of previously selected button
            selectedButton.setForeground(Color.BLACK); // Reset text color of previously selected button
        }
        selectedButton = button;
        button.setBackground(Color.RED); // Highlight the currently selected button with red background
        button.setForeground(Color.WHITE); // Highlight the currently selected button with white text
    }
	//-------------------------------------------------------
	private void addHoverEffect(BtnCS button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button != selectedButton) {
                    button.setForeground(Color.WHITE);
                    button.setBackground(new Color(0,0,160));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (button != selectedButton) {
                    button.setForeground(Color.BLACK);
                    button.setBackground(Color.WHITE);
                }
            }
        });
    }

}
