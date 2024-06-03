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
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import CustomUI.BtnCS;
import DAO.FlightDAO;
import View.Admin.Admin_header;
import View.Admin.FormAdmin;
import View.Admin.TicketPlane.CreateFlightTicket;
import View.Admin.TicketPlane.FlightTicket;
import libData.JDBCUtil;

public class FlightListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;
	private Container panel;
	private String flightID;
	private BtnCS btnSearch;

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
		btnSearch.setText("Tìm kiến");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSearch.setBounds(1354, 11, 106, 35);
		panel.add(btnSearch);

		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Chuyến Bay", "Sân Bay Cất Cánh",
				"Nơi Cất Cánh", "Sân Bay Hạ Cánh", "Nơi Hạ Cánh", "Thời Gian", "Ghế Trống", "Ghế Đã Đặt" });

		table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(SystemColor.control);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		setJTableColumnsWidth(table, 1421, 7, 13, 6, 13, 6, 10, 5, 6, 15);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 58, 1307, 488);
		panel.add(scrollPane);

		JComboBox<String> comboBoxTo = new JComboBox<>();
		comboBoxTo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxTo.setBounds(679, 11, 173, 35);
		panel.add(comboBoxTo);

		JComboBox<String> comboBoxFrom = new JComboBox<>();
		comboBoxFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFrom.setBounds(413, 11, 173, 35);
		panel.add(comboBoxFrom);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(106, 11, 198, 35);
		panel.add(dateChooser);

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
		JButton btnBook = new JButton("Đặt vé");
		btnBook.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Hãy lựa chọn chuyến bay cần đặt vé.", "Thông báo", JOptionPane.ERROR_MESSAGE);
		            return;
		        } else {
		            String flightID = table.getValueAt(selectedRow, 0).toString();
		            clearAndShow(new FlightTicket(flightID));
		            try {
						
						Admin_header.highlightButton1();
						FlightTicket.button_2.setBackground(new Color(3,4,94));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            // Proceed with the rest of your code to switch to the CreateFlightTicket view
		        }
		    }
		});
		btnBook.setBackground(new Color(51, 51, 255));
		btnBook.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnBook.setBounds(1354, 186, 106, 35);
		panel.add(btnBook);

		//-----------------------------------------------
		JLabel lblEdit = new JLabel("");
		lblEdit.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		Image img = new ImageIcon(this.getClass().getResource("/Resource/EditIcon.png")).getImage();
		lblEdit.setIcon(new ImageIcon(img));
		lblEdit.setBounds(1386, 233, 42, 36);
		panel.add(lblEdit);
		// Event to handle edit button click
		lblEdit.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
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
		});
		
		//----------------------------------------------------------------
		JLabel lblDelete = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Resource/DeleteIcon.png")).getImage();
		lblDelete.setIcon(new ImageIcon(img1));
		lblDelete.setBounds(1386, 281, 42, 35);
		panel.add(lblDelete);
		lblDelete.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
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
		});

		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		separator.setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		separator.setBounds(0, 0, 1500, 5);
		panel.add(separator);

		btnSearch.addActionListener(e -> {
			try {
				String fromCity = (String) comboBoxFrom.getSelectedItem();
				String toCity = (String) comboBoxTo.getSelectedItem();
				Date selectedDate = dateChooser.getDate();
				loadFlightData(fromCity, toCity, selectedDate);
			} catch (ClassNotFoundException | SQLException ex) {
				ex.printStackTrace();
			}
		});
	}
	//-----------------------------------------------------------------------------------------------------
	private void loadFlightData(String fromCity, String toCity, Date selectedDate)
			throws ClassNotFoundException, SQLException {
		// Clear existing data
		tableModel.setRowCount(0);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Get connection from JDBCUtil
			conn = JDBCUtil.getConnection();
			StringBuilder queryBuilder = new StringBuilder(
					"SELECT FLIGHT.FlightID, DEP_AIRPORT.AirportName AS DepartureAirport, DEP_AIRPORT.CityName AS DepartureCity, "
							+ "ARR_AIRPORT.AirportName AS ArrivalAirport, ARR_AIRPORT.CityName AS ArrivalCity, FLIGHT.DepartureDateTime, "
							+ "PLANE.SeatCount - COUNT(FLIGHT_TICKET.FlightTicketID) AS SeatsRemaining, COUNT(FLIGHT_TICKET.FlightTicketID) AS SeatsBooked "
							+ "FROM FLIGHT "
							+ "JOIN AIRPORT AS DEP_AIRPORT ON FLIGHT.DepartureAirportCode = DEP_AIRPORT.AirportID "
							+ "JOIN AIRPORT AS ARR_AIRPORT ON FLIGHT.ArrivalAirportCode = ARR_AIRPORT.AirportID "
							+ "JOIN PLANE ON FLIGHT.PlaneID = PLANE.PlaneID "
							+ "LEFT JOIN FLIGHT_TICKET ON FLIGHT.FlightID = FLIGHT_TICKET.FlightID " + "WHERE 1=1 ");

			if (fromCity != null && !fromCity.isEmpty()) {
				queryBuilder.append("AND DEP_AIRPORT.CityName = N'").append(fromCity).append("' ");
			}
			if (toCity != null && !toCity.isEmpty()) {
				queryBuilder.append("AND ARR_AIRPORT.CityName = N'").append(toCity).append("' ");
			}
			if (selectedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = dateFormat.format(selectedDate);
				queryBuilder.append("AND CONVERT(date, FLIGHT.DepartureDateTime) = '").append(dateStr).append("' ");
			}
			queryBuilder.append(
					"GROUP BY FLIGHT.FlightID, DEP_AIRPORT.AirportName, DEP_AIRPORT.CityName, ARR_AIRPORT.AirportName, ARR_AIRPORT.CityName, FLIGHT.DepartureDateTime, PLANE.SeatCount");

			String query = queryBuilder.toString();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String flightID = rs.getString("FlightID");
				String departureAirport = rs.getString("DepartureAirport");
				String departureCity = rs.getString("DepartureCity");
				String arrivalAirport = rs.getString("ArrivalAirport");
				String arrivalCity = rs.getString("ArrivalCity");
				String departureDateTime = rs.getString("DepartureDateTime");
				int seatsRemaining = rs.getInt("SeatsRemaining");
				int seatsBooked = rs.getInt("SeatsBooked");

				tableModel.addRow(new Object[] { flightID, departureAirport, departureCity, arrivalAirport, arrivalCity,
						departureDateTime, seatsRemaining, seatsBooked });
			}
		} catch (SQLException e) {
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
        Admin_header tmp = new Admin_header();
        FormAdmin.contentPane.add(tmp); // Thêm lại Admin_header vào contentPane
        FormAdmin.contentPane.add(newPanel); // Thêm form mới vào contentPane
        newPanel.setSize(1500, 653);
        newPanel.setLocation(0, 78);
        FormAdmin.contentPane.revalidate(); // Cập nhật giao diện
        FormAdmin.contentPane.repaint(); // Vẽ lại giao diện
    }
	

}