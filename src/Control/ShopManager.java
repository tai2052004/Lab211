/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Control;

import Model.FileManager;
import Model.Fruit;
import Model.FruitManagement;
import Model.Order;
import Model.OrderManagement;
import java.util.*;
import java.io.*;
import java.util.function.Predicate;

/**
 *
 * @author Admin
 */
public class ShopManager { 
   FruitManagement fma = new FruitManagement();
   OrderManagement om = new OrderManagement();

   
   public void CreateFruit(List<Fruit> list) throws IOException
   {
       list = fma.addFruit(list);
   }
   
    public void ViewOrder() throws IOException
    {
        om.ViewOrder();
    }
    
    public void DisplayFruit(List<Fruit> list) throws IOException
    {
        om.DisplayFruit(list);
    }
    
    
    public void Shopping(List<Fruit> list) throws IOException 
    {
        om.Ordering(list);
    }
}
