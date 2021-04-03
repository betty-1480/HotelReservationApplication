package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class HotelReservationResource extends ReservationService {

    private CustomerService customerService=new CustomerService();

    public Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public IRoom getRoom(String roomNumber){

        return getARoom(roomNumber);
    }

    public void  createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email,firstName,lastName);
    }

    public Reservation booARoom(Customer customer, IRoom iRoom, Date checkIn, Date checkOut){
            return reserveARoom(customer,iRoom,checkIn,checkOut);
    }

    public Collection<IRoom> findARoom(Date checkin, Date checkout){
        return findRooms(checkin, checkout);
    }

    public Collection<Reservation> getCustomersReservations(String emailId){
        Customer customer=getCustomer(emailId);
        return getCustomerReservations(customer);
    }

}
