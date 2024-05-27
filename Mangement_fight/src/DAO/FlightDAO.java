package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Airport;
import Model.Flight;
import libData.JDBCUtil;

public class FlightDAO implements DAOInterface<Flight>{

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
	
	//--------------------------function sellect all flight--------------------------------
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

}
