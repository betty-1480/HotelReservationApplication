package ui;

import java.text.ParseException;
import java.util.Scanner;

public class HotelApplication  {
    public static void main(String ...args) throws ParseException {
        System.out.println("Welcome to Hotel Reservation Application");
        try{
            MainMenu mainMenu=new MainMenu();
            mainMenu.displayMainMenu();
        }catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
