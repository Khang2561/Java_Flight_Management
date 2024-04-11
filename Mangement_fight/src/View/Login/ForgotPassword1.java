package View.Login;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ForgotPassword1 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ForgotPassword1() {
		setLayout(null);

        JLabel lblNewLabel = new JLabel("Quên mật khẩu ");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(137, 10, 225, 64);
        add(lblNewLabel);
	}

}
