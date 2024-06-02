package View.Admin.Plane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import DAO.PlaneDAO;
import DAO.SeatDAO;
import DAO.TicketClassDAO;
import Model.Plane;
import Model.Seat;
import Model.TicketClass;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreatePlane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textfieldPlaneName;
	private static JTextField textFieldChairCount;
	private JPanel seatPanel;
	private JPanel panelSeatNumer;
	private JTable tableClassTicket;
	private DefaultTableModel modelTicketLevel;
	private JTable countTicketClassTable;
	private static DefaultTableModel modelTicketcount;
	private static JPanel panelSeatMap;
	public static TicketClass[] arrayticket = new TicketClass[6];
	private static Color tmpColor = new Color(0, 102, 204);
	private static AbstractButton btnNewButton_1;
	//------------------------------

	/**
	 * Create the panel.
	 */
	public CreatePlane() {
		//------------------------------------------------------------------------------
		setLayout(null);
		setBounds(62, 73, 1365, 520);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 500, 520);
		add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 2, 40, 0));
		
		
		//--------------------------------------------------------------------------------
		JPanel panel = new JPanel();
		panelLeft.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tạo máy bay");
		lblNewLabel.setBounds(41, 20, 131, 19);
		lblNewLabel.setLabelFor(panel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel);
		
		textfieldPlaneName = new JTextField();
		textfieldPlaneName.setBounds(0, 67, 197, 30);
		panel.add(textfieldPlaneName);
		
		JLabel lblNewLabel_2 = new JLabel("Tên máy bay");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 49, 90, 19);
		panel.add(lblNewLabel_2);
		
		textFieldChairCount = new JTextField();
		textFieldChairCount.setToolTipText("Là một số chia hết cho 6 ( Tối đa 60 )");
		textFieldChairCount.setColumns(10);
		textFieldChairCount.setBounds(0, 126, 197, 30);
		panel.add(textFieldChairCount);
		
		// Khởi tạo label "Số lượng ghế"
		JLabel lblNewLabel_2_1 = new JLabel("Số lượng ghế");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(0, 107, 90, 19);
		panel.add(lblNewLabel_2_1);

		// Khởi tạo button "Tải danh sách ghế"
		JButton btnLoadSeat = new JButton("Tải danh sách ghế");
		btnLoadSeat.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Lấy số lượng ghế từ textField
		            int numButtons = Integer.parseInt(textFieldChairCount.getText());
		            // Kiểm tra điều kiện số ghế
		            if (numButtons % 6 != 0 || numButtons > 60) {
		                JOptionPane.showMessageDialog(
		                    null, 
		                    "Vui lòng nhập một số chia hết cho 6 và không lớn hơn 60!", 
		                    "Thông báo", 
		                    JOptionPane.ERROR_MESSAGE
		                );
		                return;
		            }
		            //enable ticketclasstable
		            tableClassTicket.setEnabled(true);
		            // Tạo ghế
		            panelSeatMap.removeAll();
		            CreateSeat();
		            // Tạo các button số ghế
		            JButton[] buttonArray = new JButton[numButtons / 6];
		            panelSeatNumer.removeAll();  // Xóa các button cũ (nếu có)
		            for (int i = 0; i < numButtons / 6; i++) {
		                buttonArray[i] = new JButton("" + (i + 1));
		                buttonArray[i].setPreferredSize(new Dimension(90, 40)); // Kích thước cố định
		                // Thêm button vào panel
		                panelSeatNumer.add(buttonArray[i]);
		            }

		            // Cập nhật panel
		            panelSeatNumer.revalidate();
		            panelSeatNumer.repaint();
		            
		            
		            panelSeatMap.revalidate();
		            panelSeatMap.repaint();

		        } catch (NumberFormatException ex) {
		            // Xử lý khi nhập không phải là số
		            JOptionPane.showMessageDialog(
		                null, 
		                "Vui lòng nhập một số hợp lệ!", 
		                "Thông báo", 
		                JOptionPane.ERROR_MESSAGE
		            );
		        } catch (Exception ex) {
		            // Xử lý lỗi chung
		            ex.printStackTrace();
		        }
		    }
		});

		// Đặt vị trí và kích thước cho button
		btnLoadSeat.setBounds(0, 130, 180, 30);
		panel.add(btnLoadSeat);

		btnLoadSeat.setBounds(36, 166, 161, 21);
		panel.add(btnLoadSeat);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Chi tiết hạng vé");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(0, 197, 114, 19);
		panel.add(lblNewLabel_2_1_1);
		
		JPanel panelChitietve = new JPanel();
		panelChitietve.setBorder(new LineBorder(Color.BLACK));
		panelChitietve.setBounds(0, 226, 197, 243);
		panel.add(panelChitietve);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 479, 197, 41);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 40, 0));
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Lấy dữ liệu từ label
		            String namePlane = textfieldPlaneName.getText();
		            int soLuongGhe = Integer.parseInt(textFieldChairCount.getText());

		            // Kiểm tra xem các trường dữ liệu có bị bỏ trống không
		            if (namePlane.isEmpty() || textFieldChairCount.getText().isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		            } else {
		                // Kiểm tra xem máy bay có tồn tại không
		                boolean isPlaneExists = PlaneDAO.isPlaneExists(namePlane);

		                if (isPlaneExists) {
		                    JOptionPane.showMessageDialog(null, "Máy bay đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                } else {
		                    // Nếu máy bay chưa tồn tại và các trường dữ liệu không bị bỏ trống, tiến hành thêm mới
		                    ResultSet rs = PlaneDAO.countPlane();
		                    if (rs.next()) {
		                        int planeCount = rs.getInt(1);
		                        String inputPlaneId = "PE000" + (planeCount + 1);

		                        Plane pla = new Plane();
		                        pla.setPlaneID(inputPlaneId);
		                        pla.setPlaneName(namePlane);
		                        pla.setSeatCount(soLuongGhe); // Sử dụng số lượng ghế đã lấy được
		                        PlaneDAO planeDAO = new PlaneDAO();
		                        planeDAO.insert(pla);

		                        for (Component comp : panelSeatMap.getComponents()) {
		                            if (comp instanceof JButton) {
		                                JButton seatButton = (JButton) comp;
		                                String seatID = getSeatID(seatButton);
		                                String ticketClassID = seatButton.getActionCommand();
		                                addSeatToDatabase(seatID, inputPlaneId, ticketClassID);
		                            }
		                        }

		                        // Thông báo nhập thành công
		                        JOptionPane.showMessageDialog(null, "Đã thêm máy bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập một số hợp lệ cho số lượng ghế!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});


		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnLuu);
		
		
		//------------------------------------------------------------------------
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnHuy);
		
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textfieldPlaneName.setText("");
				textFieldChairCount.setText("");
				panelSeatMap.removeAll();
				panelSeatNumer.removeAll();
				panelSeatNumer.revalidate();
	            panelSeatNumer.repaint();
	            panelSeatMap.revalidate();
	            panelSeatMap.repaint();
	            
	            btnNewButton_1.setText(arrayticket[0].getTicketClassName());
	    		btnNewButton_1.setBackground(SystemColor.GRAY);
	    		btnNewButton_1.setText("Chưa có hạng vé");
	    		
	    		tableClassTicket.setEnabled(false);
	    		
	    		int row = modelTicketcount.getRowCount();
				for(int i=0;i<row;i++) {
						modelTicketcount.setValueAt(0, i, 1);
				}
				
			}
		});
		
		
		//------------------------------------------------------------------------
		JPanel panel_1 = new JPanel();
		panelLeft.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Hạng vé", SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 18, 210, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setLabelFor(panel_1);
		panel_1.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Chưa có hạng vé");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(10, 479, 210, 41);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		UIManager.put("Button.disabledText", Color.BLACK);
		panel_1.add(btnNewButton_1);
		
		
		
		//jscroll cho hạng vé 
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 58, 210, 155);
		panel_1.add(scrollPane);
		//table cho hang ve 
		tableClassTicket = new JTable();
		tableClassTicket.setEnabled(false);
		tableClassTicket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableClassTicket.getSelectedRow();
				if(row != -1) {
					btnNewButton_1.setText(arrayticket[row].getTicketClassName());
					btnNewButton_1.setBackground(arrayticket[row].getColorTicketClass());
					tmpColor = arrayticket[row].getColorTicketClass();
				}
			}
		});
		tableClassTicket.setSurrendersFocusOnKeystroke(true);
		tableClassTicket.setColumnSelectionAllowed(true);
		tableClassTicket.setCellSelectionEnabled(true);
		tableClassTicket.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		Object [] column1 = {"Tên hạng vé","Phần trăm"};
		modelTicketLevel = new DefaultTableModel();
		modelTicketLevel.setColumnIdentifiers(column1);
		tableClassTicket.setModel(modelTicketLevel);
		//upload data
		try {
			ResultSet rs = TicketClassDAO.selectAll();
			loadRsToTableTicketLevel(rs);
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		scrollPane.setViewportView(tableClassTicket);
		panelChitietve.setLayout(null);
		
		//create chi tiet hang ve table
		JScrollPane scrollpane1 = new JScrollPane((Component) null);
		scrollpane1.setBounds(0, 0, 197, 243);
		panelChitietve.add(scrollpane1);
		
		countTicketClassTable = new JTable();
		countTicketClassTable.setSurrendersFocusOnKeystroke(false);
		countTicketClassTable.setColumnSelectionAllowed(false);
		countTicketClassTable.setCellSelectionEnabled(false);
		countTicketClassTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		Object [] obj = {"Tên hạng vé","Số lượng ghế"};
		modelTicketcount = new DefaultTableModel();
		modelTicketcount.setColumnIdentifiers(obj);
		countTicketClassTable.setModel(modelTicketcount);
		
		
		try {
			ResultSet rs = TicketClassDAO.selectAll();
			while(rs.next()) {
				modelTicketcount.addRow(new Object[] { rs.getString("TicketClassName"), 0 });
			}
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		scrollpane1.setViewportView(countTicketClassTable);
		
		
		
		//-------------------------------------------------------------------------
		seatPanel = new JPanel();
		seatPanel.setBorder(new LineBorder(Color.BLACK));
		seatPanel.setBounds(608, 51, 756, 469);
		seatPanel.setLayout(null);
		add(seatPanel);
		
		panelSeatNumer = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSeatNumer.getLayout();
		flowLayout.setVgap(6);
		flowLayout.setHgap(0);
		panelSeatNumer.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSeatNumer.setBounds(0, 0, 110, 469);
		seatPanel.add(panelSeatNumer);
		
		
		//------------------------------------
		panelSeatMap = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelSeatMap.getLayout();
		flowLayout_1.setVgap(6);
		flowLayout_1.setHgap(16);
		flowLayout_1.setAlignment(FlowLayout.CENTER);
		panelSeatMap.setBorder(new LineBorder(SystemColor.desktop));
		panelSeatMap.setPreferredSize(new Dimension(647, 454));
		panelSeatMap.setBounds(109, 0, 647, 469);
		seatPanel.add(panelSeatMap);
		


		
		//-----------------------------------------------
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(717, 26, 647, 26);
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 0));
		
		JLabel lblNewLabel_9 = new JLabel("A", SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_9.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("B", SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_8.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("C", SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_7.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("D", SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_6.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("E", SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_4.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("F", SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_3.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_3);
	}
	
	/*
	private static void CreateSeat() {
	    int numButtons = Integer.parseInt(textFieldChairCount.getText());
	    JButton[] buttonArray = new JButton[numButtons];

	    // Get the default color from the first ticket class
	    Color defaultColor = arrayticket[0].getColorTicketClass();

	    for (int i = 0; i < numButtons; i++) {
	        buttonArray[i] = new JButton();
	        buttonArray[i].setPreferredSize(new Dimension(90, 40)); // Kích thước cố định

	        // Set the background color to the default color
	        buttonArray[i].setBackground(defaultColor);

	        // Add MouseListener to change the color when clicked
	        buttonArray[i].addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                JButton clickedButton = (JButton) e.getSource();
	                // Truy vấn dữ liệu tương ứng với ghế được nhấp vào đây
	                int seatIndex = panelSeatMap.getComponentZOrder(clickedButton);
	                
	                //String row = String.valueOf((seatIndex / 6) + 1); // Số nằm ngang
	                //String column = String.valueOf((char) ('A' + seatIndex % 6)); // Chữ nằm dọc

	                // Hiển thị thông tin ghế
	                //System.out.println("Row: " + row);
	                //System.out.println("Column: " + column);
	            }
	            
	        });

	        try {
	            panelSeatMap.add(buttonArray[i]);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        panelSeatMap.revalidate();
	        panelSeatMap.repaint();
	    }
	}*/
	
	private static void CreateSeat() {
	    int numButtons = Integer.parseInt(textFieldChairCount.getText());
	    JButton[] buttonArray = new JButton[numButtons];

	    // Get the default color and ticket class ID from the first ticket class
	    Color defaultColor = arrayticket[0].getColorTicketClass();
	    String defaultTicketClassID = arrayticket[0].getTicketClassID();
	    
	    
	    //default ticketclass
		btnNewButton_1.setText(arrayticket[0].getTicketClassName());
		btnNewButton_1.setBackground(defaultColor);
		
		//set default seat count
		try {
			ResultSet rs = TicketClassDAO.selectAll();
			modelTicketcount.setRowCount(0);
			while(rs.next()) {
				if(rs.getString("TicketClassName").equals(arrayticket[0].getTicketClassName()))
				{
					modelTicketcount.addRow(new Object[] { rs.getString("TicketClassName"), numButtons });
				}
				else modelTicketcount.addRow(new Object[] { rs.getString("TicketClassName"), 0 });
			}
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		

	    for (int i = 0; i < numButtons; i++) {
	        buttonArray[i] = new JButton();
	        buttonArray[i].setPreferredSize(new Dimension(90, 40)); // Kích thước cố định

	        // Set the background color to the default color
	        buttonArray[i].setBackground(defaultColor);
	        buttonArray[i].setActionCommand(defaultTicketClassID); // Set default ticket class ID

	        // Add MouseListener to change the color and ticket class ID when clicked
	        buttonArray[i].addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                JButton clickedButton = (JButton) e.getSource();
	                // Change the background color to the selected tmpColor
	                clickedButton.setBackground(tmpColor);
	                // Update the ticket class ID
	                clickedButton.setActionCommand(getCurrentTicketClassID());
	                seatCount(buttonArray);
	            }
	        });

	        try {
	            panelSeatMap.add(buttonArray[i]);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        panelSeatMap.revalidate();
	        panelSeatMap.repaint();
	    }
	}

	// Method to get the current selected ticket class ID
	private static String getCurrentTicketClassID() {
	    for (TicketClass ticketClass : arrayticket) {
	        if (ticketClass.getColorTicketClass().equals(tmpColor)) {
	            return ticketClass.getTicketClassID();
	        }
	    }
	    return arrayticket[0].getTicketClassID(); // Default to the first ticket class if not found
	}





	

	 // Khởi tạo và set màu cho ticket class 
	public void loadRsToTableTicketLevel(ResultSet rs) throws SQLException {
	    DefaultTableModel modelTicketLevel = (DefaultTableModel) tableClassTicket.getModel();
	    modelTicketLevel.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới

	    // Mảng màu sắc tương ứng cho các hạng vé
	    Color[] ticketClassColors = {new Color(0, 102, 204), new Color(51, 153, 255), new Color(102, 204, 255), new Color(153, 204, 255), new Color(204, 229, 255)};

	    int colorIndex = 0; // Index của mảng màu
	    int i = 0 ;
	    while (rs.next()) {
	        // Lấy thông tin từ ResultSet
	    	String ticketClassID = rs.getString("TicketClassID");
	        String ticketClassName = rs.getString("TicketClassName");
	        String pricePercentage = rs.getString("PricePercentage");

	        // Tạo một đối tượng TicketClass từ thông tin lấy được và màu sắc tương ứng
	        TicketClass ticketClass = new TicketClass(ticketClassName, pricePercentage, ticketClassID, ticketClassColors[colorIndex]);

	        // Thêm đối tượng TicketClass vào bảng
	        modelTicketLevel.addRow(new Object[] { ticketClass.getTicketClassName(), ticketClass.getPricePercentage() });
	        arrayticket[i]=ticketClass;
	        // Tăng index của mảng màu, nếu vượt quá số lượng màu, quay lại màu đầu tiên
	        colorIndex = (colorIndex + 1) % ticketClassColors.length;
	        i++;
	    }
	}
	/*
	//tao ra so ngau nhien 
	private String generateUniqueTicketClassId() {
		String accountIdPrefix = "PE"; // Tiền tố của mã tài khoản
		int accountIdDigits = 3; // Số chữ số sau tiền tố
		String accountId = "";
		boolean isUnique = false;
			    
		while (!isUnique) {
			accountId = accountIdPrefix + generateRandomDigits(accountIdDigits); // Tạo mã tài khoản mới
			// Kiểm tra xem mã tài khoản mới đã tồn tại hay chưa
			 try {
			            isUnique = !PlaneDAO.isPlaneIdExists(accountId);
			        } catch (SQLException | ClassNotFoundException e) {
			            e.printStackTrace();
			        }
			    }
			    
			    return accountId;
	}
	private String generateRandomDigits(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10)); // Thêm một chữ số ngẫu nhiên vào chuỗi
		}
		return sb.toString();
	}*/
	
	//--------------------
	private static void addSeatToDatabase(String seatID, String planeID, String ticketClassID) {
	    // Tạo đối tượng Seat từ thông tin ghế
		Seat seat = new Seat();
		seat.setSeatID(seatID);
		seat.setPlaneID(planeID);
		
		// Tạo đối tượng TicketClass từ ID của hạng vé
		
		
		seat.setTicketClass(ticketClassID);

		SeatDAO seatDAO = new SeatDAO();
		// Thêm ghế vào CSDL
		seatDAO.insert(seat);
	}
	//----
	private static String getSeatID(JButton button) {
	    int seatIndex = panelSeatMap.getComponentZOrder(button);
	    String row = String.valueOf((seatIndex / 6) + 1); // Số nằm ngang
	    String column = String.valueOf((char) ('A' + seatIndex % 6)); // Chữ nằm dọc
	    return column + row;
	}
	private static void seatCount(JButton[] buttonArray) {
		try {
			ResultSet rs = TicketClassDAO.selectAll();
			int ticketClassCount = 0;
			int row = modelTicketcount.getRowCount();
			// 
			while(rs.next()) {
				for(int i=0;i<buttonArray.length;i++) {
					if (buttonArray[i].getActionCommand().equals(rs.getString("TicketClassID"))) {
						ticketClassCount++;
					}
				}
				for(int i=0;i<row;i++) {
					if(modelTicketcount.getValueAt(i, 0).toString().equals(rs.getString("TicketClassName"))){
						modelTicketcount.setValueAt(ticketClassCount, i, 1);
					}
				}
				ticketClassCount=0;

			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
