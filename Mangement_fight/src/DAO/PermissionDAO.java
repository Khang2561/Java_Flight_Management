package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

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

}
