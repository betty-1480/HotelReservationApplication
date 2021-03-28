package ui;

import api.AdminResource;
import com.sun.tools.javac.Main;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.Scanner;

class AdminMenu extends AdminResource {
    private static boolean exit=false;

     void displayAdminMenu(){
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
                ArrayList<Room> rooms=displayRooms();
                 for (Room room:rooms)
                     System.out.println(room.toString());
             }
             else if(selection==4){
                 Room room=new Room();
                 System.out.println("Enter Room Number:");
                 room.setRoomNumber(scanner.nextLine());
                 System.out.println("Enter Price of the Room:");
                 room.setPrice(Double.parseDouble(scanner.nextLine()));
                 System.out.println("Single Room or Double Room:");
                 String roomType=scanner.nextLine();
                 if (roomType.toUpperCase().contains("SINGLE"))
                        room.setRoomType(RoomType.SINGLE);
                 else if (roomType.toUpperCase().contains("DOUBLE"))
                     room.setRoomType(RoomType.DOUBLE);
                 addRoom(room);
             }
             else if (selection==5){
                 mainMenu =new MainMenu();
                 mainMenu.displayMainMenu();
                 exit=true;
             }
         }
    }
}
