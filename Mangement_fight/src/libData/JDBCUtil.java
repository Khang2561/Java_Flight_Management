package libData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection() {
    	Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://LAPTOP-H8FTS6MD\\SQLEXPRESS01:1433;databaseName=nhaSach;trustServerCertificate=true";
            String userName = "admin";
            String password = "Khang0943069831";

            c = DriverManager.getConnection(url, userName, password);
            //String sql = "select * from FLIGHT";
            //Statement statement = connection.createStatement();
            //ResultSet rs = statement.executeQuery(sql);
            //while(rs.next()) {
            //    System.out.println(rs.getString(1));
            //    System.out.println(rs.getString(2));
            //}
            System.out.println("Ket noi thanh cong");
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
}
