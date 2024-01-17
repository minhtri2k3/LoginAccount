package log;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","root");

        } catch (ClassNotFoundException|SQLException e){
            
            System.out.println(e);

            }

            return connection;
        }
}

    


