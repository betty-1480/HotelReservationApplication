package ui;

import api.AdminResource;
import com.sun.tools.javac.Main;
import model.Customer;

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
                 ArrayList<Customer> customers= getAllCustomers();
                 System.out.println("Customer arrylist size:"+customers.size());
                 for (Customer customer:customers){
                     System.out.println(customer.toString());
                 }
             }
             else if (selection==5){
                 mainMenu =new MainMenu();
                 mainMenu.displayMainMenu();
                 exit=true;
             }
         }
    }
}
