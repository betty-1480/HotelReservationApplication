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

public class AdminResource extends CustomerService {

    protected ArrayList<Customer> getCustomers(){
        return getAllCustomers();
    }

    public void addRoom(List<IRoom> room){

    }

    public void addRoom(IRoom iRoom){
            addARoom(iRoom);
    }

    public static ArrayList<IRoom> getAllFreeRooms(){
        return displayFreeRooms();
    }

    public void displayAllReservations(){
        ReservationService.printAllReservations();
    }

    public Collection<IRoom> getAllRooms(){
        return printAllRooms();
    }
}
