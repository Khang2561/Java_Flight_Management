package DALs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Account;
import libData.JDBCUtil;

public class AccountDAL {
	public Account login(String username, String password) {
	    try {
	        // Establish a connection to your database
	        Connection conn = JDBCUtil.getConnection();

	        // Prepare a SQL query
	        String sql = "SELECT ac.AccountID, ac.Name, ac.Email, ac.Phone, ac.Password, ac.RoleID, role.RoleName " +
	                     "FROM ACCOUNTs ac " +
	                     "JOIN PERMISSIONs role ON ac.RoleID = role.RoleID " +
	                     "WHERE (ac.Phone = ? OR ac.Email = ?) AND ac.Password = ?";

	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, username);
	        pstmt.setString(3, password);

	        // Execute the query
	        ResultSet rs = pstmt.executeQuery();

	        // Check if an account was found
	        if (!rs.next()) {
	            System.out.println("Tài khoản hoặc mật khẩu không đúng");
	            return null;
	        }

	        // Create a new Account from the result
	        Account account = new Account();
	        account.setAccountID(rs.getString("AccountID"));
	        account.setName(rs.getString("Name"));
	        account.setEmail(rs.getString("Email"));
	        account.setPhone(rs.getString("Phone"));
	        account.setPassword(rs.getString("Password"));
	        //account.setCreated(new Date());
	        account.setRoleID(rs.getString("RoleID"));
	        account.setRoleName(rs.getString("RoleName"));

	        // Get the PermissionCode
	        sql = "SELECT PermissionCode FROM PERMISSIONs WHERE RoleID = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, account.getRoleID());
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            account.setPermissionCode(rs.getString("PermissionCode"));
	        }

	        System.out.println("Đăng nhập thành công");
	        return account;

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return null;
	    }
	}

}
