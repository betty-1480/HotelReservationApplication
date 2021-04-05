package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class HotelReservationResource {

    private CustomerService customerService=CustomerService.getInstance();
    private ReservationService reservationService=ReservationService.getInstance();

    private HotelReservationResource(){} //Singleton Step1: a private constructor

    private static HotelReservationResource hotelReservationResource=new HotelReservationResource(); //Singleton Step2: private static instance member

    public static HotelReservationResource getInstance() { //Singleton Step3: public static getInstance Method
        return hotelReservationResource;
    }

    public Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public IRoom getRoom(String roomNumber){

        return reservationService.getARoom(roomNumber);
    }

    public void  createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email,firstName,lastName);
    }

    public Reservation bookARoom(Customer customer, IRoom iRoom, Date checkIn, Date checkOut){
            return reservationService.reserveARoom(customer,iRoom,checkIn,checkOut);
    }

    public Collection<IRoom> findARoom(Date checkin, Date checkout){
        return reservationService.findRooms(checkin, checkout);
    }

    public Collection<Reservation> getCustomersReservations(String emailId){
        Customer customer=getCustomer(emailId);
        return reservationService.getCustomerReservations(customer);
    }

}
