package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;


import Model.Airport;

import Model.Flight;

import Model.Plane;
import libData.JDBCUtil;

public class PlaneDAO implements DAOInterface<Plane>{


	@Override
	public int insert(Plane t) {
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "INSERT INTO PLANE (PlaneID,PlaneName,SeatCount) VALUES (?, ?, ?)";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getPlaneID());
	        preparedStatement.setString(2, t.getPlaneName());
	        preparedStatement.setLong(3, t.getSeatCount());
	        
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
	public int update(Plane t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Plane t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Plane selectById(Plane t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plane> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean isPlaneIdExists(String accountId) throws SQLException, ClassNotFoundException {
	    Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM PLANE WHERE PlaneID = ?";
	    try {
	        connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        stmt.setString(1, accountId);
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

	public static boolean isPlaneExists(String namePlane) throws SQLException {
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM PLANE WHERE PlaneName = ?";
	    try {
	    	connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        stmt.setString(1, namePlane);
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

	public static ResultSet countPlane() throws SQLException {
		Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) FROM PLANE";
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

    //--------------------------function select all planes--------------------------------
    public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT *  FROM PLANE";
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
    public static void updatePlanebyID(String planeID,String planeName,int seat) throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "UPDATE PLANE SET PlaneName = ? , SeatCount = ? WHERE PlaneID = ?";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            stmt.setString(1, planeName);
            stmt.setInt(2, seat);
            stmt.setString(3, planeID);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(null);
            throw ex;
        } 

	}

	


     

    //--------------------------function select ticket counts for a given plane ID--------------------------------
    public static ResultSet numberTicketClass(String planeID) throws SQLException, ClassNotFoundException {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT TICKET_CLASS.TicketClassName, COUNT(SEAT.SeatID) AS TicketCount "
                     + "FROM SEAT "
                     + "LEFT JOIN PLANE ON SEAT.PlaneID = PLANE.PlaneID "
                     + "LEFT JOIN TICKET_CLASS ON SEAT.TicketClassID = TICKET_CLASS.TicketClassID "
                     + "WHERE PLANE.PlaneID = ? "
                     + "GROUP BY PLANE.PlaneID, TICKET_CLASS.TicketClassName";
        try {
            connect = JDBCUtil.getConnection();
            stmt = connect.prepareStatement(query);
            stmt.setString(1, planeID);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(null);
            throw ex;
        }
        return rs;
    }

}
