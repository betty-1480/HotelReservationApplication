package service;

import model.Customer;
import model.IRoom;
import model.Room;

import java.util.*;

public class CustomerService {

    private static ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
    private static Map<String,Customer> customerMap=new HashMap<String, Customer>();

    static ArrayList<IRoom> iFreeRoomArrayList=new ArrayList<IRoom>();
    static Map<String,IRoom> iFreeRoomMap=new HashMap<String, IRoom>();
    static Map<String, IRoom> iRoomMap=new HashMap<>();

    private CustomerService(){} //Singleton Step1: a private constructor

    private static final CustomerService customerService=new CustomerService(); //Singleton Step2: private static instance member

    public static CustomerService getInstance(){ //Singleton Step3: public static getInstance Method
        return customerService;
    }

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
        iFreeRoomArrayList.add(iRoom);
        iFreeRoomMap.put(iRoom.getRoomNumber(),iRoom);
    }

    public  ArrayList<IRoom> displayFreeRooms(){
        return iFreeRoomArrayList;
    }

    public Collection<IRoom> printAllRooms(){
        List<IRoom> allRooms=new ArrayList<IRoom>();
        allRooms.addAll(iRoomMap.values());
        allRooms.addAll(iFreeRoomMap.values());
        Collections.sort(allRooms);

        return allRooms;
    }
}
