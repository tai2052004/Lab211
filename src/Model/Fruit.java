/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Fruit {
    protected int id;
    protected String name;
    protected double price;
    protected int quantity1;
    protected int quantity2;
    protected String origin;
    protected String customer;
    protected double amount;
    
    public Fruit(){
    }

    public Fruit(int id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity1 = quantity;
        this.origin = origin;
    }
    
    public Fruit(String customer,int id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity1 = quantity;
        this.origin = origin;
        this.customer= customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(int quantity1) {
        this.quantity1 = quantity1;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return quantity2 * price;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public int Remaining()
    {
        return quantity1 - quantity2;
    }
    
   
}
