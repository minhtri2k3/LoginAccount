import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class rolese_select {
        public static void main(String[] args) throws SQLException {

                try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root",
                                        "Lemanh@1412");
                        Statement st = connection.createStatement();
                       
                        String username = "Tom";
                        ResultSet rs = st.executeQuery("select *  from users where name = '"+username +"'");
                        // st.execute(s);
                        if(rs.next()){
                                System.out.println(rs.getString(1));
                        }
                        else{
                                System.out.println("Can not find username");

                        }
                         // String s = " CREATE TABLE test ( PersonID int, LastName
                        // varchar(255),FirstName varchar(255),Address varchar(255), City
                        // varchar(255))";

                } catch (Exception e) {
                        System.out.println("error");
                }

        }

}
