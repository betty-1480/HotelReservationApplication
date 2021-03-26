package ui;

import api.AdminResource;
import api.HotelReservationResource;
import service.ReservationService;

import java.util.Scanner;

/**
 * Scanner class can be used to read input from the console.
 * Scanner class can also use RegEx to parse console input.
 * It parses primitive types and String types into tokens.
 */
class MainMenu extends HotelReservationResource {
    private static boolean exit=false;
     void displayMainMenu(){
         AdminMenu adminMenu=new AdminMenu();
        do{
            Scanner scanner= new Scanner(System.in);
            System.out.println("=======================");
            System.out.println("1. Find a reserve room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println("=======================");
            System.out.println("Enter your option:");
            int selection= Integer.parseInt(scanner.nextLine());
            if (selection==3){
                System.out.println("Enter first name:");
                String firstName=scanner.nextLine();
                System.out.println("Enter last name:");
                String lastName=scanner.nextLine();
                System.out.println("Enter email address:");
                String email=scanner.nextLine();
                createACustomer(email,firstName,lastName);
            }
            else if (selection==4){
                adminMenu.displayAdminMenu();
            }
            else if (selection==5)
                exit=true;
        }while (!exit);
    }
}
