package View.Admin.Flight;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import CustomUI.BtnCS;
import CustomUI.JtfCS;
import DAO.AirportDAO;
import DAO.FlightDAO;
import DAO.PlaneDAO;
import DAO.TicketClassDAO;
import View.Admin.Admin_header;
import libData.JDBCUtil;
import java.sql.Timestamp;
import java.util.Calendar;

public class DetailFlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPlaneID;
	private static JTextField txtFlightTime;
	private JTextField txtFlightCost;
	private JTable tableIntermediateFlight;
	private DefaultTableModel tableModel;
	private JTable table_1;
	private DefaultTableModel modelTicketLevel;
	private JComboBox<String> comboBoxFlight;
	private JComboBox<String> comboBoxFlightFrom;
	private JComboBox<String> comboBoxFlightTo;
	private JDateChooser dateFlightDate;
	private JSpinner spinnerHour;
	private JSpinner spinnerMinute;
	private JButton btnSave;
	private BtnCS btnCancel;
	private BtnCS btnAddIntermediateFlight;
	private BtnCS btnRemoveIntermediateFlight;

	public JTextField getTxtFlightTime() {
		return txtFlightTime;
	}

	public void setTxtFlightTime(JTextField txtFlightTime) {
		this.txtFlightTime = txtFlightTime;
	}

	public JTextField getTxtFlightCost() {
		return txtFlightCost;
	}

	public void setTxtFlightCost(JTextField txtFlightCost) {
		this.txtFlightCost = txtFlightCost;
	}

	public JComboBox<String> getComboBoxFlightFrom() {
		return comboBoxFlightFrom;
	}

	public void setComboBoxFlightFrom(JComboBox<String> comboBoxFlightFrom) {
		this.comboBoxFlightFrom = comboBoxFlightFrom;
	}

	public JComboBox<String> getComboBoxFlightTo() {
		return comboBoxFlightTo;
	}

	public void setComboBoxFlightTo(JComboBox<String> comboBoxFlightTo) {
		this.comboBoxFlightTo = comboBoxFlightTo;
	}

	// Constructor with parameters
	public DetailFlightUC(String flightID) throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 610);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1500, 610);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(37, 0, 378, 610);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông Tin Chuyến Bay");
		lblNewLabel.setForeground(new Color(3, 4, 94));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 16, 378, 36);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));

		// -----------------------------------------------------------------
		try {
			ResultSet rs = AirportDAO.selectAll();

			DefaultComboBoxModel<String> airportModelFrom = new DefaultComboBoxModel<>();
			DefaultComboBoxModel<String> airportModelTo = new DefaultComboBoxModel<>();

			while (rs.next()) {
				String airportName = rs.getString("AirportName");
				airportModelFrom.addElement(airportName);
				airportModelTo.addElement(airportName);
			}

			comboBoxFlightFrom = new JComboBox<>(airportModelFrom);
			comboBoxFlightTo = new JComboBox<>(airportModelTo);

			JScrollPane scrollPaneFlightFrom = new JScrollPane(comboBoxFlightFrom);
			JScrollPane scrollPaneFlightTo = new JScrollPane(comboBoxFlightTo);

			// Đặt vị trí và kích thước cho JScrollPane
			scrollPaneFlightFrom.setBounds(121, 100, 252, 40);
			scrollPaneFlightTo.setBounds(121, 155, 252, 40);

			// Thêm JScrollPane vào panel
			panel_1.add(scrollPaneFlightFrom);
			panel_1.add(scrollPaneFlightTo);

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}

		// ---------------------------------------------------------------------------------

		try {
			ResultSet rs = PlaneDAO.selectAll();
			DefaultComboBoxModel<String> flightModel = new DefaultComboBoxModel<>();
			while (rs.next()) {
				String flightID1 = rs.getString("PlaneID");
				flightModel.addElement(flightID1);
			}
			// Khởi tạo comboBoxFlight và đặt vào model đã tạo
			comboBoxFlight = new JComboBox<>(flightModel);
			JScrollPane scrollPaneFlight = new JScrollPane(comboBoxFlight);
			// Đặt vị trí và kích thước cho JScrollPane
			scrollPaneFlight.setBounds(121, 212, 252, 36);
			// Thêm JScrollPane vào panel
			panel_1.add(scrollPaneFlight);

			// Thêm bộ lắng nghe sự kiện cho comboBoxFlight
			comboBoxFlight.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Lấy giá trị mới của combobox khi thay đổi
					String selectedFlight = (String) comboBoxFlight.getSelectedItem();
					ResultSet rs;
					try {
						rs = PlaneDAO.numberTicketClass(selectedFlight);
						loadRsToTableTicketLevel(rs);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Thực hiện xử lý dữ liệu ở đây...
				}
			});

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		// ----------------------------------------------------------------------------------
		dateFlightDate = new JDateChooser();
		dateFlightDate.setDateFormatString("yyyy-MM-dd");
		dateFlightDate.setBounds(121, 266, 252, 36);
		panel_1.add(dateFlightDate);

		spinnerHour = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		spinnerHour.setBounds(121, 327, 63, 36);
		panel_1.add(spinnerHour);

		spinnerMinute = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinute.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		spinnerMinute.setBounds(238, 327, 63, 36);
		panel_1.add(spinnerMinute);
		
		// -----------------------------------------------------------------------------------
		txtFlightTime = new JtfCS();
		txtFlightTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightTime.setBounds(121, 392, 200, 40);
		panel_1.add(txtFlightTime);
		txtFlightTime.setColumns(10);

		txtFlightCost = new JtfCS();
		txtFlightCost.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightCost.setBounds(121, 455, 200, 40);
		panel_1.add(txtFlightCost);
		txtFlightCost.setColumns(10);

		btnSave = new BtnCS();
		btnSave.setText("Lưu");;
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(3, 4, 94));
		btnSave.setFont(new Font("Arial", Font.BOLD, 20));
		btnSave.setBounds(6, 516, 162, 45);
		panel_1.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Xóa chuyến bay hiện tại
		            Connection conn = JDBCUtil.getConnection();
		            conn.setAutoCommit(false); // Bắt đầu transaction

		            FlightDAO.deleteFlight(conn, flightID);

		            String flightFromCode = (String) comboBoxFlightFrom.getSelectedItem();
		            String flightToCode = (String) comboBoxFlightTo.getSelectedItem();
		            String planeID = (String) comboBoxFlight.getSelectedItem();
		            java.util.Date departureDate = dateFlightDate.getDate();
		            int spinnerHourValue = (int) spinnerHour.getValue();
		            int spinnerMinuteValue = (int) spinnerMinute.getValue();
		            String flightTime = txtFlightTime.getText();
		            String flightCost = txtFlightCost.getText();

		            // Kiểm tra các trường không được để trống
		            if (flightFromCode == null || flightToCode == null || planeID == null || departureDate == null
		                    || flightTime.isEmpty() || flightCost.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Thông báo",
		                        JOptionPane.ERROR_MESSAGE);
		                return;
		            }


		            // Truy vấn lấy AirportID từ mã sân bay
		            String flightFrom = AirportDAO.getAirportID(conn, flightFromCode);
		            String flightTo = AirportDAO.getAirportID(conn, flightToCode);
		            if (flightFrom == null || flightTo == null) {
		                JOptionPane.showMessageDialog(null, "Không thể xác định ID của sân bay.", "Thông báo",
		                        JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Kiểm tra giá trị các hàng trong bảng 'tableIntermediateFlight'
		            for (int i = 0; i < tableIntermediateFlight.getRowCount(); i++) {
		                if (tableIntermediateFlight.getValueAt(i, 1) == null
		                        || tableIntermediateFlight.getValueAt(i, 2) == null
		                        || tableIntermediateFlight.getValueAt(i, 1).toString().isEmpty()
		                        || tableIntermediateFlight.getValueAt(i, 2).toString().isEmpty()) {
		                    JOptionPane.showMessageDialog(null, "Thông tin sân bay trung gian không được để trống.",
		                            "Thông báo", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }
		            }

		            // Kiểm tra ràng buộc từ bảng 'Parameters'
		            ResultSet rsParam = JDBCUtil.executeQuery("SELECT * FROM Parameters");
		            if (rsParam.next()) {
		                int minimumFlightTime = rsParam.getInt("MinimumFlightTime");
		                int maxPreventiveAirports = rsParam.getInt("MaxPreventiveAirports");
		                int minimumStopoverTime = rsParam.getInt("MinimumStopoverTime");
		                int maximumStopoverTime = rsParam.getInt("MaximumStopoverTime");

		                int flightDuration = Integer.parseInt(flightTime);
		                if (flightDuration < minimumFlightTime) {
		                    JOptionPane.showMessageDialog(null,
		                            "Thời gian bay phải lớn hơn " + minimumFlightTime + " phút.", "Thông báo",
		                            JOptionPane.ERROR_MESSAGE);
		                    return;
		                }

		                if (tableIntermediateFlight.getRowCount() > maxPreventiveAirports) {
		                    JOptionPane.showMessageDialog(null,
		                            "Số sân bay trung gian không được vượt quá " + maxPreventiveAirports, "Thông báo",
		                            JOptionPane.ERROR_MESSAGE);
		                    return;
		                }

		                for (int i = 0; i < tableIntermediateFlight.getRowCount(); i++) {
		                    int stopoverTime = Integer.parseInt(tableIntermediateFlight.getValueAt(i, 2).toString());
		                    if (stopoverTime < minimumStopoverTime || stopoverTime > maximumStopoverTime) {
		                        JOptionPane.showMessageDialog(null,
		                                "Thời gian dừng tại sân bay trung gian phải trong khoảng " + minimumStopoverTime
		                                        + " - " + maximumStopoverTime + " phút.",
		                                "Thông báo", JOptionPane.ERROR_MESSAGE);
		                        return;
		                    }
		                }
		            }
		            rsParam.close();

		            // Chèn thông tin chuyến bay vào bảng FLIGHT và lấy FlightID mới
		            String newFlightID = FlightDAO.insertFlight(conn, flightFrom, flightTo, planeID,
		                    departureDate, spinnerHourValue, spinnerMinuteValue,
		                    Integer.parseInt(flightTime), Float.parseFloat(flightCost));

		            // Chèn thông tin sân bay trung gian vào bảng FLIGHT_DETAIL
		            for (int i = 0; i < tableIntermediateFlight.getRowCount(); i++) {
		                String preventiveAirport = AirportDAO.getAirportID(conn, tableIntermediateFlight.getValueAt(i, 1).toString());
		                int stopoverDuration = Integer.parseInt(tableIntermediateFlight.getValueAt(i, 2).toString());
		                String note = tableIntermediateFlight.getValueAt(i, 3).toString();
		                FlightDAO.insertIntermediateFlight(conn, newFlightID, preventiveAirport, stopoverDuration,
		                        note);
		            }

//		            // Chèn thông tin vào bảng FLIGHT_TICKET_CLASS_DETAIL
//		            for (int i = 0; i < table_1.getRowCount(); i++) {
//		                String ticketClassID = table_1.getValueAt(i, 0).toString();
//		                String fare = table_1.getValueAt(i, 1).toString();
//		                int seatCapacity = Integer.parseInt(table_1.getValueAt(i, 2).toString());
//		                int ticketSold = Integer.parseInt(table_1.getValueAt(i, 3).toString());
//		                int seatRemaining = seatCapacity - ticketSold;
		//
//		                String insertTicketClassDetailSQL = String.format(
//		                        "INSERT INTO FLIGHT_TICKET_CLASS_DETAIL (FlightID, TicketClassID, Fare, SeatCapacity, TicketSold, SeatRemaining) VALUES (?, ?, ?, ?, ?, ?)");
//		                try (PreparedStatement pstmt = conn.prepareStatement(insertTicketClassDetailSQL)) {
//		                    pstmt.setInt(1, newFlightID);
//		                    pstmt.setString(2, ticketClassID);
//		                    pstmt.setFloat(3, Float.parseFloat(fare));
//		                    pstmt.setInt(4, seatCapacity);
//		                    pstmt.setInt(5, ticketSold);
//		                    pstmt.setInt(6, seatRemaining);
//		                    pstmt.executeUpdate();
//		                }
//		            }

		            conn.commit(); // Xác nhận transaction

		            JOptionPane.showMessageDialog(null, "Đã cập nhật chuyến bay thành công", "Thông báo",
		                    JOptionPane.INFORMATION_MESSAGE);
					Admin_header.clearAndShow(new FlightUC());
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi. Vui lòng thử lại", "Thông báo",
		                    JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btnCancel = new BtnCS();
		btnCancel.setColorOver(new Color(192, 192, 192));
		btnCancel.setColorClick(new Color(192, 192, 192));
		btnCancel.setColor(new Color(128, 128, 128));
		btnCancel.setBorderColor(new Color(128, 128, 128));
		btnCancel.setText("Huỷ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Admin_header.clearAndShow(new FlightUC());
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(128, 128, 128));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setBounds(206, 516, 162, 45);

		panel_1.add(btnCancel);

		JLabel lblNewLabel_1 = new JLabel("Sân bay đi:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 111, 120, 16);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Sân bay đến:");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(6, 166, 120, 16);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Mã máy bay:");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(6, 221, 120, 16);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày khởi hành:");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(6, 276, 120, 16);
		panel_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Giờ khởi hành:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(6, 331, 120, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Thời gian bay:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(6, 396, 120, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Giá tiền: ");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(6, 461, 120, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Giờ ");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2.setBounds(194, 332, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("Phút");
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(311, 332, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_1_1_2_1_1 = new JLabel("Phút");
		lblNewLabel_1_1_1_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1_1.setBounds(331, 396, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1_1);

		JLabel lblNewLabel_1_1_1_1_1_2_1_1_1 = new JLabel("VND");
		lblNewLabel_1_1_1_1_1_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1_1_1.setBounds(331, 460, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1_1_1);

		// --------------------------------------------------------------------
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(446, 16, 204, 76);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(0, 0, 204, 76);
		panel_2.add(scrollPane_1);

		// table ticket class
		table_1 = new JTable();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng

		Object[] column1 = { "Tên hạng vé", "Số lượng" };
		modelTicketLevel = new DefaultTableModel();
		modelTicketLevel.setColumnIdentifiers(column1);
		table_1.setModel(modelTicketLevel);
		// upload data
		try {
			ResultSet rs = PlaneDAO.numberTicketClass("PE0001");
			loadRsToTableTicketLevel(rs);
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		scrollPane_1.setViewportView(table_1);
		// ---------------------------------------------------------------------
		btnAddIntermediateFlight = new BtnCS();
		btnAddIntermediateFlight.setForeground(new Color(255, 255, 255));
		btnAddIntermediateFlight.setRadius(30);
		btnAddIntermediateFlight.setText("+");
		btnAddIntermediateFlight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAddIntermediateFlight.setBounds(691, 16, 106, 45);
		panel.add(btnAddIntermediateFlight);
		btnAddIntermediateFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModel.getRowCount();
				Object[] rowData = new Object[] { rowCount + 1, "", "", "" };
				tableModel.addRow(rowData);
			}
		});

		btnRemoveIntermediateFlight = new BtnCS();
		btnRemoveIntermediateFlight.setForeground(new Color(255, 255, 255));
		btnRemoveIntermediateFlight.setRadius(30);
		btnRemoveIntermediateFlight.setText("-");
		btnRemoveIntermediateFlight.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnRemoveIntermediateFlight.setBounds(827, 16, 106, 45);
		panel.add(btnRemoveIntermediateFlight);
		btnRemoveIntermediateFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableIntermediateFlight.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Hãy lựa chọn sân bay cần xoá.", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sân bay trung gian không?",
						"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					tableModel.removeRow(selectedRow);
					updateRowNumbers();
				}
			}
		});
		JLabel lblSnBayTrung = new JLabel("Sân Bay Trung Gian");
		lblSnBayTrung.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnBayTrung.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSnBayTrung.setBounds(978, 38, 220, 25);
		panel.add(lblSnBayTrung);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(690, 73, 767, 486);
		panel.add(scrollPane);

		tableIntermediateFlight = new JTable();
		tableIntermediateFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		tableIntermediateFlight.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableIntermediateFlight.setBackground(SystemColor.window);
		tableIntermediateFlight.setRowHeight(30);
		setJTableColumnsWidth(tableIntermediateFlight, 767, 10, 40, 25, 25);
		scrollPane.setViewportView(tableIntermediateFlight);

		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Tên Sân Bay", "Thời Gian Dừng", "Ghi chú" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, true, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableIntermediateFlight.setModel(tableModel);

		JComboBox<String> airportComboBox = new JComboBox<>();
		try {
			ResultSet rsAirports = AirportDAO.selectAll();
			while (rsAirports.next()) {
				airportComboBox.addItem(rsAirports.getString("AirportName"));
			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}

		// Thiết lập airportComboBox làm CellEditor cho cột "Tên Sân Bay"
		TableColumn airportColumn = tableIntermediateFlight.getColumnModel().getColumn(1);
		airportColumn.setCellEditor(new DefaultCellEditor(airportComboBox));
        loadFlightDetails(flightID);
        loadIntermediateFlightDetail(flightID);

	}



	public void loadFlightDetails(String flightID) throws ClassNotFoundException, SQLException {
	    Connection conn = JDBCUtil.getConnection();
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM FLIGHT WHERE FlightID = N'").append(flightID).append("' ");
	    try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                String departureAirport = AirportDAO.getAirportName(conn, rs.getString("DepartureAirportCode"));
	                String arrivalAirport = AirportDAO.getAirportName(conn, rs.getString("ArrivalAirportCode"));
	                String planeID = rs.getString("PlaneID");
	                Timestamp departureDateTime = rs.getTimestamp("DepartureDateTime");

	                Calendar calendar = Calendar.getInstance();
	                calendar.setTime(departureDateTime);
	                Date flightDate = calendar.getTime();
	                int hour = calendar.get(Calendar.HOUR_OF_DAY);
	                int minute = calendar.get(Calendar.MINUTE);

	                int flightDuration = rs.getInt("FlightDuration");
	                float ticketPrice = rs.getFloat("TicketPrice");

	                // Đặt dữ liệu vào các thành phần giao diện
	                comboBoxFlightFrom.setSelectedItem(departureAirport);
	                comboBoxFlightTo.setSelectedItem(arrivalAirport);
	                comboBoxFlight.setSelectedItem(planeID);
	                dateFlightDate.setDate(flightDate);
	                spinnerHour.setValue(hour);
	                spinnerMinute.setValue(minute);
	                txtFlightTime.setText(String.valueOf(flightDuration));
	                txtFlightCost.setText(String.valueOf(ticketPrice));
	            }
	        }
	    } finally {
	        conn.close();
	    }
	}

    public void loadIntermediateFlightDetail(String flightID) throws ClassNotFoundException, SQLException {
        Connection conn = JDBCUtil.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM FLIGHT_DETAIL WHERE FlightID = N'").append(flightID).append("' ");
        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            try (ResultSet rs = pstmt.executeQuery()) {
                tableModel.setRowCount(0); // Clear existing rows
                int stt = 1;
                while (rs.next()) {
                    String airportName = AirportDAO.getAirportName(conn, rs.getString("PreventiveAirportID"));
                    int stopTime = rs.getInt("StopoverDuration");
                    String note = rs.getString("Note");
                    tableModel.addRow(new Object[] { stt++, airportName, stopTime, note });
                }
            }
        } finally {
            conn.close();
        }
    }

	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
		double total = 0;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			total += percentages[i];
		}

		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
		}
	}

	private void updateRowNumbers() {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.setValueAt(i + 1, i, 0);
		}
	}

	// Phương pháp để tải kết quả lên bảng hạng vé
	public void loadRsToTableTicketLevel(ResultSet rs) throws SQLException {
		DefaultTableModel modelTicketLevel = (DefaultTableModel) table_1.getModel();
		modelTicketLevel.setRowCount(0);
		while (rs.next()) {
			modelTicketLevel.addRow(new Object[] { rs.getString("TicketClassName"), // Sử dụng getString thay vì getInt
					rs.getString("TicketCount"), // Giả sử PricePercentage cũng là một chuỗi
			});
		}
	}

}
