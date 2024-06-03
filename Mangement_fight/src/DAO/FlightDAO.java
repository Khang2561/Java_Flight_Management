package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Airport;
import Model.Flight;
import libData.JDBCUtil;

public class FlightDAO implements DAOInterface<Flight> {

	@Override
	public int insert(Flight t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Flight t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Flight t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Flight selectById(Flight t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Flight> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	// --------------------------function sellect all
	// flight--------------------------------
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT *  FROM FLIGHT";
		try {
			connect = JDBCUtil.getConnection();
			stmt = connect.prepareStatement(query);
			rs = stmt.executeQuery();
			//
		} catch (SQLException ex) {
			Logger.getLogger(null);
			throw ex;
		}
		return rs;
	}

	// Phương thức chèn chuyến bay mới vào bảng FLIGHT
	public static String insertFlight(Connection conn, String flightFrom, String flightTo, String planeID,
			java.util.Date departureDate, int spinnerHour, int spinnerMinute, int flightTime, float flightCost)
			throws SQLException {
		// Tạo FlightID mới bằng cách tăng giá trị cuối cùng lên 1 đơn vị
		String newFlightID = generateNewFlightID(conn);

		// Kết hợp departureDate, spinnerHour và spinnerMinute thành SMALLDATETIME
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(departureDate);
		cal.set(java.util.Calendar.HOUR_OF_DAY, spinnerHour);
		cal.set(java.util.Calendar.MINUTE, spinnerMinute);

		java.sql.Timestamp departureDateTime = new java.sql.Timestamp(cal.getTimeInMillis());
		String insertFlightSQL = "INSERT INTO FLIGHT (FlightID, PlaneID, DepartureAirportCode, ArrivalAirportCode, TicketPrice, DepartureDateTime, FlightDuration) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(insertFlightSQL,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, newFlightID);
			pstmt.setString(2, planeID);
			pstmt.setString(3, flightFrom);
			pstmt.setString(4, flightTo);
			pstmt.setFloat(5, flightCost);
			pstmt.setTimestamp(6, departureDateTime);
			pstmt.setInt(7, flightTime);

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating flight failed, no rows affected.");
			}
			return newFlightID;
		}
	}

	// Phương thức tạo FlightID mới
	private static String generateNewFlightID(Connection conn) throws SQLException {
		String lastFlightIDQuery = "SELECT TOP 1 FlightID FROM FLIGHT ORDER BY FlightID DESC";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(lastFlightIDQuery)) {
			if (rs.next()) {
				String lastFlightID = rs.getString("FlightID");
				// Tăng giá trị cuối cùng lên 1 đơn vị
				int lastIDNumber = Integer.parseInt(lastFlightID.substring(2));
				int newIDNumber = lastIDNumber + 1;
				return "FL" + String.format("%04d", newIDNumber);
			} else {
				// Nếu không có bản ghi nào trong bảng, bắt đầu với FL0001
				return "FL0001";
			}
		}
	}

	// Phương thức chèn sân bay trung gian vào bảng FLIGHT_DETAIL
	public static void insertIntermediateFlight(Connection conn, String flightID, String airportID, int restTime,
			String note) throws SQLException {
		String insertIntermediateFlightSQL = "INSERT INTO FLIGHT_DETAIL (PreventiveAirportID, FlightID, StopoverDuration, Note) "
				+ "VALUES (?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(insertIntermediateFlightSQL)) {
			pstmt.setString(1, airportID);
			pstmt.setString(2, flightID);
			pstmt.setInt(3, restTime);
			pstmt.setString(4, note);
			pstmt.executeUpdate();
		}
	}
	// Phương thức để xóa chuyến bay
    public static void deleteFlight(Connection conn, String flightID) throws SQLException {
        // Câu truy vấn để xóa các khóa ngoại liên quan đến FLIGHT
        String deleteFlightDetailSQL = "DELETE FROM FLIGHT_DETAIL WHERE FlightID = ?";
        String deleteFlightTicketClassDetailSQL = "DELETE FROM FLIGHT_TICKET_CLASS_DETAIL WHERE FlightID = ?";
        String deleteTicketSQL = "DELETE FROM TICKET WHERE FlightID = ?";
        String deleteFlightSQL = "DELETE FROM FLIGHT WHERE FlightID = ?";

        // Sử dụng Transaction để đảm bảo tất cả các câu truy vấn đều được thực hiện
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmtDeleteFlightDetail = conn.prepareStatement(deleteFlightDetailSQL);
//                 PreparedStatement pstmtDeleteFlightTicketClassDetail = conn.prepareStatement(deleteFlightTicketClassDetailSQL);
//                 PreparedStatement pstmtDeleteTicket = conn.prepareStatement(deleteTicketSQL);
                 PreparedStatement pstmtDeleteFlight = conn.prepareStatement(deleteFlightSQL)) {
                 
                // Đặt giá trị cho tham số FlightID
                pstmtDeleteFlightDetail.setString(1, flightID);
//                pstmtDeleteFlightTicketClassDetail.setString(1, flightID);
//                pstmtDeleteTicket.setString(1, flightID);
                pstmtDeleteFlight.setString(1, flightID);

                // Thực hiện các câu truy vấn xóa
                pstmtDeleteFlightDetail.executeUpdate();
//                pstmtDeleteFlightTicketClassDetail.executeUpdate();
//                pstmtDeleteTicket.executeUpdate();
                pstmtDeleteFlight.executeUpdate();

                // Xác nhận transaction
                conn.commit();
            } catch (SQLException ex) {
                // Rollback transaction nếu có lỗi xảy ra
                conn.rollback();
                throw ex;
            } finally {
                // Khôi phục chế độ auto-commit
                conn.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Error while deleting flight", ex);
        }
    }

}
