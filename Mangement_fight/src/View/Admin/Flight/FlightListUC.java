package View.Admin.Flight;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.raven.datechooser.DateChooser;
import com.toedter.calendar.JDateChooser;

import CustomUI.BtnCS;
import CustomUI.JtfCS;
import CustomUI.Table.TableActionCellEditor;
import CustomUI.Table.TableActionCellRender;
import CustomUI.Table.JTblCS;
import CustomUI.Table.TablePanelAction;
import CustomUI.Table.TableActionEvent;
import DAO.FlightDAO;
import View.Admin.Admin_header;
import View.Admin.FormAdmin;
import View.Admin.TicketPlane.CreateFlightTicket;
import View.Admin.TicketPlane.FlightTicket;
import combo_suggestion.ComboBoxSuggestion;
import libData.JDBCUtil;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Button;
import com.raven.datechooser.EventDateChooser;

public class FlightListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTblCS table;
	private DefaultTableModel tableModel;
	private BtnCS btnSearch;
	private JTextField DateTime;

	public FlightListUC() throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 610);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1500, 568);
		add(panel);
		panel.setLayout(null);

		btnSearch = new BtnCS();
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setRadius(20);
		btnSearch.setText("Tìm kiếm");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSearch.setBounds(1350, 12, 110, 35);
		panel.add(btnSearch);

		//Danh sách chuyến bay
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Chuyến Bay", "Sân Bay Cất Cánh","Nơi Cất Cánh", "Sân Bay Hạ Cánh", "Nơi Hạ Cánh", "Thời Gian", "Ghế Trống", "Giá tiến", "Thao tác" }) {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        // Only the third column is editable
				    	return column == 8;
				    }
		};

		table = new JTblCS("FlightListUC");
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(SystemColor.control);
		table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(tableModel);
		table.setRowHeight(50);
		setJTableColumnsWidth(table, 1421, 7, 13, 6, 13, 6, 10, 5, 6, 15);

		JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(39, 58, 1421, 473);
        panel.add(scrollPane);

        table.fixTable(scrollPane);
        
        // Center align the headers
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTableHeader header = table.getTableHeader();
        for (int i = 0; i < header.getColumnModel().getColumnCount(); i++) {
            header.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        // Center align the cell content except the action column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 8) { // Skip the action column
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }

        // Set the custom cell renderer for the action column
        table.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy lựa chọn chuyến bay cần chỉnh sửa.", "Thông báo",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    try {
                        FlightUC.selectButton(FlightUC.btnDetailFlight);

                        String flightID = table.getValueAt(selectedRow, 0).toString();
                        DetailFlightUC detailFlightUC = new DetailFlightUC(flightID); // Khởi tạo DetailFlightUC với flightID
                        FlightUC.switchDetailFlightUC(detailFlightUC);
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tải chi tiết chuyến bay.", "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void onDelete(int row) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy lựa chọn chuyến bay cần xoá.", "Thông báo",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa chuyến bay không?",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        // Lấy ID của chuyến bay từ hàng được chọn trong bảng
                        String flightID = table.getValueAt(selectedRow, 0).toString();

                        // Tạo kết nối và gọi phương thức deleteFlight
                        Connection conn = JDBCUtil.getConnection();
                        FlightDAO.deleteFlight(conn, flightID);

                        // Đóng kết nối
                        conn.close();

                        // Nạp lại dữ liệu bảng sau khi xóa
                        try {
                            loadFlightData(null, null, null);
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                            // In ra thông tin về lỗi để debug
                        }

                        // Hiển thị thông báo thành công
                        JOptionPane.showMessageDialog(null, "Đã xoá chuyến bay thành công", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi xóa chuyến bay. Vui lòng thử lại", "Thông báo",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void onBookTicket(int row) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy lựa chọn chuyến bay cần đặt vé.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    String flightID = table.getValueAt(selectedRow, 0).toString();
                    clearAndShow(new FlightTicket(flightID));
                    try {
                        Admin_header.highlightButton1();
                        FlightTicket.button_2.setBackground(new Color(3, 4, 94));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelTicket(int row) {
                // TODO Auto-generated method stub
            }
        }));
   

		ComboBoxSuggestion<String> comboBoxTo = new ComboBoxSuggestion<>();
		comboBoxTo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxTo.setBounds(679, 11, 173, 35);
		panel.add(comboBoxTo);

		ComboBoxSuggestion<String> comboBoxFrom = new ComboBoxSuggestion<>();
		comboBoxFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFrom.setBounds(413, 11, 173, 35);
		panel.add(comboBoxFrom);
		
		JLabel lblNewLabel = new JLabel("Ngày bay:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 20, 72, 16);
		panel.add(lblNewLabel);

		JLabel lblNiCtCnh = new JLabel("Nơi cất cánh:");
		lblNiCtCnh.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNiCtCnh.setBounds(329, 20, 96, 16);
		panel.add(lblNiCtCnh);

		JLabel lblNiHCnh = new JLabel("Nơi hạ cánh:");
		lblNiHCnh.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNiHCnh.setBounds(598, 20, 80, 16);
		panel.add(lblNiHCnh);

		loadFlightData(null, null, null);
		populateComboBoxWithCities(comboBoxFrom);
		populateComboBoxWithCities(comboBoxTo);

		//------------------------------------------------
		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		separator.setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		separator.setBounds(0, 0, 1500, 5);
		panel.add(separator);
		
		//----------------------------------------------------------
		// Đảm bảo DateChooser sử dụng cùng định dạng "dd-MM-yyyy"
		DateChooser dateChooser1 = new com.raven.datechooser.DateChooser();
		dateChooser1.setDateFormat("dd-MM-yyyy");  // Use a String format here

		DateTime = new JtfCS();
		DateTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		DateTime.setBounds(103, 11, 166, 37);
		panel.add(DateTime);
		DateTime.setColumns(10);
		dateChooser1.setTextRefernce(DateTime);
		
		
		
		//----------------------------------------------------------
		btnSearch.addActionListener(e -> {
		    try {
		        String fromCity = (String) comboBoxFrom.getSelectedItem();
		        String toCity = (String) comboBoxTo.getSelectedItem();
		        String selectedDate = DateTime.getText();  // Ngày tháng từ DateChooser
		        loadFlightData(fromCity, toCity, selectedDate);
		    } catch (ClassNotFoundException | SQLException ex) {
		        ex.printStackTrace();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		});
	}
	//-----------------------------------------------------------------------------------------------------
	private void loadFlightData(String fromCity, String toCity, String selectedDate) throws ClassNotFoundException, SQLException {
	    // Clear existing data
	    tableModel.setRowCount(0);

	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;

	    try {
	        // Get connection from JDBCUtil
	        conn = JDBCUtil.getConnection();
	        StringBuilder queryBuilder = new StringBuilder(
	            "SELECT FLIGHT.FlightID, DEP_AIRPORT.AirportName AS DepartureAirport, DEP_AIRPORT.CityName AS DepartureCity, " +
	            "ARR_AIRPORT.AirportName AS ArrivalAirport, ARR_AIRPORT.CityName AS ArrivalCity, FLIGHT.DepartureDateTime, " +
	            "PLANE.SeatCount - COUNT(FLIGHT_TICKET.FlightTicketID) AS SeatsRemaining, FLIGHT.TicketPrice  " +
	            "FROM FLIGHT " +
	            "JOIN AIRPORT AS DEP_AIRPORT ON FLIGHT.DepartureAirportCode = DEP_AIRPORT.AirportID " +
	            "JOIN AIRPORT AS ARR_AIRPORT ON FLIGHT.ArrivalAirportCode = ARR_AIRPORT.AirportID " +
	            "JOIN PLANE ON FLIGHT.PlaneID = PLANE.PlaneID " +
	            "LEFT JOIN FLIGHT_TICKET ON FLIGHT.FlightID = FLIGHT_TICKET.FlightID WHERE 1=1 "
	        );

	        if (fromCity != null && !fromCity.isEmpty()) {
	            queryBuilder.append("AND DEP_AIRPORT.CityName = N'").append(fromCity).append("' ");
	        }
	        if (toCity != null && !toCity.isEmpty()) {
	            queryBuilder.append("AND ARR_AIRPORT.CityName = N'").append(toCity).append("' ");
	        }
	        if (selectedDate != null && !selectedDate.isEmpty()) {
	            // Convert date format from dd-MM-yyyy to yyyy-MM-dd for SQL query
	            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	            SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            String dateStr = sqlDateFormat.format(inputDateFormat.parse(selectedDate));
	            queryBuilder.append("AND CONVERT(date, FLIGHT.DepartureDateTime) = '").append(dateStr).append("' ");
	        }

	        queryBuilder.append(
	            "GROUP BY FLIGHT.FlightID, DEP_AIRPORT.AirportName, DEP_AIRPORT.CityName, ARR_AIRPORT.AirportName, " +
	            "ARR_AIRPORT.CityName, FLIGHT.DepartureDateTime, PLANE.SeatCount,FLIGHT.TicketPrice"
	        );

	        String query = queryBuilder.toString();
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(query);

	        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	        while (rs.next()) {
	            String flightID = rs.getString("FlightID");
	            String departureAirport = rs.getString("DepartureAirport");
	            String departureCity = rs.getString("DepartureCity");
	            String arrivalAirport = rs.getString("ArrivalAirport");
	            String arrivalCity = rs.getString("ArrivalCity");
	            String departureDateTime = outputDateFormat.format(rs.getTimestamp("DepartureDateTime"));
	            int seatsRemaining = rs.getInt("SeatsRemaining");
	            double averagePrice = rs.getDouble("TicketPrice");

	            // Convert average price to VND format with dots after every three zeros
	            String averagePriceVND = String.format("%,.0f", averagePrice) + " VND";

	            tableModel.addRow(new Object[] {
	                flightID, departureAirport, departureCity, arrivalAirport, arrivalCity, departureDateTime, seatsRemaining, averagePriceVND
	            });
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(rs, stmt, conn);
	    }
	}



	//---------------------------------------------------------------------------------------------------
	private void populateComboBoxWithCities(JComboBox<String> comboBox) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtil.getConnection();
			String query = "SELECT DISTINCT CityName FROM AIRPORT";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			comboBox.addItem(""); // Add an empty option to allow deselection

			while (rs.next()) {
				comboBox.addItem(rs.getString("CityName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	//-------------------------------------------------------------------------------------------------
	private void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
		double total = 0;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			total += percentages[i];
		}

		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
		}
	}
	//----------------------------------------------------------------------------------------------
	public static void clearAndShow(JPanel newPanel) {
        FormAdmin.contentPane.removeAll(); // Xóa tất cả các thành phần trên contentPane
        Admin_header header = Admin_header.getInstance();
        FormAdmin.contentPane.add(header);
        FormAdmin.contentPane.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 653);
        newPanel.setLocation(0, 78);
        FormAdmin.contentPane.revalidate(); // Cập nhật giao diện
        FormAdmin.contentPane.repaint(); // Vẽ lại giao diện
    }
	
}