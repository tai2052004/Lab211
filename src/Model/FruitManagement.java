/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Admin
 */
public class FruitManagement extends Fruit 
{

    Validation v = new Validation();
    Scanner sc = new Scanner(System.in);
    FileManager fm = new FileManager();
    
    public void FruitManagement(){
        
    }
    
    public boolean isEmptyProduct(List<Fruit> list)
    {
        if ( list.isEmpty())
            return true;  
        return false;
    }
    
    public List<Fruit> addFruit(List<Fruit> list) throws IOException
    {

        boolean cont;
       String FruitName, FruitOrigin;
       int FruitId = 0, flag = 1;
       double FruitPrice =0;
       int FruitQuantity = 0;
       do {
       List<Fruit> listSaveToFile = new ArrayList<>();
       cont = false;
       
       FruitId = InputFruitId(list);
       FruitName = InputFruitName();
       FruitPrice = InputFruitPrice();
       FruitQuantity = InputFruitQuantity();
       FruitOrigin = InputFruitOrigin();
       
          for ( Fruit f : list)
       {
           if (f.getName().equalsIgnoreCase(FruitName))
           {
               f.setQuantity1(FruitQuantity+f.getQuantity1());
               fm.UpdateFruitList(list);
               flag = 0;
           }
       }
          if ( flag == 1)
          {
              listSaveToFile.add(new Fruit(FruitId,FruitName,FruitPrice,FruitQuantity,FruitOrigin));
              list.add(new Fruit(FruitId,FruitName,FruitPrice,FruitQuantity,FruitOrigin));
              fm.WriteFruitList(listSaveToFile);
              System.out.println("Add succesfull !");
          }
          
          String pattern = "^[YN]$";
           
           System.out.println("Do you want to keep creating fruit? (Y/N)");
           String a = sc.next();
           if ( a.equalsIgnoreCase("Y"))
           {
               cont = true;
           }
           
       } while(cont);
       
       return list;
    }
    
    public int InputFruitId(List<Fruit> list)
    {
        int FruitId = 0;
        boolean cont;
        do{   
       try{
           
           System.out.println("Enter fruit id : ");
           
           FruitId = sc.nextInt();
           cont = false;
           for ( Fruit f : list)
           {
               if ( f.getId() == FruitId)
               {
                   System.out.println("id existed");
                   cont = true;
               }
           }
           if ( FruitId <= 0)
           {
               System.out.println("Fruit Id must be greater than 0");
               cont = true;
           }
       } catch ( InputMismatchException e){
           System.out.println("Id must be an integer");
           sc.nextLine();
           cont = true;
       }
       }while (cont);
        
        return FruitId;
    }
    
    public String InputFruitName()
    {
       System.out.println("Enter fruit Name : ");
       String fn = sc.next();
       
       return fn;
    }
    
    public double InputFruitPrice()
    {
        double fp = 0;
        boolean cont;
        do{
           try{
           System.out.println("Enter fruit price : ");
           fp = sc.nextDouble();
           cont = false;
           if ( fp <= 0)
           {
               System.out.println("Fruit price must be greater than 0");
               cont = true;
           }
           } catch (InputMismatchException e)
           {
               System.out.println("Fruit price must be numerical type");
               cont = true;
           }
           
       } while(cont);
        
        return fp;
    }
    
    public int InputFruitQuantity()
    {
        int fq=0;
        boolean cont;
        do{
           try{
           System.out.println("Enter fruit quantity : ");
           fq = Integer.parseInt(sc.next());
           cont = false;
           if ( fq <= 0)
           {
               System.out.println("Fruit Quantity must be greater than 0");
               cont = true;
           }
           } catch (NumberFormatException e)
           {
               System.out.println("Fruit price must be numerical value");
               cont = true;
           }
       } while(cont);
        
        return fq;
    }
    
    public String InputFruitOrigin()
    {
       System.out.println("Enter the origin of fruit : ");
       String fo = sc.next();
       return fo;
    }
}
