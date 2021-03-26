package api;

import model.Customer;
import service.ReservationService;

public class HotelReservationResource extends ReservationService {

AdminResource adminResource=new AdminResource();
/*
    public Customer getCustomer(String email){

    }
*/

    public void  createACustomer(String email, String firstName, String lastName){
        adminResource.addCustomer(email,firstName,lastName);
    }
}
