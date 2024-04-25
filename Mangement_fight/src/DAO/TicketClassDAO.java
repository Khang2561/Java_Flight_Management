package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Account;
import Model.TicketClass;
import libData.JDBCUtil;

public class TicketClassDAO implements DAOInterface<TicketClass>{

	@Override
	public int insert(TicketClass t) {
		// TODO Auto-generated method stub
		return 0;
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

}
