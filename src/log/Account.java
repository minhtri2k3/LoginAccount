package log;



import loginaccount.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {
    private Login l;
    private String un;
    private String pass;
    private String role;
    //call 
    private Connection connection = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    
    public Account(Login l) {
        this.l = l;
        connection = database.connect();   
     }

    private String getRole(String username){
        String role = "null";
        //Java connect SQL
        try {
            ResultSet rs = connection.createStatement().executeQuery("select *  from users where User_name = '"+username +"'");
            if(rs.next()) {
             return rs.getString(2);//Choose value in Column 2
        }}
             

    
        catch (Exception e) {
            // TODO: handle exception
        }
        return role;
    }
    public boolean check(String un, String pass){
        this.un = un;
        this.pass = pass;
        try {
            String sql = "SELECT * FROM users WHERE User_name = ? And PASS = ?";
            pst =   connection.prepareCall(sql);
            pst.setString(1, un);
            pst.setString(2, pass);
            String role  = getRole(un);
            rs = pst.executeQuery();   // pst is PrepareStatement
             if(rs.next()) {
            return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        return false;
    }
    public String getUsername() {
        return un;
    }
    public String getPassword() {
        return pass;
    }
}
