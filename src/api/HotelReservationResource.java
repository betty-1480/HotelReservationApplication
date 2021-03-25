package api;

import model.Customer;
import service.ReservationService;

public class HotelReservationResource {

   private ReservationService reservationService = new ReservationService();

/*
    public Customer getCustomer(String email){

    }
*/

    public void createACustomer(String email, String firstName, String lastName){
        reservationService.addCustomer(email,firstName,lastName);
    }
}
