package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Account;
import Model.Parameters;
import libData.JDBCUtil;

public class ParametersDAO implements DAOInterface<Parameters> {

	public static ParametersDAO getInstance() {
		return new ParametersDAO();
	}
	
	@Override
	public int insert(Parameters t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int updateFightTime(Parameters t) throws SQLException, ClassNotFoundException {
	    Connection connect = null;
	    PreparedStatement stmt = null;
	   
	    String query = "UPDATE Parameters"
	    		+ " SET MinimumFlightTime = ?, "
	            + "MaxPreventiveAirports = ?, "
	            + "MinimumStopoverTime = ?, "
	            + "MaximumStopoverTime = ?, "
	            + "EarliestBookingTime = ?, "
	            + "LatestBookingCancellationTime = ?;";
	    
	    try {
	        connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        
	        // Set parameters for the PreparedStatement
	        int tmp1 = Parameters.minimumFlightTime;
	        int tmp2 = Parameters.maxPreventiveAirports;
	        int tmp3 = Parameters.minimumStopoverTime;
	        int tmp4 = Parameters.maximumStopoverTime;
	        int tmp5 = Parameters.earliestBookingTime;
	        int tmp6 = Parameters.latestBookingCancellationTime;
	        
	        stmt.setInt(1,tmp1);
	        stmt.setInt(2,tmp2);
	        stmt.setInt(3,tmp3);
	        stmt.setInt(4,tmp4);
	        stmt.setInt(5,tmp5);
	        stmt.setInt(6,tmp6);
	     
	        
	        // Execute the update operation
	        int rowsAffected = stmt.executeUpdate();
	        
	        return rowsAffected;
	    } catch (SQLException ex) {
	        Logger.getLogger(null);
	        throw ex;
	    } finally {
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (connect != null) {
	            connect.close();
	        }
	    }
	}
	@Override
	public int delete(Parameters t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Parameters selectById(Parameters t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parameters> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
	    //thu cua thay
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM Parameters;";
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
	
	//get minimum flight time 
	public static int getMinimumFlightTime() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int minimumFlightTime = 0;
        
        String query = "SELECT TOP 1 MinimumFlightTime FROM Parameters;";
        
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                minimumFlightTime = rs.getInt("MinimumFlightTime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(null);
            throw ex;
        } finally {
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
        return minimumFlightTime;
    }
	
	//get max preventive airport
		public static int getMaxPreventiveAirport() throws SQLException, ClassNotFoundException {
	        Connection connect = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        int MaxPreventiveAirport = 0;
	        
	        String query = "SELECT TOP 1 MaxPreventiveAirports FROM Parameters;";

	        
	        try {
	            connect = JDBCUtil.getConnection();
	            stmt = connect.prepareStatement(query);
	            rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	            	MaxPreventiveAirport = rs.getInt("MaxPreventiveAirports");
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(null);
	            throw ex;
	        } finally {
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
	        return MaxPreventiveAirport;
	    }
		
		//get minimum stopver time
				public static int getMiniMumStopoverTime() throws SQLException, ClassNotFoundException {
			        Connection connect = null;
			        PreparedStatement stmt = null;
			        ResultSet rs = null;
			        int minimumFlightTime = 0;
			        
			        String query = "SELECT TOP 1 MinimumStopoverTime FROM Parameters;";
			        
			        try {
			            connect = JDBCUtil.getConnection();
			            stmt = connect.prepareStatement(query);
			            rs = stmt.executeQuery();
			            
			            if (rs.next()) {
			                minimumFlightTime = rs.getInt("MinimumStopoverTime");
			            }
			        } catch (SQLException ex) {
			            Logger.getLogger(null);
			            throw ex;
			        } finally {
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
			        return minimumFlightTime;
			    }
				
				//get maximum stopver time
				public static int getMaximumStopoverTime() throws SQLException, ClassNotFoundException {
			        Connection connect = null;
			        PreparedStatement stmt = null;
			        ResultSet rs = null;
			        int minimumFlightTime = 0;
			        
			        String query = "SELECT TOP 1 MaximumStopoverTime FROM Parameters;";
			        
			        try {
			            connect = JDBCUtil.getConnection();
			            stmt = connect.prepareStatement(query);
			            rs = stmt.executeQuery();
			            
			            if (rs.next()) {
			                minimumFlightTime = rs.getInt("MaximumStopoverTime");
			            }
			        } catch (SQLException ex) {
			            Logger.getLogger(null);
			            throw ex;
			        } finally {
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
			        return minimumFlightTime;
			    }
				//get maximum stopver time
				public static int getEarliestBookingTime() throws SQLException, ClassNotFoundException {
			        Connection connect = null;
			        PreparedStatement stmt = null;
			        ResultSet rs = null;
			        int minimumFlightTime = 0;
			        
			        String query = "SELECT TOP 1 EarliestBookingTime FROM Parameters;";
			        
			        try {
			            connect = JDBCUtil.getConnection();
			            stmt = connect.prepareStatement(query);
			            rs = stmt.executeQuery();
			            
			            if (rs.next()) {
			                minimumFlightTime = rs.getInt("EarliestBookingTime");
			            }
			        } catch (SQLException ex) {
			            Logger.getLogger(null);
			            throw ex;
			        } finally {
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
			        return minimumFlightTime;
			    }
				
				//get maximum stopver time
				public static int getLatestBookingCancellationTime() throws SQLException, ClassNotFoundException {
			        Connection connect = null;
			        PreparedStatement stmt = null;
			        ResultSet rs = null;
			        int minimumFlightTime = 0;
			        
			        String query = "SELECT TOP 1 LatestBookingCancellationTime FROM Parameters;";
			        
			        try {
			            connect = JDBCUtil.getConnection();
			            stmt = connect.prepareStatement(query);
			            rs = stmt.executeQuery();
			            
			            if (rs.next()) {
			                minimumFlightTime = rs.getInt("LatestBookingCancellationTime");
			            }
			        } catch (SQLException ex) {
			            Logger.getLogger(null);
			            throw ex;
			        } finally {
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
			        return minimumFlightTime;
			    }

	@Override
	public int update(Parameters t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
