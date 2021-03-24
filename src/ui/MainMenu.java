package ui;

import java.util.Scanner;

/**
 * Scanner class can be used to read input from the console.
 * Scanner class can also use RegEx to parse console input.
 * It parses primitive types and String types into tokens.
 */
class MainMenu {
    static void displayMainMenu(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("1. Find a reserve room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("----------------------");
        System.out.println("Enter your option:");
        int selection= Integer.parseInt(scanner.nextLine());

        if (selection==3){

        }

    }
}
