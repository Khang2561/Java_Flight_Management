package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Plane;
import Model.Seat;
import libData.JDBCUtil;

public class SeatDAO implements DAOInterface<Seat>{

	@Override
	public int insert(Seat t) {
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;
	    
	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "INSERT INTO SEAT (SeatID, PlaneID, TicketClassID) VALUES (?,?, ?)";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getSeatID());
	        preparedStatement.setString(2, t.getPlaneID());
	        preparedStatement.setString(3, t.getTicketClass());
	        
	        
	        // Execute the statement
	        rowsAffected = preparedStatement.executeUpdate();
	        //B5: CLOSE CONNECTION 
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in the reverse order of their creation
	        JDBCUtil.closeConnection(con);
	        if (preparedStatement != null) {
	            try {
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    return rowsAffected;
	}

	@Override
	public int update(Seat t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Seat t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seat selectById(Seat t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Seat> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
	    //thu cua thay
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM SEAT;";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } /*finally {
	        if (stmt !=null &&!stmt.isClosed()) {
	        	stmt.close();
	        }
	        if(connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }*/
		return rs;
	}
	public static ResultSet selectSeat(String planeID, String seatID) throws SQLException, ClassNotFoundException {
	    //thu cua thay
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM SEAT WHERE PlaneID = ? AND SeatID = ?";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, planeID);
	    	stmt.setString(2, seatID);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } /*finally {
	        if (stmt !=null &&!stmt.isClosed()) {
	        	stmt.close();
	        }
	        if(connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }*/
		return rs;
	}
	public static void deleteSeat(String planeID) throws SQLException, ClassNotFoundException {
	    //thu cua thay
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "DELETE FROM SEAT WHERE PlaneID = ?";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, planeID);
	    	stmt.executeUpdate();
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } /*finally {
	        if (stmt !=null &&!stmt.isClosed()) {
	        	stmt.close();
	        }
	        if(connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }*/
	}

	//----------------------------------------------------------------
	public static ResultSet sellectSeatByPlaneID(String name) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM SEAT LEFT JOIN FLIGHT ON FLIGHT.PlaneID = SEAT.PlaneID LEFT JOIN TICKET_CLASS ON TICKET_CLASS.TicketClassID = SEAT.TicketClassID WHERE FLIGHT.FlightID = '?';";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, name);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } 
		return rs;
	}

	//----------------------------------------------------------------------
	public static int countSeatByPlaneID(String planeID) throws SQLException, ClassNotFoundException {
	    String query = "SELECT COUNT(*) FROM SEAT LEFT JOIN FLIGHT ON FLIGHT.PlaneID = SEAT.PlaneID LEFT JOIN TICKET_CLASS ON TICKET_CLASS.TicketClassID = SEAT.TicketClassID WHERE FLIGHT.FlightID = ?;";
	    int count = 0;

	    try (Connection connect = JDBCUtil.getConnection();
	         PreparedStatement stmt = connect.prepareStatement(query)) {

	        stmt.setString(1, planeID);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        }
	    } catch (SQLException ex) {
	       
	        throw ex;
	    }
	    return count;
	}
	
	//-----------------------------------------------------------------------------
	public static ResultSet sellectTicketClass(String name) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT DISTINCT TICKET_CLASS.TicketClassID, TICKET_CLASS.TicketClassName, TICKET_CLASS.PricePercentage FROM SEAT LEFT JOIN FLIGHT ON FLIGHT.PlaneID = SEAT.PlaneID LEFT JOIN TICKET_CLASS ON TICKET_CLASS.TicketClassID = SEAT.TicketClassID WHERE FLIGHT.FlightID = ?";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, name);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       //Logger.getLogger(null);
	       throw ex;
	    } 
		return rs;
	}
	//------------------------------------------------------------------
	public static String nameTicketClass( String nameTicketClass, String Location) throws SQLException, ClassNotFoundException {
	    String query = "SELECT TicketClassName FROM SEAT LEFT JOIN FLIGHT ON FLIGHT.PlaneID = SEAT.PlaneID LEFT JOIN TICKET_CLASS ON TICKET_CLASS.TicketClassID = SEAT.TicketClassID WHERE FLIGHT.FlightID = ? AND SeatID = ?;";
	    String count = "";

	    try (Connection connect = JDBCUtil.getConnection();
	         PreparedStatement stmt = connect.prepareStatement(query)) {

	    
	        stmt.setString(1, nameTicketClass);
	        stmt.setString(2, Location);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getString(1);
	            }
	        }
	    } catch (SQLException ex) {
	       
	        throw ex;
	    }
	    return count;
	}
	//--------------------------------------------------------------------
	public static long TicketMoney(String planeID) throws SQLException, ClassNotFoundException {
	    String query = "SELECT DISTINCT TicketPrice FROM SEAT LEFT JOIN FLIGHT ON FLIGHT.PlaneID = SEAT.PlaneID LEFT JOIN TICKET_CLASS ON TICKET_CLASS.TicketClassID = SEAT.TicketClassID WHERE FLIGHT.FlightID = ?;";
	    long count = 0;

	    try (Connection connect = JDBCUtil.getConnection();
	         PreparedStatement stmt = connect.prepareStatement(query)) {

	        stmt.setString(1, planeID);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        }
	    } catch (SQLException ex) {
	       
	        throw ex;
	    }
	    return count;
	}
	//-----------------------------------------------------------------------
	public static ResultSet ticketBooked(String name) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM FLIGHT_TICKET WHERE FlightID = ?;";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, name);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       //Logger.getLogger(null);
	       throw ex;
	    } 
		return rs;
	}
	//-------------------------------------------------------------------------
	public static boolean isSeatBooked(String flightID, String seatID) throws SQLException, ClassNotFoundException {
	    Connection connect = JDBCUtil.getConnection();
	    String query = "SELECT COUNT(*) FROM FLIGHT_TICKET WHERE FlightID = ? AND SeatID = ? ";
	    PreparedStatement stmt = connect.prepareStatement(query);
	    stmt.setString(1, flightID);
	    stmt.setString(2, seatID);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
	        return rs.getInt(1) > 0;
	    }
	    return false;
	}
}
