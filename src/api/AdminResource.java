package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AdminResource {

   private CustomerService customerService=CustomerService.getInstance();

   private AdminResource(){}  //Singleton Step1: a private constructor

   private static final AdminResource adminResource=new AdminResource(); //Singleton Step2: private static instance member

   public static AdminResource getInstance(){  //Singleton Step3: public static getInstance Method
       return adminResource;
   }

    public ArrayList<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    public void addRoom(List<IRoom> room){

    }

    public void addRoom(IRoom iRoom){
        customerService.addARoom(iRoom);
    }

    public ArrayList<IRoom> getAllFreeRooms(){
        return customerService.displayFreeRooms();
    }

    public void displayAllReservations(){
        ReservationService.printAllReservations();
    }

    public Collection<IRoom> getAllRooms(){
        return customerService.printAllRooms();
    }
}
