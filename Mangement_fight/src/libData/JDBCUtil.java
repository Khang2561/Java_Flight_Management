package libData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.AirportDAO;
import View.Admin.Setting.Setting;

public class JDBCUtil {
	public static Connection getConnection() {
    	Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url= "jdbc:sqlserver://localhost:1433;databaseName=FlightTicketManagement;"
            		+ "trustServerCertificate=true";

            String userName = "admin";
            String password = "1";


            c = DriverManager.getConnection(url, userName, password);
          
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    //dong ket noi
    public static void closeConnection(Connection c) {
    	try {
    		if(c!=null) {
    			c.close();
    		}
    	}catch (Exception e) {
    		
    	}
    }
    //in thong tin
    public static void printInfo(Connection c) {
    	try {
    		if(c!=null) {
    			DatabaseMetaData mtdt = c.getMetaData();
    			System.out.println(mtdt.getDatabaseProductName());
    			System.out.println(mtdt.getDatabaseProductVersion());
    			}
    		}catch(Exception e) {	
    			e.printStackTrace();
    		}
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Phương thức thực thi truy vấn SQL và trả về kết quả dưới dạng ResultSet
    public static ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }


}

