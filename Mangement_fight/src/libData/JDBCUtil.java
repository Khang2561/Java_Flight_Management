package libData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import DAO.AirportDAO;
import View.Admin.Setting.Setting;

public class JDBCUtil {
	public static Connection getConnection() {
    	Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=FlightTicketManagement;"
            		+ "encrypt=false";
            String userName = "java";
            String password = "java";

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
}
