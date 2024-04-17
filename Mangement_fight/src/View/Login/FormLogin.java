package View.Login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Image;

import java.awt.Cursor;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int mouseX, mouseY;
	JPanel panelLogin;
	JPanel panelForgotPassword1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 488);
		setTitle("Flight Airline");
		
		//di chuyen window
		addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
				
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//hien thi form dang nhap
		panelLogin = new loggin_form();
		panelForgotPassword1 = new ForgotPassword1();
        panelLogin.setBounds(417, 44, 300, 406);
        contentPane.add(panelLogin);
        
        
        //chuyen sang form quen mat khau
        ((loggin_form) panelLogin).lblForgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {            
                
                contentPane.remove(panelLogin);
                
                panelForgotPassword1.setBounds(417, 44, 300, 406);
                contentPane.add(panelForgotPassword1);
                
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
        
        //tro ve form dang nhap
        ((ForgotPassword1) panelForgotPassword1).lblReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {  
                
                contentPane.remove(panelForgotPassword1);
                
                panelLogin.setBounds(417, 44, 300, 406);
                contentPane.add(panelLogin);
                
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
        	
        	    
        //add anh login
        JLabel lblBackgroundImg = new JLabel("");
        lblBackgroundImg.setBounds(0, 0, 375, 488);
        ImageIcon iconBackground = new ImageIcon(FormLogin.class.getResource("/Resource/flight.jpg"));
        Image imgBackground = iconBackground.getImage(); 
        Image imgBackgroundScale = imgBackground.getScaledInstance(lblBackgroundImg.getWidth(), lblBackgroundImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImg = new ImageIcon(imgBackgroundScale); 
        lblBackgroundImg.setIcon(scaledBackgroundImg);
        contentPane.add(lblBackgroundImg);
        
        //add nut thoat
        JLabel lblExit = new JLabel(); 
        lblExit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblExit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        });
        lblExit.setBounds(720, 12, 18, 20); 
        ImageIcon iconExit = new ImageIcon(FormLogin.class.getResource("/Resource/CloseIcon2.png"));
        Image imgExit = iconExit.getImage(); 
        Image imgExitScale = imgExit.getScaledInstance(lblExit.getWidth(), lblExit.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledExitIcon = new ImageIcon(imgExitScale);
        lblExit.setIcon(scaledExitIcon);
        contentPane.add(lblExit);
	}
}
