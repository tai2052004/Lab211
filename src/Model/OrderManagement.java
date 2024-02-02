/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Control.ShopManager;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author Admin
 */
public class OrderManagement {
    
   Order order = new Order();
   String fileName = "Data.txt";
   Scanner sc = new Scanner(System.in);
   static FileManager fm = new FileManager(); 
   FruitManagement fma = new FruitManagement();
    
    public void showOrder(List<Fruit> list)
    {
        System.out.println("Product | Quantity | Price | Amount ");
            for (Fruit f : list)
            {
                System.out.printf("| %-9s| %-14s| %-11s| %-10s|\n",f.getName(),f.getQuantity2(),f.getPrice(),f.getAmount());
                System.out.println("Total : "+ f.getAmount());
            }
    }
    
    public void Ordering(List<Fruit> list) throws IOException
    {
         int flag =0;
        String a,b = null;
        List<Fruit> lff = new ArrayList<>();
        do{
        List<Fruit> lf = new ArrayList<>();
        DisplayFruit(list);
        InputFruitName(lf,list);
        InputFruitQuantity(lf);
        showOrder(lf);
        System.out.println("Do you want to order now (Y/N) : ");
        a = sc.next();
        if ( a.equalsIgnoreCase("Y"))
        {
            for ( Fruit f : lf)
            {
                lff.add(f);
            }
            System.out.println("Do you want to keep ordering (Y/N) : ");
            b = sc.next();    
        }
        else if ( a.equalsIgnoreCase("N"))
        {
            lff.clear();
        }
        } while (a.equalsIgnoreCase("N") || b.equalsIgnoreCase("Y"));
            System.out.println("Input your name : ");
            sc.nextLine();
            String n = sc.nextLine();
            for ( Fruit f : lff)
            {
                f.setCustomer(n);
                int r = f.Remaining();
                if ( r <= 0)
                {
                    list.remove(f);
                    fm.UpdateFruitList(list);
                }
                else {
                    f.setQuantity1(r);
                    fm.UpdateFruitList(list);
                }
                order.setOrder(f);
            }
    }
    
    
    
    public void DisplayFruit(List<Fruit> list) throws IOException
    {
        int i = 1;
        System.out.println("List of fruit : ");
        System.out.println("| ++Item++ | ++FruitName++ | ++Origin++ | ++Price++ |");
        System.out.println("|----------|---------------|------------|-----------|");
        for ( Fruit f : list)
        {
            System.out.printf("| %-9s| %-14s| %-11s| %-10s|\n", i,f.getName(),f.getOrigin(),f.getPrice());
            System.out.println("|----------|---------------|------------|-----------|"); 
            i++;
        }
    }
    
    public void ViewOrder()
    {
        double total = 0;  
        Hashtable<String, List<Fruit>> viewOrder = order.getOrder();
        if (viewOrder.isEmpty())
        {
            System.out.println("Empty");
        }
        else 
        {
            for ( String customerName : viewOrder.keySet())
            {  
                System.out.println();
                System.out.println("Customer : " + customerName);
                System.out.println("Product | Quantity | Price | Amount");
                for ( Fruit f : viewOrder.get(customerName))
                {
                    System.out.printf("%-7s | %-8s | %-6s | %-6s", f.getName(),f.getQuantity2(),f.getPrice(),f.getAmount());
                    System.out.println();
                    total += f.getAmount();
                }
                fm.WriteOrderList(viewOrder.get(customerName));
            }
            System.out.println();
            System.out.println("Total : "+ total);
            System.out.println();
            
        }
    }
    
    public void InputFruitName(List<Fruit> lff,List<Fruit> list)
    {
        int flag = 0;
        do 
        {
        System.out.println("Your selected : ");
        String s = sc.next();
        Predicate<Fruit> pf = (Fruit p) -> p.getName().equalsIgnoreCase(s);
        for ( Fruit f : list)
        {
            if ( pf.test(f))
            {
                flag = 1;
                lff.add(f);
            }        
        }
        if ( flag == 0)
        {
            System.out.println("Your selected not exist");
        }
        } while (flag == 0);
    }
    
    public void InputFruitQuantity(List<Fruit> lff)
    {
        int flag =0;
        do{
            try{
        System.out.println("Quatity of fruit you want to buy : ");
        int q = sc.nextInt();
        for ( Fruit f : lff)
        {
            if ( q > f.getQuantity1())
            {
                System.out.println("Beyond the quantity existed, you just order quantity less than "+f.getQuantity1());
                flag = 0;
            }
            else
            {
                f.setQuantity2(q);
                flag = 1;
            }
        }
            }catch (InputMismatchException e)
            {
                System.out.println("Quantity must be an integer");
                sc.nextLine();
                flag = 0;
            }
        } while (flag == 0);
    }
    
}
 

