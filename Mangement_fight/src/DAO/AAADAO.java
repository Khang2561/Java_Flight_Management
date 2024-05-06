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
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;
	    
	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "INSERT INTO ACCOUNT (AccountID, Name, Phone,Email ,Password,Created,RoleID) VALUES (?,?, ?, ?, ?,?,?)";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getAccountID());
	        preparedStatement.setString(2, t.getName());
	        preparedStatement.setString(3, t.getPhone());
	        preparedStatement.setString(4, t.getEmail());
	        preparedStatement.setString(5, t.getPassword());
	        preparedStatement.setDate(6, new java.sql.Date(t.getCreated().getTime()));
	        preparedStatement.setString(7, t.getRoleID());
	        
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
	
	public static int updateAC(Account AC) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // Establish connection with the database
	        con = JDBCUtil.getConnection();
	        
	        // Define the SQL statement
	        String sql = "UPDATE ACCOUNT SET Name=?, Phone=?, Password=?, RoleID=? WHERE Email=?";
	        
	        // Create a prepared statement
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, AC.getName()); // Assuming tfHoVaTen is your text field for name
	        preparedStatement.setString(2, AC.getPhone()); // Assuming tfSDT is your text field for phone
	        preparedStatement.setString(3, AC.getPassword()); // Assuming tfMK is your text field for password
	        preparedStatement.setString(4, AC.getRoleID()); // Assuming cbQuyen is your combo box for rol
	        preparedStatement.setString(5, AC.getEmail());
	        
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
	
	//xuat toan bo tai khoang
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
	    //ket noi sql nguyen mau
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
	
	//dem tai khoang 
	public static ResultSet countAccount() throws SQLException, ClassNotFoundException{
		Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) FROM ACCOUNT";
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
	
	public static ResultSet findACbyEmail(String email) throws SQLException, ClassNotFoundException{
		 //ket noi sql nguyen mau
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM ACCOUNT WHERE Email = ?;";
	    try {
	    	connect = JDBCUtil.getConnection();
	    	stmt = connect.prepareStatement(query);
	    	stmt.setString(1, email);
	    	rs = stmt.executeQuery();
	    //
	    } catch (SQLException ex) {
	       Logger.getLogger(null);
	       throw ex;
	    } 
		return rs;
	}
	
	//ham check xem tai khoang da ton tai hay chua
	public static boolean isAccountExists(String accountPhone, String accountEmail) throws SQLException, ClassNotFoundException {
		Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM ACCOUNT WHERE Phone = ? AND Email = ?";
	    try {
	    	connect = JDBCUtil.getConnection();
	        stmt = connect.prepareStatement(query);
	        stmt.setString(1, accountPhone);
	        stmt.setString(2, accountEmail);
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
	
	public static boolean isAccountIdExists(String accountId) throws SQLException, ClassNotFoundException {
	    Connection connect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM ACCOUNT WHERE AccountID = ?";
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
	
	//xoa bang email
	public static int deleteByEmail(String email) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	        // Establish connection with the database
	        con = JDBCUtil.getConnection();
	        
	        // Define the SQL statement
	        String sql = "DELETE FROM ACCOUNT WHERE Email = ?";
	        
	        // Create a prepared statement
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set the value for the parameter
	        preparedStatement.setString(1, email);
	        
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
	
	//ham check xem tai khoang da ton tai hay chua
		public static boolean isEmail(String accountEmail) throws SQLException, ClassNotFoundException {
			Connection connect = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    String query = "SELECT * FROM ACCOUNT WHERE Email = ?";
		    try {
		    	connect = JDBCUtil.getConnection();
		        stmt = connect.prepareStatement(query);
		        
		        stmt.setString(1, accountEmail);
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

}
