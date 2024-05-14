package View.Admin.Setting;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DALs.AirportDAL;
import DAO.AAADAO;
import DAO.AirportDAO;
import DAO.ParametersDAO;
import DAO.TicketClassDAO;
import Model.Account;
import Model.Airport;
import Model.Parameters;
import Model.TicketClass;
import libData.JDBCUtil;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import View.Admin.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Setting extends JPanel {
	//------------------------------------value----------------------------------------------------
	private static final long serialVersionUID = 1L;
	//airport table
	private static JTable table;
	// text field to insert airport
	private JTextField inputNameAirport;
	private JTextField inputNameCity;
	private JTextField inputNameCountry;
	//text field to for setting value
	private JTextField tfminimumFlightTime;
	private JTextField tfmaxPreventiveAirports;
	private JTextField tfminimumStopoverTime;
	private JTextField tfmaximumStopoverTime;
	private JTextField tfearliestBookingTime;
	private JTextField tflatestBookingCancellationTime;
	//text field for setting ticket class
	private JTextField inputNameClass;
	private JTextField inputNamePercent;
	//create table for ticket class
	private JTable table_1;
	static JPanel contentPane;
	DefaultTableModel model;
	private DefaultTableModel modelTicketLevel;
	private JLabel lbearliestBookingTime;
	public Parameters settingValue = new Parameters();
	private Button btInsertAirport;
	
	//------------------------------setting main------------------------------------------------------
	public Setting() throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);
		
		//-----------------------------airport table--------------------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1520, 297);
		add(panel);
		panel.setLayout(null);
		//create airport label
		JLabel lblNewLabel = new JLabel("SÂN BAY");
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(741, 5, 88, 25);
		panel.add(lblNewLabel);
		// create airport table
		table = new JTable(); 
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		//table model
        model = new DefaultTableModel();
        Object[] column = {"Tên sân bay", "Tên thành phố", "Tên đất nước"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
		table.setRowHeight(30);
		//load airport data from database
        try {
        	ResultSet rs = AirportDAO.selectAll();
        	loadRsToTable(rs);      
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }	
        //add table to panel
        panel.add(new JScrollPane(table));
        add(panel);
		//create scroll pane for table
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 770, 257); // Thiết lập vị trí và kích thước của thanh cuộn
		panel.add(scrollPane);
		//setting click table
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();
						if(row != -1) {
							btInsertAirport.setVisible(false);
							//String NameAirport = table.getValueAt(row, 0).toString();
							/*
							try (ResultSet rs = AirportDAO.findAPbyName(NameAirport)){
								
							}
							*/
							inputNameAirport.setText(table.getValueAt(row, 0).toString());
							inputNameCity.setText(table.getValueAt(row, 1).toString());
							inputNameCountry.setText(table.getValueAt(row, 2).toString());
							/*
							JTextField inputNameCity;
							JTextField inputNameCountry;
							*/
						}
						
					}
				});
		
		//--------------------------------airport input-----------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(790, 40, 706, 257);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelNameAirport = new JLabel("Tên sân bay :");
		labelNameAirport.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelNameAirport.setBounds(35, 25, 99, 26);
		panel_1.add(labelNameAirport);
		
		JLabel lbNameCity = new JLabel("Tên thành phố :");
		lbNameCity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNameCity.setBounds(35, 87, 199, 26);
		panel_1.add(lbNameCity);
		
		JLabel lbNameCountry = new JLabel("Tên đất nước :");
		lbNameCountry.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNameCountry.setBounds(35, 147, 99, 26);
		panel_1.add(lbNameCountry);
		
		inputNameAirport = new JTextField();
		inputNameAirport.setBounds(161, 25, 334, 24);
		panel_1.add(inputNameAirport);
		inputNameAirport.setColumns(10);
		
		inputNameCity = new JTextField();
		inputNameCity.setColumns(10);
		inputNameCity.setBounds(161, 87, 334, 24);
		panel_1.add(inputNameCity);
		
		inputNameCountry = new JTextField();
		inputNameCountry.setColumns(10);
		inputNameCountry.setBounds(161, 147, 334, 24);
		panel_1.add(inputNameCountry);
		
		//button to insert airport to table
		btInsertAirport = new Button("Thêm ");
		btInsertAirport.setFont(new Font("Arial", Font.BOLD, 14));
		btInsertAirport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			        // Lấy dữ liệu nhập vào từ các trường
			        String airportName = inputNameAirport.getText();
			        String cityName = inputNameCity.getText();
			        String countryName = inputNameCountry.getText();
			        
			        // Kiểm tra xem các trường dữ liệu có bị bỏ trống không
			        if (airportName.isEmpty() || cityName.isEmpty() || countryName.isEmpty()) {
			            // Nếu có trường dữ liệu nào bị bỏ trống, hiển thị thông báo
			            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			        } else {
			            // Kiểm tra xem sân bay có trùng không
			            boolean isAirportExists = AirportDAO.isAirportExists(airportName, cityName, countryName);
			            
			            if (isAirportExists) {
			                JOptionPane.showMessageDialog(null, "Sân bay đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            } else {
			                // Nếu sân bay chưa tồn tại và các trường dữ liệu không bị bỏ trống, tiến hành thêm mới
			                ResultSet rs = AirportDAO.countAirport();
			                if (rs.next()) {
			                    int airportCount = rs.getInt(1);
			                    String inputAirportId = "AP0" + (airportCount + 1);

			                    Airport air = new Airport();
			                    air.setAirportID(inputAirportId);
			                    air.setAirportName(airportName);
			                    air.setCityName(cityName);
			                    air.setCountryName(countryName);
			                    AirportDAO.getInstance().insert(air);
			                    
			                    // Thông báo nhập thành công
			                    JOptionPane.showMessageDialog(null, "Đã thêm sân bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			                    
			                    // Xóa nội dung trong các trường nhập liệu
			                    inputNameAirport.setText("");
			                    inputNameCity.setText("");
			                    inputNameCountry.setText("");
			                    // Load lại dữ liệu lên JTable
			                    ResultSet updatedRs = AirportDAO.selectAll();
			                    loadRsToTable(updatedRs);
			                } else {
			                    // Xử lý trường hợp không có kết quả từ phương thức countAirport()
			                }
			            }
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        // Xử lý ngoại lệ khi có lỗi xảy ra khi truy vấn cơ sở dữ liệu
			    } catch (ClassNotFoundException ex) {
			        // Xử lý ngoại lệ ClassNotFoundException
			        ex.printStackTrace();
			        // Hoặc thông báo lỗi cho người dùng
			        JOptionPane.showMessageDialog(null, "Không tìm thấy lớp cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			    }
			}

		});
		//setting design for button
		btInsertAirport.setForeground(new Color(255, 255, 255));
		btInsertAirport.setBackground(new Color(3, 4, 94));
		btInsertAirport.setBounds(33, 199, 576, 50);
		panel_1.add(btInsertAirport);
		
		//button update airport
		Button btUpdate = new Button("Cập nhập");
		Button button = new Button();
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//				    int selectedRowIndex = table.getSelectedRow();
//				    if (selectedRowIndex != -1) {
//				        String airportNameRow = table.getValueAt(selectedRowIndex, 0).toString();
//				        ResultSet rs = AirportDAO.findAPbyName(airportNameRow);
//				        
//				        // Check if ResultSet has any rows
//				        if (rs.next()) {
//				            // If ResultSet has rows, retrieve data
//				            Airport ap = new Airport();
//				            ap.setAirportID(rs.getString("AirportID"));
//				            ap.setAirportName(inputNameAirport.getText());
//				            ap.setCityName(inputNameCity.getText());
//				            ap.setCountryName(inputNameCountry.getText());
//				            
//				            int isUpdated = AirportDAO.update(ap);
//				            
//				            if (isUpdated > 0) {
//				                ResultSet updatedRs = AirportDAO.selectAll();
//				                loadRsToTable(updatedRs);
//				                inputNameAirport.setText("");
//				                inputNameCity.setText("");
//				                inputNameCountry.setText("");
//				                btInsertAirport.setVisible(true);
//				                JOptionPane.showMessageDialog(null, "Cập nhật sân bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//				            } else {
//				                JOptionPane.showMessageDialog(null, "Cập nhật sân bay thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//				            }
//				        } else {
//				            // ResultSet is empty, show a message
//				            JOptionPane.showMessageDialog(null, "Không tìm thấy sân bay có tên này!", "Thông báo", JOptionPane.WARNING_MESSAGE);
//				        }
//				    } else {
//				        JOptionPane.showMessageDialog(null, "Vui lòng chọn một sân bay để cập nhật!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
//				    }
//				} catch (SQLException ex) {
//				    ex.printStackTrace();
//				} catch (ClassNotFoundException ex) {
//				    ex.printStackTrace();
//				}
//		    }
//		});
		btUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btUpdate.setForeground(new Color(255, 255, 255));
		btUpdate.setBackground(new Color(3, 4, 94));
		btUpdate.setBounds(46, 199, 168, 48);
		panel_1.add(btUpdate);
		
		
		//button delete airport
		Button btDelete = new Button("Xóa");
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AirportDAO.deleteByName(inputNameAirport.getText());
				inputNameAirport.setText("");
                inputNameCity.setText("");
                inputNameCountry.setText("");
                // Load lại dữ liệu lên JTable

                btInsertAirport.setVisible(true);
                ResultSet rs;
				try {
					rs = AirportDAO.countAirport();
					if (rs.next()) {
						ResultSet updatedRs = AirportDAO.selectAll();
		                loadRsToTable(updatedRs);
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btDelete.setForeground(new Color(255, 255, 255));
		btDelete.setBackground(new Color(192, 192, 192));
		btDelete.setBounds(267, 199, 159, 48);
		panel_1.add(btDelete);
		
		
		//button cancel airport
		Button btCancel = new Button("Hủy");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNameAirport.setText("");
				inputNameCity.setText("");
				inputNameCountry.setText("");
				btInsertAirport.setVisible(true);
			}
		});
		btCancel.setFont(new Font("Arial", Font.BOLD, 14));
		btCancel.setActionCommand("Hủy");
		btCancel.setForeground(Color.WHITE);
		btCancel.setBackground(new Color(128, 128, 128));
		btCancel.setBounds(472, 199, 137, 48);
		panel_1.add(btCancel);
		
		
		
		
		//cai dat co ban 
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(10, 338, 590, 290);
		add(panel_1_1);
		
		JLabel lbminimunFlightTime = new JLabel("Thời gian bay tối thiểu ");
		lbminimunFlightTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbminimunFlightTime.setBounds(10, 10, 174, 26);
		panel_1_1.add(lbminimunFlightTime);
		
		JLabel lbmaxPreventiveAirports = new JLabel("Số sân bay trung gian tối đa");
		lbmaxPreventiveAirports.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbmaxPreventiveAirports.setBounds(10, 46, 198, 26);
		panel_1_1.add(lbmaxPreventiveAirports);
		
		JLabel lbminimunStopoverTime = new JLabel("Thời gian dừng tối thiểu");
		lbminimunStopoverTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbminimunStopoverTime.setBounds(10, 82, 187, 26);
		panel_1_1.add(lbminimunStopoverTime);
		
		JLabel lbmaximumStopoverTime = new JLabel("Thời gian dừng tối đa ");
		lbmaximumStopoverTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbmaximumStopoverTime.setBounds(10, 118, 198, 26);
		panel_1_1.add(lbmaximumStopoverTime);
		
		lbearliestBookingTime = new JLabel("Thời gian đặt vé chậm nhất ");
		lbearliestBookingTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbearliestBookingTime.setBounds(10, 154, 198, 26);
		panel_1_1.add(lbearliestBookingTime);
		
		JLabel lblatestBookingCancellationTime = new JLabel("Thời gian hủy đặt vé chậm nhất ");
		lblatestBookingCancellationTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblatestBookingCancellationTime.setBounds(10, 190, 210, 26);
		panel_1_1.add(lblatestBookingCancellationTime);
		
		
		tfminimumFlightTime = new JTextField();
		tfminimumFlightTime.setBounds(255, 15, 81, 19);
		panel_1_1.add(tfminimumFlightTime);
		tfminimumFlightTime.setColumns(10);
		tfmaxPreventiveAirports = new JTextField();
		
		tfmaxPreventiveAirports.setColumns(10);
		tfmaxPreventiveAirports.setBounds(255, 51, 81, 19);
		panel_1_1.add(tfmaxPreventiveAirports);
		
		tfminimumStopoverTime = new JTextField();
		tfminimumStopoverTime.setColumns(10);
		tfminimumStopoverTime.setBounds(255, 87, 81, 19);
		panel_1_1.add(tfminimumStopoverTime);
		
		tfmaximumStopoverTime = new JTextField();
		tfmaximumStopoverTime.setColumns(10);
		tfmaximumStopoverTime.setBounds(255, 123, 81, 19);
		panel_1_1.add(tfmaximumStopoverTime);
		
		tfearliestBookingTime = new JTextField();
		tfearliestBookingTime.setColumns(10);
		tfearliestBookingTime.setBounds(255, 159, 81, 19);
		panel_1_1.add(tfearliestBookingTime);
		
		tflatestBookingCancellationTime = new JTextField();
		tflatestBookingCancellationTime.setColumns(10);
		tflatestBookingCancellationTime.setBounds(255, 195, 81, 19);
		panel_1_1.add(tflatestBookingCancellationTime);
		
		//
		reloadSetting();
		//
		JLabel lblNewLabel_1_3_1 = new JLabel("Phút");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(356, 10, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Phút");
		lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_1.setBounds(356, 82, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Phút");
		lblNewLabel_1_3_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2.setBounds(356, 118, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_1_3_1_2_1 = new JLabel("Ngày");
		lblNewLabel_1_3_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1.setBounds(356, 154, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1);
		
		JLabel lblNewLabel_1_3_1_2_1_1 = new JLabel("Ngày");
		lblNewLabel_1_3_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1_1.setBounds(356, 190, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1_1);
		
		JLabel lblNewLabel_1_3_1_2_1_2 = new JLabel("Sân");
		lblNewLabel_1_3_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1_2.setBounds(356, 46, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1_2);
		
		//nut lưu setting cơ bản 
		Button button_3 = new Button("Lưu");
		button_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int minimumFlightTime = Integer.parseInt(tfminimumFlightTime.getText());
		            int tfmaxPreventiveAirports1 = Integer.parseInt(tfmaxPreventiveAirports.getText());
		            int tfminimumStopoverTime1 = Integer.parseInt(tfminimumStopoverTime.getText());
		            int tfmaximumStopoverTime1 = Integer.parseInt(tfmaximumStopoverTime.getText());
		            int tfearliestBookingTime1 = Integer.parseInt(tfearliestBookingTime.getText());
		            int tflatestBookingCancellationTime1 = Integer.parseInt(tflatestBookingCancellationTime.getText());
		            
		            // Kiểm tra điều kiện tfminimumStopoverTime1 < tfmaximumStopoverTime1
		            if (tfminimumStopoverTime1 >= tfmaximumStopoverTime1) {
		                JOptionPane.showMessageDialog(null, "Thời gian dừng tối thiểu phải nhỏ hơn thời gian dừng tối đa.");
		                return; // Dừng phương thức nếu điều kiện không được thỏa mãn
		            }
		            
		            // Tiếp tục nếu điều kiện được thỏa mãn
		            
		            settingValue.setMinimumFlightTime(minimumFlightTime);
		            settingValue.setMaxPreventiveAirports(tfmaxPreventiveAirports1);
		            settingValue.setMinimumStopoverTime(tfminimumStopoverTime1);
		            settingValue.setMaximumStopoverTime(tfmaximumStopoverTime1);
		            settingValue.setEarliestBookingTime(tfearliestBookingTime1);
		            settingValue.setLatestBookingCancellationTime(tflatestBookingCancellationTime1);
		            
		            int rowsAffected = ParametersDAO.updateFightTime(settingValue);
		            reloadSetting();
		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(null, "Dữ liệu đã được cập nhật thành công.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Không có bản ghi nào được cập nhật.");
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Lỗi SQL: " + ex.getMessage());
		            ex.printStackTrace();
		        } catch (ClassNotFoundException ex) {
		            JOptionPane.showMessageDialog(null, "Không tìm thấy lớp: " + ex.getMessage());
		            ex.printStackTrace();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ cho các trường dữ liệu.");
		            ex.printStackTrace();
		        }
		    }
		});

		button_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(3, 4, 94));
		button_3.setBounds(10, 243, 570, 37);
		panel_1_1.add(button_3);
		
		
		//HANG VE
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_2.setBounds(639, 338, 836, 290);
		add(panel_1_2);
		
		JLabel lbNameClass = new JLabel("Tên hạng vé :");
		lbNameClass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNameClass.setBounds(416, 59, 99, 26);
		panel_1_2.add(lbNameClass);
		
		JLabel lbNamePercent = new JLabel("Phần trăm đơn giá :");
		lbNamePercent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbNamePercent.setBounds(416, 121, 199, 26);
		panel_1_2.add(lbNamePercent);
		
		inputNameClass = new JTextField();
		inputNameClass.setColumns(10);
		inputNameClass.setBounds(558, 62, 221, 24);
		panel_1_2.add(inputNameClass);
		
		inputNamePercent = new JTextField();
		inputNamePercent.setColumns(10);
		inputNamePercent.setBounds(558, 124, 221, 24);
		panel_1_2.add(inputNamePercent);
		
		Button btnThemTicketClass = new Button("Thêm ");
		btnThemTicketClass.setFont(new Font("Arial", Font.BOLD, 14));
		btnThemTicketClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        // Kiểm tra xem tài khoản có tồn tại không
			        boolean isClassTicketExists = TicketClassDAO.isTicketClassExists(inputNameAirport.getText());
			        if (isClassTicketExists) {
			            JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			        } else {
			        	// Nếu sân bay chưa tồn tại, tiến hành thêm mới
		                ResultSet rs = TicketClassDAO.countTicketClass();
		                if (rs.next()) {
		                   
		                    String inputAirportId = generateUniqueTicketClassId();

		                    TicketClass ticketClass = new TicketClass();
		                    ticketClass.setTicketClassID(inputAirportId);
		                    ticketClass.setTicketClassName(inputNameClass.getText());
		                    ticketClass.setPricePercentage(inputNamePercent.getText());
		                    TicketClassDAO.getInstance().insert(ticketClass);
		                    
		                    // Thông báo nhập thành công
		                    JOptionPane.showMessageDialog(null, "Đã thêm sân bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		                    
		                    // Xóa nội dung trong các trường nhập liệu
		                    inputNameClass.setText("");
		                    inputNamePercent.setText("");
		               
		                    // Load lại dữ liệu lên JTable
		                    ResultSet updatedRs = TicketClassDAO.selectAll();
		                    loadRsToTableTicketLevel(updatedRs);
		                } else {
		                    // Xử lý trường hợp không có kết quả từ phương thức countAirport()
		                }
		            }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        // Xử lý ngoại lệ khi có lỗi xảy ra khi truy vấn cơ sở dữ liệu
			    } catch (ClassNotFoundException ex) {
			        ex.printStackTrace();
			        // Xử lý ngoại lệ ClassNotFoundException
			        JOptionPane.showMessageDialog(null, "Không tìm thấy lớp cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		btnThemTicketClass.setForeground(Color.WHITE);
		btnThemTicketClass.setBackground(new Color(3, 4, 94));
		btnThemTicketClass.setBounds(416, 243, 410, 37);
		panel_1_2.add(btnThemTicketClass);
		
		Button btnUpdateTicketClass = new Button("Cập nhập");
		btnUpdateTicketClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//----------------------------------
				try {
				    int selectedRowIndex = table_1.getSelectedRow();
				    if (selectedRowIndex != -1) {
				        String airportNameRow = table.getValueAt(selectedRowIndex, 0).toString();
				        ResultSet rs = TicketClassDAO.findTCbynName(airportNameRow);
				        
				        // Check if ResultSet has any rows
				        if (rs.next()) {
				            // If ResultSet has rows, retrieve data
				            TicketClass ap = new TicketClass();
				            ap.setTicketClassID(rs.getString("TicketClassID"));
				            ap.setTicketClassName(inputNameClass.getText());
				            ap.setPricePercentage(inputNamePercent.getText());
				            
				            
				            int isUpdated = TicketClassDAO.updateTicketClass(ap);
				            
				            if (isUpdated > 0) {
				                ResultSet updatedRs = AirportDAO.selectAll();
				                loadRsToTable(updatedRs);
				                inputNameAirport.setText("");
				                inputNameCity.setText("");
				                inputNameCountry.setText("");
				                btInsertAirport.setVisible(true);
				                JOptionPane.showMessageDialog(null, "Cập nhật sân bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				            } else {
				                JOptionPane.showMessageDialog(null, "Cập nhật sân bay thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				            }
				        } else {
				            // ResultSet is empty, show a message
				            JOptionPane.showMessageDialog(null, "Không tìm thấy sân bay có tên này!", "Thông báo", JOptionPane.WARNING_MESSAGE);
				        }
				    } else {
				        JOptionPane.showMessageDialog(null, "Vui lòng chọn một sân bay để cập nhật!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
				    }
				} catch (SQLException ex) {
				    ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
				    ex.printStackTrace();
				}
			}
		});
		btnUpdateTicketClass.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdateTicketClass.setForeground(Color.WHITE);
		btnUpdateTicketClass.setBackground(new Color(3, 4, 94));
		btnUpdateTicketClass.setBounds(416, 180, 131, 37);
		panel_1_2.add(btnUpdateTicketClass);
		
		Button buttonDeleteTicketClass = new Button("Xóa");
		buttonDeleteTicketClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketClassDAO.deleteByName(inputNameClass.getText());
				inputNameClass.setText("");
				inputNamePercent.setText("");
				btnThemTicketClass.setVisible(true);
				// Load lại dữ liệu lên JTable
                ResultSet updatedRs;
				try {
					updatedRs = TicketClassDAO.selectAll();
					loadRsToTableTicketLevel(updatedRs);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
			}
		});
		buttonDeleteTicketClass.setFont(new Font("Arial", Font.BOLD, 14));
		buttonDeleteTicketClass.setForeground(Color.WHITE);
		buttonDeleteTicketClass.setBackground(Color.LIGHT_GRAY);
		buttonDeleteTicketClass.setBounds(573, 180, 123, 37);
		panel_1_2.add(buttonDeleteTicketClass);
		
		JLabel lbHangVe = new JLabel("HẠNG VÉ");
		lbHangVe.setHorizontalAlignment(SwingConstants.CENTER);
		lbHangVe.setForeground(new Color(0, 0, 160));
		lbHangVe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbHangVe.setBounds(0, 10, 696, 25);
		panel_1_2.add(lbHangVe);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		
		scrollPane_1.setBounds(10, 45, 382, 235);
		panel_1_2.add(scrollPane_1);
		
		//table ticket class
		table_1 = new JTable();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		Object [] column1 = {"Tên hạng vé","Phần trăm"};
		modelTicketLevel = new DefaultTableModel();
		modelTicketLevel.setColumnIdentifiers(column1);
		table_1.setModel(modelTicketLevel);
		//upload data
		try {
			ResultSet rs = TicketClassDAO.selectAll();
			loadRsToTableTicketLevel(rs);
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		scrollPane_1.setViewportView(table_1);
		
		Button buttonCancelTicketClass = new Button("Hủy ");
		buttonCancelTicketClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNameClass.setText("");
            	inputNamePercent.setText("");
            	btnThemTicketClass.setVisible(true);
			}
		});
		buttonCancelTicketClass.setForeground(Color.WHITE);
		buttonCancelTicketClass.setFont(new Font("Arial", Font.BOLD, 14));
		buttonCancelTicketClass.setBackground(new Color(128, 128, 128));
		buttonCancelTicketClass.setBounds(714, 180, 112, 37);
		panel_1_2.add(buttonCancelTicketClass);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow(); // Lấy dòng được chọn
				if (row != -1) {
					String nameTicketClass = table_1.getValueAt(row, 0).toString();
					try (ResultSet rs = TicketClassDAO.findTCbynName(nameTicketClass)) {
		                // Xử lý ResultSet để trích xuất dữ liệu
		                if (rs.next()) {
		                	inputNameClass.setText(rs.getString("TicketClassName"));
		                	inputNamePercent.setText(rs.getString("PricePercentage"));
		                	btnThemTicketClass.setVisible(false);
		        
		                    // Hiển thị thông tin tài khoản hoặc thực hiện các thao tác khác ở đây
		                } else {
		                    // Không có tài khoản nào được tìm thấy
		                }
		            } catch (SQLException | ClassNotFoundException ex) {
		                ex.printStackTrace();
		                // Xử lý ngoại lệ
		            }
					
				}
			}
		});
		
	}
	
	
	
	//load data len teable tai bang setting 
	public void loadRsToTable(ResultSet rs) throws SQLException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		while(rs.next()) {
			model.addRow(new Object[] {
					rs.getString("AirportName"),
					rs.getString("CityName"),
					rs.getString("CountryName"),
					
			});
		}
	}
	//reload setting value
	public void reloadSetting() {
		try {
			settingValue.setMinimumFlightTime(ParametersDAO.getMinimumFlightTime());
			settingValue.setMaxPreventiveAirports(ParametersDAO.getMaxPreventiveAirport());
			settingValue.setMinimumStopoverTime(ParametersDAO.getMiniMumStopoverTime());
			settingValue.setMaximumStopoverTime(ParametersDAO.getMaximumStopoverTime());
			settingValue.setEarliestBookingTime(ParametersDAO.getEarliestBookingTime());
			settingValue.setLatestBookingCancellationTime(ParametersDAO.getLatestBookingCancellationTime());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfminimumFlightTime.setText(Integer.toString(settingValue.getMinimumFlightTime()));
		tfmaxPreventiveAirports.setText(Integer.toString(settingValue.getMaxPreventiveAirports()));
		tfminimumStopoverTime.setText(Integer.toString(settingValue.getMinimumStopoverTime()));
		tfmaximumStopoverTime.setText(Integer.toString(settingValue.getMaximumStopoverTime()));
		tfearliestBookingTime.setText(Integer.toString(settingValue.getEarliestBookingTime()));
		tflatestBookingCancellationTime.setText(Integer.toString(settingValue.getLatestBookingCancellationTime()));
	}
	
	// Phương thức để load dữ liệu lên bảng hạng vé
	public void loadRsToTableTicketLevel(ResultSet rs) throws SQLException {
	    DefaultTableModel modelTicketLevel = (DefaultTableModel) table_1.getModel();
	    modelTicketLevel.setRowCount(0);
	    while (rs.next()) {
	        modelTicketLevel.addRow(new Object[] {
	            rs.getString("TicketClassName"), // Use getString instead of getInt
	            rs.getString("PricePercentage"), // Assuming PricePercentage is also a string
	        });
	    }
	}
	private String generateUniqueTicketClassId() {
		String accountIdPrefix = "AC"; // Tiền tố của mã tài khoản
		int accountIdDigits = 3; // Số chữ số sau tiền tố
		String accountId = "";
		boolean isUnique = false;
			    
		while (!isUnique) {
			accountId = accountIdPrefix + generateRandomDigits(accountIdDigits); // Tạo mã tài khoản mới
			// Kiểm tra xem mã tài khoản mới đã tồn tại hay chưa
			 try {
			            isUnique = !AAADAO.isAccountIdExists(accountId);
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
	}
}
