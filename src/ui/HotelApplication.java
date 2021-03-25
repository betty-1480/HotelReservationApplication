package ui;

import java.util.Scanner;

public class HotelApplication {
    public static void main(String ...args){
        System.out.println("Welcome to Hotel Reservation Application");
        try{
            MainMenu.displayMainMenu();
        }catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}
