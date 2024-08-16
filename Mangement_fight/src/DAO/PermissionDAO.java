package DAO;

import java.awt.Button;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import CustomUI.BtnCS;
import Model.Parameters;
import Model.Permission;
import libData.JDBCUtil;

public class PermissionDAO implements DAOInterface<Parameters> {

	public static PermissionDAO getInstance() {
		return new PermissionDAO();
	}
	@Override
	public int insert(Parameters t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Parameters t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
	
	public static int setFlagPermit(String PermissiongCode, String RoleID)throws SQLException, ClassNotFoundException{
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;
	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "UPDATE PERMISSION SET PermissionCode = ? WHERE RoleID = ?";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, PermissiongCode);
	        preparedStatement.setString(2, RoleID);
	        
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
	
	public Permission setPMS(String roleID) throws SQLException, ClassNotFoundException {
		Permission tmp = new Permission();
		
		Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
		if(roleID == "RL0001") {
			tmp.setRoleID("RL0001");
			tmp.setRoleName("Siêu quản trị");
			String query = "SELECT PermissionCode FROM PERMISSION WHERE RoleID = 'RL0001'";
			try {
	            connect = JDBCUtil.getConnection();
	            stmt = connect.prepareStatement(query);
	            rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                tmp.setPermissionCode(rs.getString("PermissionCode"));
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
			return tmp;
		}
		if(roleID == "RL0002") {
			tmp.setRoleID("RL0002");
			tmp.setRoleName("Quản trị");
			String query = "SELECT PermissionCode FROM PERMISSION WHERE RoleID = 'RL0002'";
			try {
	            connect = JDBCUtil.getConnection();
	            stmt = connect.prepareStatement(query);
	            rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                tmp.setPermissionCode(rs.getString("PermissionCode"));
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
			return tmp;
		}
		if(roleID == "RL0003") {
			tmp.setRoleID("RL0003");
			tmp.setRoleName("Ban giám đốc");
			String query = "SELECT PermissionCode FROM PERMISSION WHERE RoleID = 'RL0003'";
			try {
	            connect = JDBCUtil.getConnection();
	            stmt = connect.prepareStatement(query);
	            rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                tmp.setPermissionCode(rs.getString("PermissionCode"));
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
			return tmp;
		}
		else {
			tmp.setRoleID("RL0004");
			tmp.setRoleName("Nhân viên");
			String query = "SELECT PermissionCode FROM PERMISSION WHERE RoleID = 'RL0004'";
			try {
	            connect = JDBCUtil.getConnection();
	            stmt = connect.prepareStatement(query);
	            rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                tmp.setPermissionCode(rs.getString("PermissionCode"));
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
			return tmp;
		}	
    }
	
	public String getPMS(String roleID) throws Exception {
		 try {
		        // Establish a connection to your database
		        Connection conn = JDBCUtil.getConnection();

		        // Prepare a SQL query
		        String sql = "SELECT PermissionCode FROM Permission WHERE RoleID = ?";
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setString(1, roleID);
		        ResultSet rs = stmt.executeQuery();

		        if (rs.next()) {
		            return rs.getString("PermissionCode");
		        } else {
		            throw new Exception("RoleID not found in Permission table");
		        }

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        return null;
		    }
	}
	
	public void setPermsionAccess(String permissionCode, BtnCS[] buttons) {
	    for (int i = 0; i < permissionCode.length(); i++) {
	        char bit = permissionCode.charAt(i);
	        if (bit == '1') {
	            buttons[i].setVisible(true); // grant access
	        } else if (bit == '0') {
	            buttons[i].setVisible(false); // deny access
	        }
	    }
	}
}
