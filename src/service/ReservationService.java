package service;


import api.HotelReservationResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    public static ArrayList<Reservation> reservationArrayList=new ArrayList<>();

    public void addRoom(Room room){

    }

    public Customer getCustomer(String email){
       return CustomerService.getCustomer(email);
    }

    public IRoom getARoom(String roomId){
       return CustomerService.iRoomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom iRoom, Date checkIn, Date checkOut){
       Reservation reservation = new Reservation(customer,iRoom,checkIn,checkOut);
        reservationArrayList.add(reservation);
       return reservation;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return CustomerService.iRoomArrayList;
    }

}
