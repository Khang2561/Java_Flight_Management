package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JTextField;

import Model.Account;
import Model.TicketClass;
import libData.JDBCUtil;

public class TicketClassDAO implements DAOInterface<TicketClass>{
	
	public static TicketClassDAO getInstance() {
		return new TicketClassDAO();
	}
	
	@Override
	public int insert(TicketClass t) {
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "INSERT INTO TICKET_CLASS (TicketClassID, TicketClassName, PricePercentage) VALUES (?, ?, ?)";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getTicketClassID());
	        preparedStatement.setString(2, t.getTicketClassName());
	        preparedStatement.setString(3, t.getPricePercentage());
	        
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
	public int update(TicketClass t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TicketClass t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TicketClass selectById(TicketClass t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TicketClass> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
	    //thu cua thay
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM TICKET_CLASS;";
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
	
	//DEM SAN BAY 
	public static ResultSet countTicketClass() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM TICKET_CLASS";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(null);
            throw ex;
        } 
    }

	public static boolean isTicketClassExists(String ticketClassName) throws SQLException, ClassNotFoundException {
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM TICKET_CLASS WHERE TicketClassName = ?";
	    try {
	        connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        stmt.setString(1, ticketClassName);
	        rs = stmt.executeQuery();
	        return rs.next();
	    } finally {
	        // Close resources
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (connect != null) {
	            connect.close();
	        }
	    }
		
	}
	
	public static ResultSet findTCbynName(String name) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM TICKET_CLASS WHERE TicketClassName = ?;";
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
	public static ResultSet findTCColorByID(String ID) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM TICKET_CLASS WHERE TicketClassID = ?;";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, ID);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } 
		return rs;
	}
	public static int deleteByName(String name) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // Establish connection with the database
	        con = JDBCUtil.getConnection();
	        
	        // Define the SQL statement
	        String sql = "DELETE FROM TICKET_CLASS WHERE TicketClassName = ?";
	        
	        // Create a prepared statement
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set the value for the parameter
	        preparedStatement.setString(1, name);
	        
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

	public static int updateTicketClass(TicketClass t) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // Kết nối đến cơ sở dữ liệu
	        con = JDBCUtil.getConnection();
	        
	        // Chuẩn bị câu lệnh SQL cập nhật
	        String sql = "UPDATE TICKET_CLASS SET TicketClassName = ?, PricePercentage = ? WHERE TicketClassID = ?";
	        
	        // Tạo một PreparedStatement
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Thiết lập các tham số cho câu lệnh SQL
	        preparedStatement.setString(1, t.getTicketClassName());
	        preparedStatement.setString(2, t.getPricePercentage());
	        preparedStatement.setString(3, t.getTicketClassID());
	        
	        // Thực thi câu lệnh SQL để cập nhật dữ liệu
	        rowsAffected = preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng các tài nguyên
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
	
	public static int updateAirport(TicketClass updatedAirport) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // Connect to the database
	        con = JDBCUtil.getConnection();
	        // Define the SQL statement for update
	        String sql = "UPDATE TICKET_CLASS SET TicketClassName = ?, PricePercentage = ? WHERE TicketClassID = ?";
	        // Create a prepared statement
	        preparedStatement = con.prepareStatement(sql);

	        // Set values for parameters
	        preparedStatement.setString(1, updatedAirport.getTicketClassName());
	        preparedStatement.setString(2, updatedAirport.getPricePercentage());
	        preparedStatement.setString(3, updatedAirport.getTicketClassID());
	        
	        // Execute the update statement
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
}


