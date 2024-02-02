/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */

import java.util.Scanner;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class Validation {

    public static String getString(String msg) {
        System.out.print(msg + " : ");
        return new Scanner(System.in).nextLine();
    }

    public static int getInt(String msg) {
        return Integer.parseInt(getString(msg));
    }

    public static boolean checkUserName(String input) {
        String regex = "^[a-zA-Z0-9]{6,}$";
        return input.matches(regex);
    }

    public static boolean checkValidPass(String input) {
        String regex = "^[a-zA-Z0-9]{6,}$";
        return input.matches(regex);
    }

    public static boolean checkNumber(String input) {
        String regex = "^-?+[0-9]+(?:\\.[0-9]+)?$";
        return input.matches(regex);
    }

    public static boolean checkIntNumber(String input) {
        String regex = "^-?+[0-9]*$";
        String regex1 = "^[0-9]+$";
        return input.matches(regex);
    }

    public static boolean checkValidDate(String input) {
        String regex = "^(?:19|20)\\d\\d-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01])$"; //YYYY-MM-DD
        return input.matches(regex);
    }

    public static boolean checkValidMail(String input) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return input.matches(regex);
    }

    public static boolean checkValidPhoneNum(String input) {
        String regex = "^\\+?[0-9]\\d{1,10}$";
        return input.matches(regex);
    }

    public static void main(String[] args) {
//        String name = "my name";
//        System.out.println("validate your name is " + checkValidName(name));
//        String date = "1803-09-20";
//        System.out.println("validate your date is " + checkValidDate(date));
//        String phoneNum = "0912000123";
//        System.out.println("validate your phone number is " + checkValidPhoneNum(phoneNum));
//        String num = "9.5";
//        System.out.println("validate your number is " + checkNumber(num));
//    
    }
}
