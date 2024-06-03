package View.Admin.TicketPlane;

import javax.swing.JPanel;
import CustomUI.BtnCS;
import View.Admin.Flight.FlightUC;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panel_1;
    String flightID;
    private BtnCS button;
    private BtnCS button_1;
    public static BtnCS button_2;
    private static BtnCS selectedButton = null;  // Track the currently selected button

    /**
     * Create the panel.
     */
    public FlightTicket(String flightID1) {
        flightID = flightID1;
        setBounds(0, 71, 1500, 642);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setBounds(0, 0, 1500, 82);
        add(panel);
        panel.setLayout(null);

        //------------------------------header---------------------------------------
        button = new BtnCS();
        button.setFont(new Font("Times New Roman", Font.BOLD, 17));
        button.setRadius(30);
        button.setForeground(new Color(0, 0, 0));
        button.setColor(new Color(3,4,94));
        button.setBackground(new Color(255, 255, 255));
        button.setText("Tạo vé máy bay ");
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectButton(button);
                clearAndShow(new CreateFlightTicket(flightID));
                button_2.setBackground(new Color(255, 255, 255));
            }
        });
        addHoverEffect(button);
        button.setBounds(31, 10, 181, 49);
        panel.add(button);

        //------------------------------------------------------
        button_1 = new BtnCS();
        button_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        button_1.setRadius(30);
        button_1.setColor(new Color(3,4,94));
        button_1.setBackground(new Color(255, 255, 255));
        button_1.setText("Tra cứu ");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectButton(button_1);
                clearAndShow(new SearchFlightTicket());
                button_2.setBackground(new Color(255, 255, 255));
            }
        });
        addHoverEffect(button_1);
        button_1.setBounds(251, 10, 117, 49);
        panel.add(button_1);

        //--------------------------------------------------------
        button_2 = new BtnCS();
        button_2.setEnabled(false);
        button_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        button_2.setRadius(30);
        button_2.setColor(new Color(3,4,94));
        button_2.setBackground(new Color(255, 255, 255));
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectButton(button_2);
                // Implement the action for button_2 if needed
            }
        });
        button_2.setText("Chi tiết vé máy bay");
        addHoverEffect(button_2);
        button_2.setBounds(1265, 10, 188, 49);
        panel.add(button_2);

        //--------------------------------nội dung---------------------------------
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(240, 240, 240));
        panel_1.setBounds(0, 82, 1500, 560);
        add(panel_1);
        panel_1.setLayout(null);

        if (flightID != null) {
            clearAndShow(new CreateFlightTicket(flightID));
        }  
    }

    //---------------------------------------------
    private void clearAndShow(JPanel newPanel) {
        panel_1.removeAll(); // Xóa tất cả các thành phần trên contentPane
        panel_1.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 560);
        newPanel.setLocation(0, 0);
        panel_1.revalidate(); // Cập nhật giao diện
        panel_1.repaint(); // Vẽ lại giao diện
    }

    //---------------------------------------------
    private void selectButton(BtnCS button) {
        if (selectedButton != null) {
            selectedButton.setBackground(Color.WHITE); // Reset background color of previously selected button
            selectedButton.setForeground(Color.BLACK); // Reset text color of previously selected button
        }
        selectedButton = button;
        button.setBackground(Color.RED); // Highlight the currently selected button with red background
        button.setForeground(Color.WHITE); // Highlight the currently selected button with white text
    }

    //---------------------------------------------
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
