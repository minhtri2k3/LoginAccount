/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

/**
 *
 * @author ASUS
 */
public class Bill {
    private String Seller;
    private String item;
    private int prize;
    private int quatity;
    private int day;
    private int value;

    public Bill(String Seller, String item, int prize, int quatity, int day, int value) {
        this.Seller = Seller;
        this.item = item;
        this.prize = prize;
        this.quatity = quatity;
        this.day = day;
        this.value = value;
    }
    
}
