package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Flight;
import Model.Plane;
import libData.JDBCUtil;

public class PlaneDAO implements DAOInterface<Plane>{

    @Override
    public int insert(Plane t) {
        // TODO Auto-generated method stub
        return 0;
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
        } catch (SQLException ex) {
            Logger.getLogger(null);
            throw ex;
        } 
        return rs;
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
