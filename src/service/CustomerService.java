package service;

import model.Customer;
import model.IRoom;
import model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private  String firstName;
    private  String lastName;
    private  String email;
    private static ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
    private static ArrayList<Room> roomArrayList=new ArrayList<Room>();

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer=new Customer(firstName,lastName,email);
        customerArrayList.add(customer);
    }

/*    public Customer getCustomer(String customerEmail){

    }*/

   public ArrayList<Customer> getAllCustomers(){
        return customerArrayList;
    }

    public void addARoom(Room room){
       roomArrayList.add(room);
    }

    public ArrayList<Room> displayAllRooms(){
        return roomArrayList;
    }
}
