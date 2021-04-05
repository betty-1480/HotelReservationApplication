package ui;

import api.AdminResource;
import api.HotelReservationResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * Scanner class can be used to read input from the console.
 * Scanner class can also use RegEx to parse console input.
 * It parses primitive types and String types into tokens.
 */
class MainMenu {
    private static HotelReservationResource hotelReservationResource=HotelReservationResource.getInstance();
    private static boolean exit=false;
     void displayMainMenu() throws ParseException {
         AdminMenu adminMenu=new AdminMenu();
        do{
            Scanner scanner= new Scanner(System.in);
            System.out.println("=======================");
            System.out.println("1. Create an account");
            System.out.println("2. Find and reserve a room");
            System.out.println("3. See my reservations");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println("=======================");
            System.out.println("Enter your option:");
            int selection= Integer.parseInt(scanner.nextLine());
            String email;
            switch (selection){
                case 1:
                    System.out.println("Enter first name:");
                    String firstName=scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName=scanner.nextLine();
                    System.out.println("Enter email address:");
                    email=scanner.nextLine();
                    hotelReservationResource.createACustomer(email,firstName,lastName);
                    break;
                case 2:
                    Customer customer;
                    IRoom roomToReserve;
                    Date checkIn, checkOut;
                    Reservation reservation;
                    Collection<IRoom> roomsToReserve;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Do you have an account with us (y (yes)/ n (no))?");
                    if (scanner.nextLine().equalsIgnoreCase("y")){
                        System.out.println("Enter your email address:");
                        customer=hotelReservationResource.getCustomer(scanner.nextLine());
                        Calendar calender = Calendar.getInstance();
                        Date date = new java.util.Date();
                        calender.setTime(date);
                        Date currentDate=calender.getTime();
                        do{
                            System.out.println("Enter Check In Date (dd/mm/yyyy):");
                            checkIn= format.parse(scanner.nextLine());
                            if (!checkIn.after(currentDate))
                                System.out.println("Issues fount with the checkin date, please verify and fix.");
                        }while(checkIn.before(currentDate));

                        do{
                            System.out.println("Enter Check Out Date (dd/mm/yyyy):");
                            checkOut= format.parse(scanner.nextLine());
                            if (!checkOut.after(currentDate)||!checkOut.before(checkIn)||checkIn.equals(checkOut))
                                System.out.println("Issues fount with the checkin date, please verify and fix.");
                        }while (checkOut.before(currentDate)||checkOut.before(checkIn)||checkIn.equals(checkOut));

                        roomsToReserve=hotelReservationResource.findARoom(checkIn,checkOut);
                        if(roomsToReserve.size()>0){
                            System.out.println("------------Available Rooms-------------");
                            for (IRoom iRoom:roomsToReserve)
                                System.out.println(iRoom);
                            System.out.println("----------------------------------------");
                            System.out.println("Enter Room Number to reserve:");
                            roomToReserve= hotelReservationResource.getRoom(scanner.nextLine());
                            reservation= hotelReservationResource.bookARoom(customer,roomToReserve,checkIn,checkOut);
                            System.out.println("Room Booked!!!");
                            System.out.println("ReservationNo:"+reservation.getReservationId());
                        }
                        else {
                            System.out.println("Currently there are no rooms available to book");
                        }
                    }
                    else if (scanner.nextLine().equalsIgnoreCase("n")){
                        System.out.println("Please create an account with us");
                    }
                    break;
                case 3:
                    System.out.println("Do you have an account with us (y (yes)/ n (no))?");
                    if (scanner.nextLine().equalsIgnoreCase("y")){
                        System.out.println("Enter your email address:");
                        email = scanner.nextLine();
                        System.out.println("All the reservations you made are listed below:");
                        for (Reservation myReservation:hotelReservationResource.getCustomersReservations(email)){
                            System.out.println(myReservation);
                        }
                    }
                    else if (scanner.nextLine().equalsIgnoreCase("n")){
                        System.out.println("Please create an account with us");
                    }
                    break;
                case 4:
                    adminMenu.displayAdminMenu();
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("Pick an option from the below menu!!");

            }

        }while (!exit);
    }
}
