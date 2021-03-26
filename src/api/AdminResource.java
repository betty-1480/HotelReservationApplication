package api;

import model.Customer;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;

public class AdminResource extends CustomerService {

/*    public Customer getCustomer(String email){

    }*/

    public  ArrayList<Customer> getCustomers(){
        return getAllCustomers();
    }
}
