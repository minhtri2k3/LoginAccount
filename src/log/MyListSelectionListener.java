/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

import com.sun.jdi.connect.spi.Connection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author ASUS
 */
public class MyListSelectionListener extends MouseAdapter{
    private String name;
    private JLabel label;
    private java.sql.Connection connection = database.connect();    
   
   
    private JList < String > list;
    public MyListSelectionListener(String name, JList < String > list,JLabel label) {
        this.name = name;
        this.label = label;
        this.list = list;
    }
    private String Set_up(){
        String res = "0";
          String Seller = list.getSelectedValue();
        try{
            PreparedStatement stm = connection.prepareStatement("Select SUM(Quantity) from admins where Admin_name = ? and Product = ?");
            stm.setString(1, Seller);
            stm.setString(2, name);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                int value = rs.getInt("SUM(Quantity)");
              res = String.valueOf(value);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
  @Override
    public void mouseClicked(MouseEvent e) {
        label.setText(this.Set_up()+" kg");
    }

   
}
