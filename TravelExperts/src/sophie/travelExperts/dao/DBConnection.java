package sophie.travelExperts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection connectDB()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/travelexperts?useSSL=false";
        String userName = "root";
        String password = "";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url,userName,password);
        }
        catch  (SQLException e) {
            e.printStackTrace();

        }catch (ClassNotFoundException e) {
           
            e.printStackTrace();
        }
        return connection;
    }

}
