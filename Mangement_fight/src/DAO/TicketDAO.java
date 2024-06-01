package DAO;

import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Account;
import Model.Ticket;
import libData.JDBCUtil;

public class TicketDAO implements DAOInterface<Ticket> {

    @Override
    public int insert(Ticket t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Ticket t) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Ticket t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Ticket selectById(Ticket t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Ticket> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    // Retrieve all tickets
    public static ResultSet findTicketAll() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT ticket.FlightTicketID AS TicketID, flight.FlightID, ticket.TicketClassID, ticket.Email, ticket.PhoneNumber, ticket.FullName, ticket.FlightStatus, ticket.IDCard, ticket.Price, ticket.SeatID, flight.DepartureDateTime, ticketClass.TicketClassName "
                     + "FROM FLIGHT_TICKET AS ticket "
                     + "INNER JOIN FLIGHT AS flight ON ticket.FlightID = flight.FlightID "
                     + "INNER JOIN TICKET_CLASS AS ticketClass ON ticket.TicketClassID = ticketClass.TicketClassID "
                     + "WHERE ticket.FlightStatus != 'Đã huỷ'";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(null);
            throw ex;
        }
        return rs;
    }
    //---------- find ticket id ----------------
    public static ResultSet findTicketID(String TicketId) throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT ticket.FlightTicketID AS TicketID, flight.FlightID, ticket.TicketClassID, ticket.Email, ticket.PhoneNumber, ticket.FullName, ticket.FlightStatus, ticket.IDCard, ticket.Price, ticket.SeatID, flight.DepartureDateTime, ticketClass.TicketClassName "
                     + "FROM FLIGHT_TICKET AS ticket "
                     + "INNER JOIN FLIGHT AS flight ON ticket.FlightID = flight.FlightID "
                     + "INNER JOIN TICKET_CLASS AS ticketClass ON ticket.TicketClassID = ticketClass.TicketClassID "
                     + "WHERE ticket.FlightTicketID = ?"
                     + "AND ticket.FlightStatus != 'Đã huỷ'";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            stmt.setString(1, TicketId);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
           
            throw ex;
        }
        return rs;
    }
  //---------- find flight id ----------------
    public static ResultSet findFlightID(String FlightId) throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT ticket.FlightTicketID AS TicketID, flight.FlightID, ticket.TicketClassID, ticket.Email, ticket.PhoneNumber, ticket.FullName, ticket.FlightStatus, ticket.IDCard, ticket.Price, ticket.SeatID, flight.DepartureDateTime, ticketClass.TicketClassName "
                     + "FROM FLIGHT_TICKET AS ticket "
                     + "INNER JOIN FLIGHT AS flight ON ticket.FlightID = flight.FlightID "
                     + "INNER JOIN TICKET_CLASS AS ticketClass ON ticket.TicketClassID = ticketClass.TicketClassID "
                     + "WHERE flight.FlightID = ?"
                     + "AND ticket.FlightStatus != 'Đã huỷ'";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            stmt.setString(1, FlightId);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            
            throw ex;
        }
        return rs;
    }
    //-------------------------------------------------------------
    public static int insert(String FlightTicketID, String FlightID, String TicketClassID, String Price, String FullName, String IDCard, String PhoneNumber, String Email, String SeatID) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // B1: KET NOI VOI DATABASE
            con = JDBCUtil.getConnection();
            
            // B2: THUC HIEN CAU LENH SQL 
            String sql = "INSERT INTO FLIGHT_TICKET (FlightTicketID, FlightID, TicketClassID, Price, FullName, IDCard, PhoneNumber, Email, SeatID, FlightStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            // B3: TAO STATEMENT
            preparedStatement = con.prepareStatement(sql);

            // Debugging: Print values
            System.out.println("Inserting values:");
            System.out.println("FlightTicketID: " + FlightTicketID);
            System.out.println("FlightID: " + FlightID);
            System.out.println("TicketClassID: " + TicketClassID);
            System.out.println("Price: " + Price);
            System.out.println("FullName: " + FullName);
            System.out.println("IDCard: " + IDCard);
            System.out.println("PhoneNumber: " + PhoneNumber);
            System.out.println("Email: " + Email);
            System.out.println("SeatID: " + SeatID);

            // Clean up the Price string
            Price = Price.replaceAll("[^\\d,]", "").replace(".", "").replace(",", ".");
            
            // Validate and set Price
            try {
                double priceValue = Double.parseDouble(Price);
                preparedStatement.setDouble(4, priceValue);
            } catch (NumberFormatException e) {
                System.err.println("Invalid price format: " + Price);
                throw new SQLException("Invalid price format", e);
            }
            
            preparedStatement.setString(1, FlightTicketID);
            preparedStatement.setString(2, FlightID);
            preparedStatement.setString(3, TicketClassID);
            preparedStatement.setString(5, FullName);
            preparedStatement.setString(6, IDCard);
            preparedStatement.setString(7, PhoneNumber);
            preparedStatement.setString(8, Email);
            preparedStatement.setString(9, SeatID);
            preparedStatement.setString(10, "Đã đặt chỗ");

            // Execute the statement
            rowsAffected = preparedStatement.executeUpdate();
            
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


    //-----------------------------------------------------------------
    public static int countAccount() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) FROM FLIGHT_TICKET";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1)+1; // Return the count value from the result set
            } else {
                throw new SQLException("No result returned from query");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(null).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (connect != null) try { connect.close(); } catch (SQLException ignore) {}
        }
    }
}
