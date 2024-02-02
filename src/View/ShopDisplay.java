/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.ShopManager;
import Model.FileManager;
import Model.Fruit;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class ShopDisplay extends Menu{
    ShopManager sm = new ShopManager();
    Scanner sc = new Scanner(System.in);
    List<Fruit> listFruit = new ArrayList<>();
    FileManager fileM = new FileManager();
    
    public ShopDisplay(){
        super("Fruit Shop",new String[] {"Create Fruit","View Order","Shopping (for buyer)","Display Fruit","Exit"});
    }
    @Override
    public void execute(int ch) 
    {
        boolean cont = false;
        try {
            listFruit = fileM.ReadFruitList();
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        do{
            switch (ch)
            {
                case 1 : 
                {
                 try {
                    sm.CreateFruit(listFruit);
                } catch (IOException ex) {
                    Logger.getLogger(ShopDisplay.class.getName()).log(Level.SEVERE, null, ex);
                }
   
                }
                    break;

                
                case 2 :
                {
                    try {
                        sm.ViewOrder();
                    } catch (IOException ex) {
                        Logger.getLogger(ShopDisplay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                
                case 3 : 
                {
                    try {
                        sm.Shopping(listFruit);
                    } catch (IOException ex) {
                        Logger.getLogger(ShopDisplay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                    
                case 4 :
                {
                try {
                    sm.DisplayFruit(listFruit);
                } catch (IOException ex) {
                    Logger.getLogger(ShopDisplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                    break;
    
                case 5 :
                    break;
                
                default :
                    break;
                    
            }
            do {
                try{
                System.out.println("Your choice : ");
                ch = Integer.parseInt(sc.next());
                cont = false;
                }catch (NumberFormatException e)
                {
                    System.out.println("Your choice must be an integer from 1 to 5");
                    cont = true;
                }
            } while(cont);
        } while(ch >= 1 && ch <= 4);
    }
    public static void main(String[] args) {
        ShopDisplay fd = new ShopDisplay();
        fd.run();
    }

    
}
