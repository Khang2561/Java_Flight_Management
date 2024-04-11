package View.Login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class loggin_form extends JPanel {

    public static final long serialVersionUID = 1L;

    public loggin_form() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Đăng nhập ");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(137, 10, 160, 64);
        add(lblNewLabel);
    }
}