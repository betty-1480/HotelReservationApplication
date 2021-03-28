package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class AdminResource extends CustomerService {

/*    public Customer getCustomer(String email){

    }*/

      protected ArrayList<Customer> getCustomers(){
        return getAllCustomers();
    }

    public void addRoom(List<IRoom> room){

    }

    public void addRoom(Room room){
            addARoom(room);
    }

    public ArrayList<Room> displayRooms(){
        return displayAllRooms();
    }

}
