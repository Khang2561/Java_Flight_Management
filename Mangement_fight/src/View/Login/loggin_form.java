package View.Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.AAADAO;
import DAO.PermissionDAO;
import Model.Account;
import View.Admin.Admin_header;
import View.Admin.FormAdmin;



public class loggin_form extends JPanel {

    public static final long serialVersionUID = 1L;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    public JLabel lblForgotPassword;
    private JLabel lbl2;
    public JLabel lblSignUp;

    public loggin_form(FormLogin formLogin, FormAdmin formAdmin) {

    	setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 300, 406);
        add(layeredPane);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setBounds(38, 110, 225, 28);
        layeredPane.add(txtUsername, JLayeredPane.DEFAULT_LAYER);  // Add to default layer
        txtUsername.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(38, 162, 225, 28);
        layeredPane.add(txtPassword, JLayeredPane.DEFAULT_LAYER);  // Add to default layer

		JLabel lbl1 = new JLabel("Đăng nhập");
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl1.setBounds(86, 41, 138, 29);
		add(lbl1);

		lblForgotPassword = new JLabel("Quên mật khẩu");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotPassword.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblForgotPassword.setForeground(new Color(128, 152, 249));
		lblForgotPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblForgotPassword.setBounds(163, 203, 105, 17);
		layeredPane.add(lblForgotPassword, JLayeredPane.DEFAULT_LAYER);

		lbl2 = new JLabel("Chưa có tài khoản?");
		lbl2.setForeground(new Color(113, 113, 122));
		lbl2.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl2.setBounds(66, 295, 112, 15);
		add(lbl2);

		lblSignUp = new JLabel("Đăng ký");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblSignUp.setForeground(new Color(128, 152, 249));
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 12));
		lblSignUp.setBounds(179, 295, 58, 15);
		layeredPane.add(lblSignUp, JLayeredPane.DEFAULT_LAYER);

		Button btnLogin = new Button("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String username = txtUsername.getText();
					String password = txtPassword.getText();

					 // Create an instance of AAADAO
		            AAADAO dao = AAADAO.getInstance();

		            // Call the login method
		            Account account = dao.login(username, password, formLogin, formAdmin);

		            PermissionDAO permisson = new PermissionDAO();

		            String permissonCode = permisson.getPMS(account.getRoleID());

		            permisson.setPermsionAccess(permissonCode, Admin_header.buttons);

				}catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		btnLogin.setBackground(new Color(128, 152, 249));
		btnLogin.setBounds(38, 245, 225, 32);
		layeredPane.add(btnLogin, JLayeredPane.DEFAULT_LAYER);

        // Create the show/hide password label
        JLabel lblShowAndHidePassword =  Utils.lblShowAndHidePassword(txtPassword, 20, 20);
        lblShowAndHidePassword.setBounds(240, 165, 20, 20);  // Adjust the position as needed
        layeredPane.add(lblShowAndHidePassword, JLayeredPane.POPUP_LAYER);  // Add to popup layer (higher than default)

        JLabel lblNewLabel = new JLabel("Email hoặc số điện thoại");
        lblNewLabel.setForeground(new Color(128, 128, 128));
        lblNewLabel.setBounds(38, 95, 137, 14);
        layeredPane.add(lblNewLabel);

        JLabel lblMtKhu = new JLabel("Mật khẩu");
        lblMtKhu.setForeground(Color.GRAY);
        lblMtKhu.setBounds(38, 149, 137, 14);
        layeredPane.add(lblMtKhu);
    }


	public loggin_form() {
		// TODO Auto-generated constructor stub
	}
}