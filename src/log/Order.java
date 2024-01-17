/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

import java.awt.List;

/**
 *
 * @author ASUS
 */
public class Order {
    private String Seller;
    private String Product;
    private String Import_day;
    private double prize;
    private double amount;
    public Order(String Seller, String Product, String Import_day, double amount , double prize) {
        this.Seller = Seller;
        this.Product = Product;
        this.Import_day = Import_day;
        this.prize = prize;
        this.amount = amount;
    }
}
