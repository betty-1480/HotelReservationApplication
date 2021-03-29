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
    static ArrayList<IRoom> iRoomArrayList=new ArrayList<IRoom>();
    private static Map<String,Customer> customerMap=new HashMap<String, Customer>();
    static Map<String,IRoom> iRoomMap=new HashMap<String, IRoom>();

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer=new Customer(firstName,lastName,email);
        customerArrayList.add(customer);
        customerMap.put(email,customer);
    }

    public static Customer getCustomer(String customerEmail){
        return customerMap.get(customerEmail);
    }

   public ArrayList<Customer> getAllCustomers(){
        return customerArrayList;
    }

    public void addARoom(IRoom iRoom){
        iRoomArrayList.add(iRoom);
        iRoomMap.put(iRoom.getRoomNumber(),iRoom);
    }

    public static ArrayList<IRoom> displayAllRooms(){
        return iRoomArrayList;
    }
}
