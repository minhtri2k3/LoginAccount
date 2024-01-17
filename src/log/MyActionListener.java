/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JList;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class MyActionListener extends MouseAdapter{
    private Connection connection = database.connect();    
    private  JList < String > list;
    private String product;
    private Customer cus;
    private int value;
    private String Seller;
//     private JLabel label;
     public MyActionListener( Customer cus ,String product ,JList<String> list  ) {
            this.product = product;
            this.list = list;
            this.cus = cus;
     }
      
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        System.out.println("Move"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//         System.out.println("Drage"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
//
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//         System.out.println("Enter"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        System.out.println("Relased"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        System.out.println("Press");// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
               
       @Override
    public void mouseClicked(MouseEvent e) {
         Seller = list.getSelectedValue();
       
         if(Seller == null){
            JOptionPane.showMessageDialog(cus ,"Choose a shop you want");
         }
         else{
             try{
            PreparedStatement stm = connection.prepareStatement("Select Quantity from admins where Admin_name = ? and Product = ?");
            stm.setString(1, Seller);
            stm.setString(2, product);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                this.value = rs.getInt("Quantity");
                System.out.println(value);
                
             }
        }catch(Exception ex){
            ex.printStackTrace();
        }
          
            PleaseConfirm pls = new PleaseConfirm(cus , true);
             pls.Set_test_list(Seller,product,cus);
            pls.setVisible(true);
            
            
         }  
    }
}
 
   
      
    


       
    

