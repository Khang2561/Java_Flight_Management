package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Model.Account;
import Model.Airport;
import libData.JDBCUtil;

public class AAADAO implements DAOInterface<Account>{
	
	public static AAADAO getInstance() {
		return new AAADAO();
	}
	
	@Override
	public int insert(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account selectById(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
	    
	    //thu cua thay
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM ACCOUNT LEFT JOIN PERMISSION ON ACCOUNT.RoleID = PERMISSION.RoleID;";
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
