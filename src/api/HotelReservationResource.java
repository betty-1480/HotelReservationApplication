package api;

import model.Customer;
import service.CustomerService;
import service.ReservationService;

public class HotelReservationResource extends ReservationService {

    CustomerService customerService=new CustomerService();
/*
    public Customer getCustomer(String email){

    }
*/

    public void  createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email,firstName,lastName);
    }
}
