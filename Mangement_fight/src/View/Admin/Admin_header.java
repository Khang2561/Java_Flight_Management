package View.Admin;

import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import View.Admin.AccountAndPermission.AccountAndPermission;
import View.Admin.ChatBox.ChatBox;
import View.Admin.Flight.FlightUC;
import View.Admin.Plane.PlaneUC;
import View.Admin.Setting.Setting;

public class Admin_header extends JPanel {

    public static final long serialVersionUID = 1L;
    public static Button[] buttons = new Button[6];
    private static Button selectedButton = null;  // Track the currently selected button

    /**
     * Create the panel.
     */
    public Admin_header() {
        setBackground(new Color(245, 245, 248));
        setBounds(0, 0, 1500, 80);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // Logo
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Admin_header.class.getResource("/Resource/LogoMAT_180x40.png")));
        add(lblNewLabel);

        // Button "Chuyến bay"
        buttons[0] = new Button("Chuyến bay ");
        buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clearAndShow(new FlightUC());
                    highlightButton(buttons[0]);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Button "Vé máy bay"
        buttons[1] = new Button("Vé máy bay");

        // Button "Máy bay"
        buttons[2] = new Button("Máy bay");
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAndShow(new PlaneUC());
                highlightButton(buttons[2]);
            }
        });

        // Button "Tài khoảng và quyền"
        buttons[3] = new Button("Tài khoảng và quyền ");
        buttons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clearAndShow(new AccountAndPermission());
                    highlightButton(buttons[3]);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Button "Cài đặt"
        buttons[4] = new Button("Cài đặt");
        buttons[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clearAndShow(new Setting());
                    highlightButton(buttons[4]);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Button "Chat Box"
        buttons[5] = new Button("Chat Box");
        buttons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAndShow(new ChatBox());
                highlightButton(buttons[5]);
            }
        });

        // Add buttons to panel and set initial styles
        for (Button button : buttons) {
            button.setFont(new Font("Times New Roman", Font.BOLD, 18));
            button.setBackground(new Color(245, 245, 248));
            button.setForeground(new Color(0, 0, 0));
            add(button);
        }
    }

    // Method to clear and show new panel
    public static  void clearAndShow(JPanel newPanel) {
        FormAdmin.contentPane.removeAll(); // Xóa tất cả các thành phần trên contentPane
        Admin_header tmp = new Admin_header();
        FormAdmin.contentPane.add(tmp); // Thêm lại Admin_header vào contentPane
        highlightButton(buttons[0]);
        FormAdmin.contentPane.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 653);
        newPanel.setLocation(0, 78);
        FormAdmin.contentPane.revalidate(); // Cập nhật giao diện
        FormAdmin.contentPane.repaint(); // Vẽ lại giao diện
    }

    // Method to highlight the selected button
    public static void highlightButton(Button button) {
        if (selectedButton != null) {
            selectedButton.setBackground(new Color(245, 245, 248)); // Reset background color of previously selected button
            selectedButton.setForeground(new Color(0, 0, 0)); // Reset text color of previously selected button
        }
        button.setBackground(new Color(3, 4, 94)); // Highlight the currently selected button with blue background
        button.setForeground(new Color(255, 255, 255)); // Set text color to white
        selectedButton = button; // Update the currently selected button
    }
    
    
}
