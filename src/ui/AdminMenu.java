package ui;

import api.AdminResource;
import com.sun.tools.javac.Main;
import model.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class AdminMenu extends AdminResource {
    private static boolean exit=false;

     void displayAdminMenu() throws ParseException {
         MainMenu mainMenu;
         while (!exit){
             Scanner scanner= new Scanner(System.in);
             System.out.println("--------------------------");
             System.out.println(" 1. See all Customers");
             System.out.println(" 2. See all Rooms");
             System.out.println(" 3. See all Reservations");
             System.out.println(" 4. Add a Room");
             System.out.println(" 5. Back to Main Menu");
             System.out.println("--------------------------");
             System.out.println("Enter your option:");
             int selection= Integer.parseInt(scanner.nextLine());
             if (selection==1){
                 ArrayList<Customer> customers= getCustomers();
                 for (Customer customer:customers){
                     System.out.println(customer.toString());
                 }
             }
             else if (selection==2){
                for (IRoom iRoom:printAllRooms())
                    System.out.println(iRoom);
             }
             else if(selection==3){
                 displayAllReservations();
             }
             else if(selection==4){
                 IRoom iRoom;
                 System.out.println("Enter Room Number:");
                 String roomNumber=scanner.nextLine();
                 System.out.println("Enter Price of the Room:");
                 Double price=Double.parseDouble(scanner.nextLine());
                 System.out.println("Single Room or Double Room:");
                 String roomType=scanner.nextLine();
                 if (roomType.toUpperCase().contains("SINGLE")){
                     iRoom=new FreeRoom(roomNumber,price,RoomType.SINGLE);
                     addRoom(iRoom);
                 }
                 else if (roomType.toUpperCase().contains("DOUBLE")){
                     iRoom=new FreeRoom(roomNumber,price,RoomType.DOUBLE);
                     addRoom(iRoom);
                 }
                 else
                     System.out.println("Invalid Room Type!");
             }
             else if (selection==5){
                 mainMenu =new MainMenu();
                 mainMenu.displayMainMenu();
                 exit=true;
             }
         }
    }
}
