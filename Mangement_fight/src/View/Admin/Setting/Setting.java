package View.Admin.Setting;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import CustomUI.BtnCS;
import CustomUI.JtfCS;
import CustomUI.Table.TableActionButton;
import CustomUI.Table.TableActionCellEditor;
import CustomUI.Table.TableActionCellRender;
import CustomUI.Table.TableActionEvent;
import CustomUI.Table.JTblCS;
import CustomUI.Table.TablePanelAction;
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
import javax.swing.border.EmptyBorder;
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
	private static JTblCS table;
	// text field to insert airport
	private JtfCS inputNameAirport;
	private JtfCS inputNameCity;
	private JtfCS inputNameCountry;
	//text field to for setting value
	private JtfCS tfminimumFlightTime;
	private JtfCS tfmaxPreventiveAirports;
	private JtfCS tfminimumStopoverTime;
	private JtfCS tfmaximumStopoverTime;
	private JtfCS tfearliestBookingTime;
	private JtfCS tflatestBookingCancellationTime;
	//text field for setting ticket class
	private JtfCS inputNameClass;
	private JtfCS inputNamePercent;
	//create table for ticket class
	private JTblCS table_1;
	static JPanel contentPane;
	DefaultTableModel model;
	private DefaultTableModel modelTicketLevel;
	private JLabel lbearliestBookingTime;
	public Parameters settingValue = new Parameters();
	private BtnCS btInsertAirport;
	private BtnCS tmp1;
	
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
		table = new JTblCS(); 
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		//table model
        model = new DefaultTableModel(){
        	  @Override
              public boolean isCellEditable(int row, int column) {
                  if (column == 3)
                  {
                	  return true;
                  }
                  return false;
        	  }
        };
        Object[] column = {"Tên sân bay", "Tên thành phố", "Tên đất nước", "Thao tác"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
		table.setRowHeight(40);
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
		table.fixTable(scrollPane);
//		//setting click table
//				table.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int row = table.getSelectedRow();
//						if(row != -1) {
//							btInsertAirport.setVisible(false);
//							//String NameAirport = table.getValueAt(row, 0).toString();
//							/*
//							try (ResultSet rs = AirportDAO.findAPbyName(NameAirport)){
//								
//							}
//							*/
//							inputNameAirport.setText(table.getValueAt(row, 0).toString());
//							inputNameCity.setText(table.getValueAt(row, 1).toString());
//							inputNameCountry.setText(table.getValueAt(row, 2).toString());
//							/*
//							JTextField inputNameCity;
//							JTextField inputNameCountry;
//							*/
//						}
//						
//					}
//				});
		
		TableColumnModel columnModel = table.getColumnModel();
		// Set the preferred, minimum, and maximum widths for each column	        
		TableColumn column0 = columnModel.getColumn(0);       
		column0.setPreferredWidth(300);        
		column0.setMinWidth(300);
		table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                btInsertAirport.setVisible(false);
                inputNameAirport.setText(table.getValueAt(row, 0).toString());
                inputNameCity.setText(table.getValueAt(row, 1).toString());
                inputNameCountry.setText(table.getValueAt(row, 2).toString());
            }

			@Override
			public void onDelete(int row) {
				// TODO Auto-generated method stub
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


        }));
		
		//--------------------------------airport input-----------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(790, 40, 706, 257);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelNameAirport = new JLabel("Tên sân bay :");
		labelNameAirport.setFont(new Font("Times New Roman", Font.BOLD, 17));
		labelNameAirport.setBounds(35, 27, 99, 26);
		panel_1.add(labelNameAirport);
		
		JLabel lbNameCity = new JLabel("Tên thành phố :");
		lbNameCity.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbNameCity.setBounds(35, 87, 199, 26);
		panel_1.add(lbNameCity);
		
		JLabel lbNameCountry = new JLabel("Tên đất nước :");
		lbNameCountry.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbNameCountry.setBounds(35, 143, 124, 26);
		panel_1.add(lbNameCountry);
		
		inputNameAirport = new JtfCS();
		inputNameAirport.setFont(new Font("Times New Roman", Font.BOLD, 15));
		inputNameAirport.setShadowColor(new Color(0, 128, 255));
		inputNameAirport.setToolTipText("");
		inputNameAirport.setBounds(161, 25, 334, 38);
		panel_1.add(inputNameAirport);
		inputNameAirport.setColumns(10);
		
		inputNameCity = new JtfCS();
		inputNameCity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		inputNameCity.setColumns(10);
		inputNameCity.setBounds(161, 86, 334, 38);
		panel_1.add(inputNameCity);
		
		inputNameCountry = new JtfCS();
		inputNameCountry.setFont(new Font("Times New Roman", Font.BOLD, 15));
		inputNameCountry.setColumns(10);
		inputNameCountry.setBounds(161, 142, 334, 38);
		panel_1.add(inputNameCountry);
		
		//button to insert airport to table
		btInsertAirport = new BtnCS();
		btInsertAirport.setText("THÊM");
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
		
		
		btInsertAirport.setColorOver(new Color(0, 0, 160));
		btInsertAirport.setColor(new Color(3, 4, 94));
		btInsertAirport.setBorderColor(new Color(3, 4, 94));
		btInsertAirport.setRadius(30);
		btInsertAirport.setBounds(39, 199, 570, 48);
		panel_1.add(btInsertAirport);
		
		
		
		//button update airport
		BtnCS btUpdate = new BtnCS();
		btUpdate.setText("CẬP NHẬT");
		btUpdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int selectedRowIndex = table.getSelectedRow();
		            if (selectedRowIndex != -1) {
		                String airportNameRow = table.getValueAt(selectedRowIndex, 0).toString();
		                ResultSet rs = AirportDAO.findAPbyName(airportNameRow);
		                
		                if (rs.next()) {
		                    // If ResultSet has rows, retrieve data
		                    Airport ap = new Airport();
		                    ap.setAirportID(rs.getString("AirportID"));
		                    ap.setAirportName(inputNameAirport.getText());
		                    ap.setCityName(inputNameCity.getText());
		                    ap.setCountryName(inputNameCountry.getText());
		                    
		                    int isUpdated = AirportDAO.updatebyID(ap);
		                    
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
		btUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btUpdate.setForeground(new Color(255, 255, 255));
		btUpdate.setBackground(new Color(3, 4, 94));
		btUpdate.setBounds(46, 199, 168, 48);
		btUpdate.setColorOver(new Color(0, 0, 160));
		btUpdate.setColor(new Color(3, 4, 94));
		btUpdate.setBorderColor(new Color(3, 4, 94));
		btUpdate.setRadius(30);
		
		panel_1.add(btUpdate);
		
		//button delete airport
		BtnCS btDelete = new BtnCS();
		btDelete.setColorClick(new Color(217, 217, 217));
		btDelete.setColorOver(new Color(217, 217, 217));
		btDelete.setColor(new Color(192, 192, 192));
		btDelete.setBorderColor(new Color(192, 192, 192));
		btDelete.setRadius(30);
		btDelete.setText("XÓA");
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
		BtnCS btCancel = new BtnCS();
		btCancel.setColorClick(new Color(156, 156, 156));
		btCancel.setColorOver(new Color(156, 156, 156));
		btCancel.setColor(new Color(128, 128, 128));
		btCancel.setRadius(30);
		btCancel.setBorderColor(new Color(128, 128, 128));
		btCancel.setText("HỦY");
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
		lbminimunStopoverTime.setBounds(10, 89, 187, 26);
		panel_1_1.add(lbminimunStopoverTime);
		
		JLabel lbmaximumStopoverTime = new JLabel("Thời gian dừng tối đa ");
		lbmaximumStopoverTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbmaximumStopoverTime.setBounds(10, 125, 198, 26);
		panel_1_1.add(lbmaximumStopoverTime);
		
		lbearliestBookingTime = new JLabel("Thời gian đặt vé chậm nhất ");
		lbearliestBookingTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbearliestBookingTime.setBounds(10, 161, 198, 26);
		panel_1_1.add(lbearliestBookingTime);
		
		JLabel lblatestBookingCancellationTime = new JLabel("Thời gian hủy đặt vé chậm nhất ");
		lblatestBookingCancellationTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblatestBookingCancellationTime.setBounds(10, 197, 210, 26);
		panel_1_1.add(lblatestBookingCancellationTime);
		
		
		tfminimumFlightTime = new JtfCS();
		tfminimumFlightTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfminimumFlightTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfminimumFlightTime.setBounds(255, 10, 81, 38);
		panel_1_1.add(tfminimumFlightTime);
		tfminimumFlightTime.setColumns(10);
		tfmaxPreventiveAirports = new JtfCS();
		tfmaxPreventiveAirports.setHorizontalAlignment(SwingConstants.CENTER);
		tfmaxPreventiveAirports.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tfmaxPreventiveAirports.setColumns(10);
		tfmaxPreventiveAirports.setBounds(255, 46, 81, 38);
		panel_1_1.add(tfmaxPreventiveAirports);
		
		tfminimumStopoverTime = new JtfCS();
		tfminimumStopoverTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfminimumStopoverTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfminimumStopoverTime.setColumns(10);
		tfminimumStopoverTime.setBounds(255, 82, 81, 38);
		panel_1_1.add(tfminimumStopoverTime);
		
		tfmaximumStopoverTime = new JtfCS();
		tfmaximumStopoverTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfmaximumStopoverTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfmaximumStopoverTime.setColumns(10);
		tfmaximumStopoverTime.setBounds(255, 121, 81, 38);
		panel_1_1.add(tfmaximumStopoverTime);
		
		tfearliestBookingTime = new JtfCS();
		tfearliestBookingTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfearliestBookingTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfearliestBookingTime.setColumns(10);
		tfearliestBookingTime.setBounds(255, 157, 81, 38);
		panel_1_1.add(tfearliestBookingTime);
		
		tflatestBookingCancellationTime = new JtfCS();
		tflatestBookingCancellationTime.setHorizontalAlignment(SwingConstants.CENTER);
		tflatestBookingCancellationTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		tflatestBookingCancellationTime.setColumns(10);
		tflatestBookingCancellationTime.setBounds(255, 195, 81, 38);
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
		lblNewLabel_1_3_1_2_1_1.setBounds(356, 197, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1_1);
		
		JLabel lblNewLabel_1_3_1_2_1_2 = new JLabel("Sân");
		lblNewLabel_1_3_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1_2.setBounds(356, 46, 46, 26);
		panel_1_1.add(lblNewLabel_1_3_1_2_1_2);
		//--------------------------
		
		//nut lưu setting cơ bản 
		//----------------------------------------
		tmp1 = new BtnCS();
		tmp1.setColorClick(new Color(0, 0, 160));
		tmp1.addActionListener(new ActionListener() {
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
		tmp1.setColorOver(new Color(0, 0, 160));
		tmp1.setColor(new Color(3, 4, 94));
		tmp1.setBorderColor(new Color(3, 4, 94));
		tmp1.setRadius(30);
		tmp1.setBounds(10, 243, 570, 37);
		panel_1_1.add(tmp1);
		tmp1.setText("CẬP NHẬP");
		
		
		tmp1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tmp1.setForeground(new Color(255, 255, 255));
		tmp1.setBackground(new Color(3, 4, 94));
		
		
		//HANG VE
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_2.setBounds(639, 338, 836, 290);
		add(panel_1_2);
		
		JLabel lbNameClass = new JLabel("Tên hạng vé :");
		lbNameClass.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbNameClass.setBounds(399, 62, 99, 26);
		panel_1_2.add(lbNameClass);
		
		JLabel lbNamePercent = new JLabel("Phần trăm đơn giá :");
		lbNamePercent.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbNamePercent.setBounds(399, 122, 199, 26);
		panel_1_2.add(lbNamePercent);
		
		inputNameClass = new JtfCS();
		inputNameClass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		inputNameClass.setColumns(10);
		inputNameClass.setBounds(558, 61, 221, 37);
		panel_1_2.add(inputNameClass);
		
		inputNamePercent = new JtfCS();
		inputNamePercent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		inputNamePercent.setColumns(10);
		inputNamePercent.setBounds(558, 121, 221, 37);
		panel_1_2.add(inputNamePercent);
		
		
		BtnCS btnThemTicketClass = new BtnCS();
		btnThemTicketClass.setText("THÊM ");
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
	
		
		
		btnThemTicketClass.setColorOver(new Color(0, 0, 160));
		btnThemTicketClass.setColor(new Color(3, 4, 94));
		btnThemTicketClass.setBorderColor(new Color(3, 4, 94));
		btnThemTicketClass.setRadius(30);
		btnThemTicketClass.setBounds(399, 180, 427, 37);
		panel_1_2.add(btnThemTicketClass);
		
		BtnCS btnUpdateTicketClass = new BtnCS();
		btnUpdateTicketClass.setRadius(30);
		btnUpdateTicketClass.setText("CẬP NHẬT ");
		btnUpdateTicketClass.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        //----------------------------------
		        try {
		            int selectedRowIndex = table_1.getSelectedRow();  // Make sure table_1 is used for selecting row
		            if (selectedRowIndex != -1) {
		                String ticketClassNameRow = table_1.getValueAt(selectedRowIndex, 0).toString(); // Assuming first column holds the ticket class name
		                ResultSet rs = TicketClassDAO.findTCbynName(ticketClassNameRow);
		                
		                // Check if ResultSet has any rows
		                if (rs.next()) {
		                    // If ResultSet has rows, retrieve data
		                    TicketClass tc = new TicketClass();
		                    tc.setTicketClassID(rs.getString("TicketClassID"));
		                    tc.setTicketClassName(inputNameClass.getText());
		                    tc.setPricePercentage(inputNamePercent.getText());
		                    
		                    int isUpdated = TicketClassDAO.updateTicketClass(tc);
		                    
		                    if (isUpdated > 0) {
		                        ResultSet updatedRs = TicketClassDAO.selectAll();
		                        loadRsToTableTicketLevel(updatedRs);
		                        inputNameClass.setText("");  // Clear the inputs
		                        inputNamePercent.setText("");
		                        btnThemTicketClass.setVisible(true);  // Assuming there's a button for inserting ticket class
		                        JOptionPane.showMessageDialog(null, "Cập nhật hạng vé thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Cập nhật hạng vé thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		                    }
		                } else {
		                    // ResultSet is empty, show a message
		                    JOptionPane.showMessageDialog(null, "Không tìm thấy hạng vé có tên này!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hạng vé để cập nhật!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
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
		btnUpdateTicketClass.setColorOver(new Color(0, 0, 160));
		btnUpdateTicketClass.setColor(new Color(3, 4, 94));
		btnUpdateTicketClass.setBorderColor(new Color(3, 4, 94));
		btnUpdateTicketClass.setRadius(30);
		panel_1_2.add(btnUpdateTicketClass);
		
		BtnCS buttonDeleteTicketClass = new BtnCS();
		buttonDeleteTicketClass.setRadius(30);
		buttonDeleteTicketClass.setText("XÓA ");
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
		
		buttonDeleteTicketClass.setColorClick(new Color(217, 217, 217));
		buttonDeleteTicketClass.setColorOver(new Color(217, 217, 217));
		buttonDeleteTicketClass.setColor(new Color(192, 192, 192));
		buttonDeleteTicketClass.setBorderColor(new Color(192, 192, 192));
		buttonDeleteTicketClass.setRadius(30);
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
		table_1 = new JTblCS();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setCellSelectionEnabled(false);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		Object [] column1 = {"Tên hạng vé","Phần trăm","Thao tác"};
		modelTicketLevel = new DefaultTableModel() {
	      	  @Override
	      	  public boolean isCellEditable(int row, int column) {
	              if (column == 2)
	              {
	            	  return true;
	              }
	              return false;
	          }
	    };
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
		
		BtnCS buttonCancelTicketClass = new BtnCS();
		buttonCancelTicketClass.setRadius(30);
		buttonCancelTicketClass.setText("HỦY ");
		buttonCancelTicketClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNameClass.setText("");
            	inputNamePercent.setText("");
            	btnThemTicketClass.setVisible(true);
			}
		});
		
		buttonCancelTicketClass.setColorClick(new Color(156, 156, 156));
		buttonCancelTicketClass.setColorOver(new Color(156, 156, 156));
		buttonCancelTicketClass.setColor(new Color(128, 128, 128));
		buttonCancelTicketClass.setRadius(30);
		buttonCancelTicketClass.setBorderColor(new Color(128, 128, 128));
		
		buttonCancelTicketClass.setForeground(Color.WHITE);
		buttonCancelTicketClass.setFont(new Font("Arial", Font.BOLD, 14));
		buttonCancelTicketClass.setBackground(new Color(128, 128, 128));
		buttonCancelTicketClass.setBounds(714, 180, 112, 37);
		panel_1_2.add(buttonCancelTicketClass);
		
		/*table_1.addMouseListener(new MouseAdapter() {
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
		});*/
		
		table_1.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
		table_1.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
	            @Override
	            public void onEdit(int row) {
	            	btnThemTicketClass.setVisible(false);
	                inputNameClass.setText(table_1.getValueAt(row, 0).toString());
	                inputNamePercent.setText(table_1.getValueAt(row, 1).toString());
	            }

				@Override
				public void onDelete(int row) {
					// TODO Auto-generated method stub
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


	        }));
		
	}
	
	
	
	//load data len teable tai bang setting 
	public void loadRsToTable(ResultSet rs) throws SQLException {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);

	    // Add rows to the table
	    while(rs.next()) {
	        Object[] row = new Object[] {
	            rs.getString("AirportName"),
	            rs.getString("CityName"),
	            rs.getString("CountryName"),
	            new TablePanelAction()
	        };
	        model.addRow(row);  
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
	    	Object[] row = new Object[] {
	    			rs.getString("TicketClassName"), // Use getString instead of getInt
			        rs.getString("PricePercentage"), // Assuming PricePercentage is also a string
			        new TablePanelAction()
			};
			modelTicketLevel.addRow(row); 
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
