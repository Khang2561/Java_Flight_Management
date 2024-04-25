package DALs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import libData.JDBCUtil;

public class AirportDAL {
public static AirportDAL _ins;
    
    public static AirportDAL getIns() {
        if (_ins == null)
            _ins = new AirportDAL();
        return _ins;
    }
    
 // Lấy danh sách sân bay
    public static String[] getListAirport() {
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM AIRPORT";
            resultSet = statement.executeQuery(sql);

            List<String> airportList = new ArrayList<>();
            while (resultSet.next()) {
                String airportID = resultSet.getString("AirportID");
                String airportName = resultSet.getString("AirportName");
                // Add airport information to the list
                airportList.add(airportID + " - " + airportName);
            }
            
            if (!airportList.isEmpty()) {
                // Convert list to array
                String[] result = new String[airportList.size()];
                result = airportList.toArray(result);
                return result;
            } else {
                return new String[]{"false", null, "Không có sân bay nào"};
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[]{"false", e.getMessage(), null};
        } finally {
            JDBCUtil.closeConnection(connection);
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
    
    

