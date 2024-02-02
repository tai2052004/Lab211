/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Order extends Fruit{
    public String Customer;
    Hashtable<String,List <Fruit>> CustomerOrder = new Hashtable<>();
    
    public  Order(){  
    }

    public Order(String Customer, Hashtable<String,List <Fruit>> CustomerOrder) {
        this.Customer = Customer;
        this.CustomerOrder = CustomerOrder;
    }
  
    public void setOrder(Fruit f)
    {
        if ( CustomerOrder.containsKey(f.getCustomer()))
                {
                    List<Fruit> Ordered = CustomerOrder.get(f.getCustomer());
                    Ordered.add(f);
                   CustomerOrder.put(f.getCustomer(), Ordered);
                }
                else {
                    List<Fruit> Ordering = new ArrayList<>();
                    Ordering.add(f);
                    CustomerOrder.put(f.getCustomer(), Ordering);
                }
    }
    
    public Hashtable<String,List <Fruit>> getOrder()
    {
        return CustomerOrder;
    }
}
