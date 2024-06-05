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
    public static JLabel lblShowAndHidePassword(JPasswordField passwordField, int width, int height) {
        JLabel lblShowAndHidePassword = new JLabel();
        
        ImageIcon scaledShowPassword = scaledImage(Utils.class.getResource("/Resource/view.png"), width, height);
        ImageIcon scaledHidePassword = scaledImage(Utils.class.getResource("/Resource/hide.png"), width, height);
        
        lblShowAndHidePassword.setIcon(scaledShowPassword);
            
        lblShowAndHidePassword.addMouseListener(new MouseAdapter() {
            boolean isShowing = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                isShowing = !isShowing;
                passwordField.setEchoChar(isShowing ? (char) 0 : '\u2022');
                lblShowAndHidePassword.setIcon(isShowing ? scaledHidePassword : scaledShowPassword);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                lblShowAndHidePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblShowAndHidePassword.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        return lblShowAndHidePassword;
    }
    
    public static ImageIcon scaledImage(URL imageDirectory, int width, int height) {
        ImageIcon icon = new ImageIcon(imageDirectory);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
