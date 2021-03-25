package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private  String firstName;
    private  String lastName;
    private  String email;
    private ArrayList<Customer> customerArrayList=new ArrayList<Customer>();

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer=new Customer(firstName,lastName,email);
        customerArrayList.add(customer);
    }

/*    public Customer getCustomer(String customerEmail){

    }*/

/*    public Collections<Customer> getAllCustomers(){

    }*/

}
