package service;

import model.Customer;
import model.IRoom;
import model.Room;

import java.util.*;

public class CustomerService {

    private  String firstName;
    private  String lastName;
    private  String email;

    private static ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
    private static Map<String,Customer> customerMap=new HashMap<String, Customer>();

    static ArrayList<IRoom> iFreeRoomArrayList=new ArrayList<IRoom>();
    static Map<String,IRoom> iFreeRoomMap=new HashMap<String, IRoom>();
    static Map<String, IRoom> iRoomMap=new HashMap<>();

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer=new Customer(firstName,lastName,email);
        customerArrayList.add(customer);
        customerMap.put(email,customer);
    }

    public static Customer getCustomer(String customerEmail){
        return customerMap.get(customerEmail);
    }

    protected ArrayList<Customer> getAllCustomers(){
        return customerArrayList;
    }

    protected void addARoom(IRoom iRoom){
        iFreeRoomArrayList.add(iRoom);
        iFreeRoomMap.put(iRoom.getRoomNumber(),iRoom);
    }

    protected static ArrayList<IRoom> displayFreeRooms(){
        return iFreeRoomArrayList;
    }

    protected Collection<IRoom> printAllRooms(){
        List<IRoom> allRooms=new ArrayList<IRoom>();
        allRooms.addAll(iRoomMap.values());
        allRooms.addAll(iFreeRoomMap.values());
        Collections.sort(allRooms);

        return allRooms;
    }
}
