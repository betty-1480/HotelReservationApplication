package service;


import api.HotelReservationResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    private static ArrayList<Reservation> reservationArrayList=new ArrayList<>();

    public Customer getCustomer(String email){
       return CustomerService.getCustomer(email);
    }

    protected  IRoom getARoom(String roomId){
        if (CustomerService.iFreeRoomMap.get(roomId)!=null)
             return CustomerService.iFreeRoomMap.get(roomId);
        else
            return CustomerService.iRoomMap.get(roomId);
    }

    protected  Reservation reserveARoom(Customer customer, IRoom iRoom, Date checkIn, Date checkOut){
       Reservation reservation = new Reservation(customer,iRoom,checkIn,checkOut);

       if (CustomerService.iFreeRoomMap.containsKey(iRoom.getRoomNumber())){
           CustomerService.iFreeRoomMap.remove(iRoom.getRoomNumber(),iRoom);
           CustomerService.iFreeRoomArrayList.remove(iRoom);
       }
       CustomerService.iRoomMap.put(iRoom.getRoomNumber(),iRoom);
       reservationArrayList.add(reservation);

       return reservation;

    }

    protected static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Set<IRoom> freeRoomSet=new HashSet<>();
        for (Reservation reservation: reservationArrayList){
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
        for (Reservation reservation:reservationArrayList)
            System.out.println(reservation);
    }

    protected Collection<Reservation> getCustomerReservations(Customer customer){
        Collection<Reservation> myReservations=new ArrayList<>();
        for (Reservation reservation:reservationArrayList){
            if (reservation.getCustomer().getEmail().equals(customer.getEmail())){
                myReservations.add(reservation);
            }
        }

        return myReservations;
    }
}
