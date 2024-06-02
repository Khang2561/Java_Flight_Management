package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Airport;
import Model.TicketClass;
import View.Admin.Setting.Setting;
import libData.JDBCUtil;

public class AirportDAO implements DAOInterface<Airport> {

	public static AirportDAO getInstance() {
		return new AirportDAO();
	}
	//----------------------------function insert airport------------------------------------
	@Override
	public int insert(Airport t) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "INSERT INTO AIRPORT (AirportID, AirportName, CityName, CountryName) VALUES (?, ?, ?, ?)";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getAirportID());
	        preparedStatement.setString(2, t.getAirportName());
	        preparedStatement.setString(3, t.getCityName());
	        preparedStatement.setString(4, t.getCountryName());
	        
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

	//----------------------------------------function update airport------------------------------
	public  int update(Airport t) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // B1: CONNECT TO DATABASE
	        con = JDBCUtil.getConnection();
	        // B2: EXECUTE SQL STATEMENT 
	        String sql = "UPDATE AIRPORT SET AirportName = ?, CityName = ?, CountryName = ? WHERE AirportID = ?";
	        // B3: CREATE PREPAREDSTATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getAirportName());
	        preparedStatement.setString(2, t.getCityName());
	        preparedStatement.setString(3, t.getCountryName());
	        preparedStatement.setString(4, t.getAirportID());
	        
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
	//---------------------------------------------
	public static int  updatebyID(Airport t) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // B1: CONNECT TO DATABASE
	        con = JDBCUtil.getConnection();
	        // B2: EXECUTE SQL STATEMENT 
	        String sql = "UPDATE AIRPORT SET AirportName = ?, CityName = ?, CountryName = ? WHERE AirportID = ?";
	        // B3: CREATE PREPAREDSTATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getAirportName());
	        preparedStatement.setString(2, t.getCityName());
	        preparedStatement.setString(3, t.getCountryName());
	        preparedStatement.setString(4, t.getAirportID());
	        
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
	
	//-------------------------------function delete airport----------------------------------------
	@Override
	public int delete(Airport t) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // B1: CONNECT TO DATABASE
	        con = JDBCUtil.getConnection();
	        // B2: EXECUTE SQL STATEMENT 
	        String sql = "DELETE FROM AIRPORT WHERE AirportID = ?";
	        // B3: CREATE PREPAREDSTATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set the value for the parameter
	        preparedStatement.setString(1, t.getAirportID());
	        
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
	
	//--------------------------function sellect all airport--------------------------------
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT *  FROM AIRPORT";
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
	
	//-----------------------function count airport to generate id airport--------------------------
	public static ResultSet countAirport() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) FROM AIRPORT";
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

	
	//---------------------------------function find airport by airport id---------------------------------
	@Override
	public Airport selectById(Airport t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//---------------------------------function find airport by airport name---------------------------------
	@Override
	public ArrayList<Airport> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean isAirportExists(String airportName, String cityName, String countryName) throws SQLException, ClassNotFoundException {
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM AIRPORT WHERE AirportName = ? ";
	    try {
	        connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        stmt.setString(1, airportName);
	        rs = stmt.executeQuery();
	        return rs.next(); // Trả về true nếu có ít nhất một dòng kết quả
	    } finally {
	        // Đóng tài nguyên
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
	//---------------------------------function find airport by airport name and return table---------------------------------
	public static ResultSet findAPbyName(String name) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM AIRPORT WHERE AirportName = ?;";
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
	//----------------------------------function delete by airport name---------------
	public static int deleteByName(String name) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // Establish connection with the database
	        con = JDBCUtil.getConnection();
	        
	        // Define the SQL statement
	        String sql = "DELETE FROM AIRPORT WHERE AirportName = ?";
	        
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
	//--------------------------------function isAirportExists------------------
	public static boolean isAirportExists(String nameAirport) throws SQLException, ClassNotFoundException{
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM AIRPORT WHERE AirportName = ?";
	    try {
	    	connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        stmt.setString(1, nameAirport);
	        rs = stmt.executeQuery();
	        return rs.next();
	    }finally {
	    	// Đóng tài nguyên
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
	// Phương thức truy vấn AirportName từ AirportID
	public static String getAirportName(Connection conn, String airportID) throws SQLException {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT AirportName FROM AIRPORT WHERE AirportID = N'").append(airportID).append("' ");

		try (PreparedStatement pstmt = conn.prepareStatement(queryBuilder.toString())) {
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getString("AirportName");
				} else {
					return null;
				}
			}
		}
	}
	// Phương thức truy vấn AirportID từ tên sân bay
	public static String getAirportID(Connection conn, String airportName) throws SQLException {
	    StringBuilder queryBuilder = new StringBuilder();
	    queryBuilder.append("SELECT AirportID FROM AIRPORT WHERE AirportName = N'").append(airportName).append("' ");
	    
	    try (PreparedStatement pstmt = conn.prepareStatement(queryBuilder.toString())) {
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getString("AirportID");
	            } else {
	                return null;
	            }
	        }
	    }
	}
	//---------------------------------function find airport id by name --------------------
	/*
	public static String findIDbyName(String NameAirport) throws SQLException, ClassNotFoundException{
		//ket noi sql nguyen mau
				Connection connect = null;
			    PreparedStatement stmt = null;
			    ResultSet rs = null;
			    String query = "SELECT * FROM AIRPORT WHERE AirportName = ?;";
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
	}*/
	//----------------------------function update airport------------------------------
	
	

}
