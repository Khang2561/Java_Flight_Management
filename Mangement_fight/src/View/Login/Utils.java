package View.Login;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Utils {
    // Method to create a JLabel that toggles the visibility of a JPasswordField
    public static JLabel lblShowAndHidePassword(JPasswordField passwordField, int width, int height) {
        JLabel lblShowAndHidePassword = new JLabel();
        
        // Load and scale the show and hide icons
        ImageIcon scaledShowPassword = scaledImage(Utils.class.getResource("/Resource/view.png"), width, height);
        ImageIcon scaledHidePassword = scaledImage(Utils.class.getResource("/Resource/hide.png"), width, height);
        
        // Set the initial icon to the show password icon
        lblShowAndHidePassword.setIcon(scaledShowPassword);
        
        // Add mouse listener to handle click and cursor changes
        lblShowAndHidePassword.addMouseListener(new MouseAdapter() {
            boolean isShowing = false; // State to track if the password is visible

            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle the visibility of the password
                isShowing = !isShowing;
                passwordField.setEchoChar(isShowing ? (char) 0 : '\u2022'); // '\u2022' is the bullet character
                lblShowAndHidePassword.setIcon(isShowing ? scaledHidePassword : scaledShowPassword);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                lblShowAndHidePassword.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                lblShowAndHidePassword.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Revert cursor to default
            }
        });
        
        return lblShowAndHidePassword;
    }
    
    // Method to load and scale an image to the given dimensions
    public static ImageIcon scaledImage(URL imageDirectory, int width, int height) {
        ImageIcon icon = new ImageIcon(imageDirectory);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
