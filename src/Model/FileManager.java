/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class FileManager {
   public String FruitPath = "Data.txt";
   public String OrderPath = "Order.txt";
   int lastReadPosition = 0;
   
   public void WriteFruitList(List<Fruit> list)
   {
       try ( FileWriter fw = new FileWriter(FruitPath,true);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Fruit f : list)
           {
               bw.write(f.getId()+","+f.getName()+","+f.getPrice()+","+f.getQuantity1()+","+f.getOrigin());
               bw.newLine();
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
   
   public List<Fruit> ReadFruitList() throws FileNotFoundException, IOException
   {
       List<Fruit> ReadFromFile = new ArrayList<>();
       String line;
       try(BufferedReader br = new BufferedReader(new FileReader(FruitPath)))
       {
           if (lastReadPosition > 0) {
                br.skip(lastReadPosition); 
            }
          while ( (line = br.readLine()) != null)
          {
              String [] larr  = line.split(",");
              ReadFromFile.add(new Fruit(Integer.parseInt(larr[0].trim()), larr[1].trim(), Double.parseDouble(larr[2].trim()), Integer.parseInt(larr[3].trim()),larr[4]));
              lastReadPosition += line.length() + System.lineSeparator().length();
          }
       } 
       saveLastReadPosition(lastReadPosition);
       return ReadFromFile;
   }
   
    public void WriteOrderList(List<Fruit> list)
   {
       try ( FileWriter fw = new FileWriter(OrderPath,true);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Fruit f : list)
           {
               bw.write(f.getCustomer()+","+f.getId()+","+f.getName()+","+f.getPrice()+","+f.getQuantity1()+","+f.getOrigin());
               bw.newLine();
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
   
   public List<Fruit> ReadOrderList() throws FileNotFoundException, IOException
   {
       List<Fruit> ReadFromFile = new ArrayList<>();
       String line;
       try(BufferedReader br = new BufferedReader(new FileReader(OrderPath)))
       {
          while ( (line = br.readLine()) != null)
          {
              String [] larr  = line.split(",");
              ReadFromFile.add(new Fruit(larr[0],Integer.parseInt(larr[1].trim()), larr[2].trim(), Double.parseDouble(larr[3].trim()), Integer.parseInt(larr[4].trim()),larr[5]));
          }
       } 
       return ReadFromFile;
   }
   
   public void UpdateFruitList(List<Fruit> list)
   {
       try ( FileWriter fw = new FileWriter(FruitPath);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Fruit f : list)
           {
               bw.write(f.getId()+","+f.getName()+","+f.getPrice()+","+f.getQuantity1()+","+f.getOrigin());
               bw.newLine();
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
   
   private void saveLastReadPosition(int position) {
        try (FileWriter fileWriter = new FileWriter("lastReadPosition.txt")) {
            fileWriter.write(String.valueOf(lastReadPosition));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
