package View.Login;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ForgotPassword3 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ForgotPassword3() {
		setLayout(null);

        JLabel lblNewLabel = new JLabel("Nhập mật mã mới");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(137, 10, 225, 64);
        add(lblNewLabel);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(193, 164, 85, 21);
        add(btnNewButton);
	}

}
