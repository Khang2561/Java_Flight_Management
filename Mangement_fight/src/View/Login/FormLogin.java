package View.Login;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CustomUI.PanelRound;
import DAO.AAADAO;
import Model.Account;
import View.Admin.FormAdmin;
import View.Admin.AccountAndPermission.AccountAndPermission;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.awt.Color;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelRound contentPane;
	private int mouseX, mouseY;
	private static int otp;
	JPanel panelLogin;
	JPanel panelForgotPassword1;
	JPanel panelRegister;
	JPanel panelForgotPassword2;
	JPanel panelForgotPassword3;
	FormAdmin formAdmin; //= new FormAdmin();
	
	//------------------------------------------------------------------------------------------------
	public void switchPanel(JPanel prePanel, JPanel nxtPanel) {
        contentPane.remove(prePanel);
        
        nxtPanel.setBounds(417, 44, 300, 406);
        contentPane.add(nxtPanel);
        
        contentPane.revalidate();
        contentPane.repaint();
	}
	//------------------------------------------------------------------
	//Hàm gửi mã OTP
	public static void sendOTP(String to) {
		// Sender Email
		final String username = "testjavaemailotp@gmail.com";
		final String password = "leky jzgd akvd eylc";
			
		Properties prop = new Properties();
	    prop.put("mail.smtp.host", "smtp.gmail.com");
	    prop.put("mail.smtp.port", "587");
	    prop.put("mail.smtp.auth", "true");
	    prop.put("mail.smtp.starttls.enable", "true"); //TLS
	    // Create authenticator
	    Authenticator auth = new Authenticator() {
	        	
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	        		
	    		return new PasswordAuthentication(username, password);
	    
	    	}
	    };
	        
	    //Create session
	    Session session = Session.getInstance(prop, auth);
	        
	    // send Email
	    // create message
	    MimeMessage msg = new MimeMessage(session);
	    try {
	        	
	    	msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
				
			// Sender
			msg.setFrom(username);
				
			//Recipient
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
				
			// Subject
			msg.setSubject("Gửi mã xác nhận OTP");
				
			// Create random otp 
			Random random = new Random();
			otp = random.nextInt(900000) + 100000;
			msg.setText("Mã OTP: " + otp, "UTF-8");
				
			// Send the email
			Transport.send(msg);
			
	    } catch (Exception e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	}
	
		
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
		setLocation(400,200);
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
        		
		contentPane = new PanelRound();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//hien thi form dang nhap
		panelLogin = new loggin_form(this, formAdmin);
		panelLogin.setBackground(null);
		panelForgotPassword1 = new ForgotPassword1();
		panelRegister = new Register();	
		panelForgotPassword2 = new ForgotPassword2();
		panelForgotPassword3 = new ForgotPassword3();
        panelLogin.setBounds(417, 44, 300, 406);
        contentPane.add(panelLogin);
        
        //chuyen sang form quen mat khau
        ((loggin_form) panelLogin).lblForgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {            
            	
            	switchPanel(panelLogin, panelForgotPassword1);
            	
            }
        });
        
        //tro ve form dang nhap
        ((ForgotPassword1) panelForgotPassword1).lblReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {  
                
               switchPanel(panelForgotPassword1, panelLogin);
            	
            }
        });
        
        //chuyen sang form dang ky
        ((loggin_form) panelLogin).lblSignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {            
                
            	switchPanel(panelLogin, panelRegister);
                
            }
        });
        
        //chuyen tu form dang ky ve dang nhap
        ((Register) panelRegister).lblLogin.addMouseListener(new MouseAdapter() {	
            public void mouseClicked(MouseEvent e) {  
                
            	switchPanel(panelRegister, panelLogin);
                
            }
        		
        });
        
        // Gửi mã OTP và chuyển sang panel ForgotPassword2
        ((ForgotPassword1) panelForgotPassword1).btnGetOTP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String to = ForgotPassword1.getEmailText();
				if (to.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Dữ liệu email không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {	
					try {
						if(!AAADAO.isEmail(to)) {
						JOptionPane.showMessageDialog(null, "Email không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
						
						} else {	
							sendOTP(to);
							switchPanel(panelForgotPassword1, panelForgotPassword2);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
        
        // Quay về panel ForgotPassword1
        ((ForgotPassword2) panelForgotPassword2).lblReturn.addMouseListener(new MouseAdapter() {	
            public void mouseClicked(MouseEvent e) {  
                
            	switchPanel(panelForgotPassword2, panelForgotPassword1);
                
            }	
        });
        
        ((ForgotPassword2) panelForgotPassword2).lblResend.addMouseListener(new MouseAdapter( ) {
        	public void mouseClicked(MouseEvent e) {
        		sendOTP(ForgotPassword1.getEmailText());
        	}
        });
        
        // Xác nhận OTP và chuyển sang panel ForgotPassword3
        ((ForgotPassword2) panelForgotPassword2).btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String inputOTP = ForgotPassword2.getOTPText();
				if (inputOTP.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Dữ liệu OTP không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (Integer.parseInt(inputOTP) == otp) {
						switchPanel(panelForgotPassword2, panelForgotPassword3);
					} else {
						JOptionPane.showMessageDialog(null, "Mã OTP không chính xác", "Thông báo", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
        
        // Quay về panel ForgotPassword2
        ((ForgotPassword3) panelForgotPassword3).lblReturn.addMouseListener(new MouseAdapter() {	
            public void mouseClicked(MouseEvent e) {  
                
            	switchPanel(panelForgotPassword3, panelForgotPassword2);
                
            }	
        });
        
        // Xác nhận thay đổi mật khẩu và quay về panel Login
        ((ForgotPassword3) panelForgotPassword3).btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = ForgotPassword1.getEmailText();
				String newPassword = ForgotPassword3.getNewPasswordText();
				String cfmPassword = ForgotPassword3.getConfirmPasswordText();
				
				if (newPassword.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} 
				else if (cfmPassword.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (!newPassword.trim().equals(cfmPassword.trim())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không khớp", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				else {
				      try {
			                
			                ResultSet rs = AAADAO.findACbyEmail(email);

			                // Check if the account exists
			                if (rs.next()) {
			                    // Create a new Account object with the new password
			                    Account account = new Account();
			    		        account.setAccountID(rs.getString("AccountID"));
			    		        account.setName(rs.getString("Name"));
			    		        account.setEmail(rs.getString("Email"));
			    		        account.setPhone(rs.getString("Phone"));
			    		        account.setPassword(newPassword);
			    		        account.setCreated(rs.getDate("Created"));
			    		        account.setRoleID(rs.getString("RoleID"));

			                    // Update the account in the database
			                    AAADAO.updateAC(account);
			                    JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			                    switchPanel(panelForgotPassword3, panelLogin);
			                }
			            } catch (SQLException | ClassNotFoundException ex) {
			                ex.printStackTrace();
			            }
				}
			}	
		});
        
        // Tạo tài khoản và chuyển sang panel Login
        ((Register) panelRegister).btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = Register.getUsernameText();
				String email = Register.getEmailText();
				String phone = Register.getPhoneNumberText();
				String password = Register.getPasswordText();
				String cfmPassword = Register.getConfirmPasswordText();
				
				if (name.trim().isEmpty() | email.trim().isEmpty() | phone.trim().isEmpty() | password.trim().isEmpty() | cfmPassword.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (!AAADAO.isValEmail(email.trim())) {
					JOptionPane.showMessageDialog(null, "Email không đúng định dạng", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				else if (!AAADAO.isValPhoneNumber(phone)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại phải có 10 chữ số", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				else if (!password.trim().equals(cfmPassword.trim())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không khớp", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						 boolean isAccountExists = AAADAO.isEmail(email);
	                     if (isAccountExists) {
	                         JOptionPane.showMessageDialog(null, "Email đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	                     } else {
	                         // continue if doesn't exist
	                         String inputAccountId = AccountAndPermission.generateUniqueAccountId(); // create id for new account not duplicate
	                         Account acc = new Account();
	                         acc.setAccountID(inputAccountId);
	                         acc.setName(name);
	                         acc.setEmail(email);
	                         acc.setPhone(phone);
	                         acc.setPassword(password);
	                         acc.setCreated1();
	                         acc.setRoleID("RL0004"); // Mặc định là nhân viên
	                         
	                         AAADAO.getInstance().insert(acc);

	                         // success info
	                         JOptionPane.showMessageDialog(null, "Đã tạo tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	                         switchPanel(panelRegister, panelLogin);
	                     } 
					} catch (SQLException | ClassNotFoundException ex) {
		                ex.printStackTrace();
		            }
				}
			}
        });
			    	    
        //add anh login
        JLabel lblBackgroundImg = new JLabel("");
        lblBackgroundImg.setBounds(0, 0, 375, 488);
        ImageIcon scaledBackgroundImg = Utils.scaledImage(getClass().getResource("/Resource/flight.jpg"), lblBackgroundImg.getWidth(), lblBackgroundImg.getHeight());
        lblBackgroundImg.setIcon(scaledBackgroundImg);
        contentPane.add(lblBackgroundImg);
        
        //add nut thoat
        JLabel lblExit = new JLabel(); 
        lblExit.setBounds(720, 12, 18, 20); 
        ImageIcon scaledExitIcon = Utils.scaledImage(FormLogin.class.getResource("/Resource/CloseIcon2.png"), lblExit.getWidth(), lblExit.getHeight());
        lblExit.setIcon(scaledExitIcon);
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
        contentPane.add(lblExit);
	}
	
}
