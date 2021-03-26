package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private  String firstName;
    private  String lastName;
    private  String email;
    private final ArrayList<Customer> customerArrayList=new ArrayList<Customer>();

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer=new Customer(firstName,lastName,email);
        customerArrayList.add(customer);
    }

/*    public Customer getCustomer(String customerEmail){

    }*/

    public ArrayList<Customer> getAllCustomers(){
        return this.customerArrayList;
    }

}
