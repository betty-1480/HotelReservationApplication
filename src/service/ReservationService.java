package service;


import api.HotelReservationResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    private static Set<Reservation> reservationSet=new HashSet<>();

    private ReservationService(){} //Singleton Step1: a private constructor

    private static final ReservationService reservationService=new ReservationService(); //Singleton Step2: private static instance member

    public static ReservationService getInstance(){ //Singleton Step3: public static getInstance Method
        return reservationService;
    }


    public Customer getCustomer(String email){
       return CustomerService.getCustomer(email);
    }

    public IRoom getARoom(String roomId){
        if (CustomerService.iFreeRoomMap.get(roomId)!=null)
             return CustomerService.iFreeRoomMap.get(roomId);
        else
            return CustomerService.iRoomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom iRoom, Date checkIn, Date checkOut){
       Reservation reservation = new Reservation(customer,iRoom,checkIn,checkOut);

       if (CustomerService.iFreeRoomMap.containsKey(iRoom.getRoomNumber())){
           CustomerService.iFreeRoomMap.remove(iRoom.getRoomNumber(),iRoom);
           CustomerService.iFreeRoomArrayList.remove(iRoom);
       }
       CustomerService.iRoomMap.put(iRoom.getRoomNumber(),iRoom);
        reservationSet.add(reservation);

       return reservation;

    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Set<IRoom> freeRoomSet=new HashSet<>();
        for (Reservation reservation: reservationSet){
            Date checkin = reservation.getCheckInDate();
            Date checkout=reservation.getCheckOutDate();
            IRoom freeRoom;
            if (checkInDate.before(checkin)&&checkInDate.before(checkout)||checkInDate.after(checkin)&&checkOutDate.after(checkout)){
                freeRoom= reservation.getiRoom();
                freeRoomSet.add(freeRoom);
            }
        }
        freeRoomSet.addAll(CustomerService.iFreeRoomArrayList);
        return freeRoomSet;
    }

    public static void printAllReservations(){
        for (Reservation reservation:reservationSet)
            System.out.println(reservation);
    }

    public Collection<Reservation> getCustomerReservations(Customer customer){
        Collection<Reservation> myReservations=new ArrayList<>();
        for (Reservation reservation:reservationSet){
            if (reservation.getCustomer().getEmail().equals(customer.getEmail())){
                myReservations.add(reservation);
            }
        }

        return myReservations;
    }
}
