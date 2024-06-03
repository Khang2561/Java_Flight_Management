package View.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CustomUI.BtnCS;

import View.Admin.AccountAndPermission.AccountAndPermission;
import View.Admin.ChatBox.ChatBox;
import View.Admin.Flight.FlightUC;
import View.Admin.Plane.PlaneUC;
import View.Admin.Setting.Setting;
import View.Admin.TicketPlane.FlightTicket;

public class Admin_header extends JPanel {

    public static final long serialVersionUID = 1L;
    public static BtnCS[] buttons = new BtnCS[6];
    private static BtnCS selectedButton = null;  // Track the currently selected button

    /**
     * Create the panel.
     */
    public Admin_header() {
        setBackground(new Color(245, 245, 248));
        setBounds(0, 0, 1500, 80);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Margin around buttons

        // Logo
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Admin_header.class.getResource("/Resource/LogoMAT_180x40.png")));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(lblNewLabel, gbc);

        //-------------------------------------------------------------
        createButton("CHUYẾN BAY", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clearAndShow(new FlightUC());
                    highlightButton(buttons[0]);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }, gbc, 1);
        //--------------------------------------------------------------
        createButton("VÉ MÁY BAY",new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAndShow(new FlightTicket(null));
				highlightButton(buttons[1]);
            }
        }, gbc, 2);
        //----------------------------------------------------------------
        createButton("MÁY BAY", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAndShow(new PlaneUC());
                highlightButton(buttons[2]);
            }
        }, gbc, 3);
        //------------------------------------------------------------------
        createButton("TÀI KHOẢN", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clearAndShow(new AccountAndPermission());
                    highlightButton(buttons[3]);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }, gbc, 4);
        //--------------------------------------------------------------------
        createButton("CÀI ĐẶT", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clearAndShow(new Setting());
                    highlightButton(buttons[4]);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }, gbc, 5);
        //-----------------------------------------------------------------------
        createButton("CHAT BOX", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAndShow(new ChatBox());
                highlightButton(buttons[5]);
            }
        }, gbc, 6);

        // Set initial styles for all buttons
        for (BtnCS button : buttons) {
            if (button != null) {
                button.setFont(new Font("Times New Roman", Font.BOLD, 18));
                button.setBackground(Color.WHITE); // Set initial background color to white
                button.setForeground(Color.BLACK); // Set initial text color to black
                button.setMinimumSize(new Dimension(200, 50)); // Set minimum size
                button.setPreferredSize(new Dimension(150, 40)); // Set preferred size
                button.setMaximumSize(new Dimension(150, 40)); // Set maximum size

                // Add MouseListener for hover effect
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (button != selectedButton) {
                            button.setBackground(new Color(0, 0, 160));
                            button.setForeground(Color.WHITE);
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if (button != selectedButton) {
                            button.setBackground(Color.WHITE);
                            button.setForeground(Color.BLACK);
                        }
                    }
                });
            }
        }
    }

    // Method to create a button and add it to the panel
    private void createButton(String text, ActionListener actionListener, GridBagConstraints gbc, int gridx) {
        BtnCS button = new BtnCS();
        button.setText(text);
        if (actionListener != null) {
            button.addActionListener(actionListener);
        }
        gbc.gridx = gridx;
        gbc.gridy = 0;
        add(button, gbc);
        buttons[gridx - 1] = button;
    }
    //3,4,94
    // Method to clear and show new panel
    public static void clearAndShow(JPanel newPanel) {
        FormAdmin.contentPane.removeAll(); // Xóa tất cả các thành phần trên contentPane
        Admin_header tmp = new Admin_header();
        FormAdmin.contentPane.add(tmp); // Thêm lại Admin_header vào contentPane
        FormAdmin.contentPane.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 653);
        newPanel.setLocation(0, 78);
        FormAdmin.contentPane.revalidate(); // Cập nhật giao diện
        FormAdmin.contentPane.repaint(); // Vẽ lại giao diện
    }

    // Method to highlight the selected button
    public static void highlightButton(BtnCS button) {
        if (selectedButton != null) {
            selectedButton.setBackground(Color.WHITE); // Reset background color of previously selected button
            selectedButton.setForeground(Color.BLACK); // Reset text color of previously selected button
        }
        button.setBackground(new Color(3, 4, 94)); // Highlight the currently selected button with black background
        button.setForeground(Color.WHITE); // Set text color to white
        selectedButton = button; // Update the currently selected button
    }
    //-------------------------------------------------------
    public static void highlightButton1() {
        if (selectedButton != null) {
            selectedButton.setBackground(Color.WHITE); // Reset background color of previously selected button
            selectedButton.setForeground(Color.BLACK); // Reset text color of previously selected button
        }
        buttons[1].setBackground(new Color(3, 4, 94)); // Highlight the currently selected button with black background
        buttons[1].setForeground(Color.WHITE); // Set text color to white
        selectedButton = buttons[1]; // Update the currently selected button
    }
}
