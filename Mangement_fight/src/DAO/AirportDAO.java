package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Airport;
import View.Admin.Setting.Setting;
import libData.JDBCUtil;

public class AirportDAO implements DAOInterface<Airport> {

	public static AirportDAO getInstance() {
		return new AirportDAO();
	}
	//ham insert san bay 
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

	//ham update san bay
	@Override
	public int update(Airport t) {
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
	
	//ham xoa san bay
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
	
	public void selectAll() throws SQLException, ClassNotFoundException {
	    
	    //thu cua thay
	    Connection connect = null;
	    Statement stmt = null;
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.createStatement();
	    	ResultSet result = stmt.executeQuery("SELECT * FROM AIRPORT");
	    	Setting.loadRsToTable(result);
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } finally {
	        if (stmt !=null &&!stmt.isClosed()) {
	        	stmt.close();
	        }
	        if(connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }
	}

	
	//tim san bay theo dia chi ip
	@Override
	public Airport selectById(Airport t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//tim theo dieu kien 
	@Override
	public ArrayList<Airport> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
