package View.Admin.Flight;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CustomUI.BtnCS;
import View.Admin.Admin_header;
import View.Admin.FormAdmin;

public class FlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JPanel panelMainContent;
	private BtnCS btnListFlight;
	private BtnCS btnNewFlight;
	public static BtnCS btnDetailFlight;
	private static BtnCS selectedButton = null;
	/**
	 * Create the panel.
	 */
	public FlightUC()throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 1500, 70);
		add(panel);

		//--------------------------------------------------------------------------------
		btnListFlight = new BtnCS();
		btnListFlight.setBackground(new Color(255, 255, 255));
		btnListFlight.setRadius(30);
		btnListFlight.setText("Danh Sách Chuyến Bay");
		btnListFlight.setBounds(31, 10, 232, 50);
		btnListFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnListFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectButton(btnListFlight);
				try {
					switchPanel(new FlightListUC());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnNewFlight.setBackground(new Color(255, 255, 255));
			}
		});
		selectButton(btnListFlight);//default
		addHoverEffect(btnListFlight);
		
		btnNewFlight = new BtnCS();
		btnNewFlight.setColor(new Color(3,4,94));
		btnNewFlight.setBackground(new Color(255, 255, 255));
		btnNewFlight.setRadius(30);
		btnNewFlight.setText("Tạo Chuyến Bay Mới");
		btnNewFlight.setBounds(329, 10, 211, 50);
		btnNewFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectButton(btnNewFlight);
				try {
					switchPanel(new OperationFlightUC());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnNewFlight.setBackground(new Color(3,4,94));
			}
		});
		addHoverEffect(btnNewFlight);

		btnDetailFlight = new BtnCS();
		btnDetailFlight.setRadius(30);
		btnDetailFlight.setText("Chi Tiết Chuyến Bay");
		btnDetailFlight.setEnabled(false);
		btnDetailFlight.setBounds(1241, 10, 209, 50);
		btnDetailFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnDetailFlight.setBackground(null);
		addHoverEffect(btnDetailFlight);

        panelMainContent = new JPanel(new CardLayout());
        panelMainContent.setBounds(0, 70, 1500, 610);
        add(panelMainContent);

        //-----------------------------------------------------------------------------------
        // Add different panels to the card layout
        panelMainContent.add(new FlightListUC(), "FlightList");
        panelMainContent.add(new OperationFlightUC(), "OperationFlight");

		panel.setLayout(null);
		panel.add(btnListFlight);
		panel.add(btnNewFlight);
		panel.add(btnDetailFlight);

	}
	
	//-----------------------------------------------------------------------------------------
    public static void switchPanel(JPanel newPanel) {
    	/*
        CardLayout cl = (CardLayout)(panelMainContent.getLayout());
        cl.show(panelMainContent, panelName);
        */
    	panelMainContent.removeAll(); // Xóa tất cả các thành phần trên panel
        panelMainContent.add(newPanel); // Thêm form mới vào panel
        panelMainContent.revalidate(); // Cập nhật giao diện
        panelMainContent.repaint(); // Vẽ lại giao diện
    }
    public static void switchDetailFlightUC(DetailFlightUC newPanel) {
        panelMainContent.removeAll(); // Xóa tất cả các thành phần trên panel
        panelMainContent.add(newPanel); // Thêm form mới vào panel
        panelMainContent.revalidate(); // Cập nhật giao diện
        panelMainContent.repaint(); // Vẽ lại giao diện
    }
    //---------------------------------------------------------------------------------------
    protected static void selectButton(BtnCS button) {
        if (selectedButton != null) {
            selectedButton.setBackground(Color.WHITE); // Reset background color of previously selected button
            selectedButton.setForeground(Color.BLACK); // Reset text color of previously selected button
        }
        selectedButton = button;
        button.setBackground(new Color(3,4,94)); // Highlight the currently selected button with red background
        button.setForeground(Color.WHITE); // Highlight the currently selected button with white text
    }
    //------------------------------------------------------------------------------------------
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