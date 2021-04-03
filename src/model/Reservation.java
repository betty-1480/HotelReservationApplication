package model;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private int reservationId;
    private Customer customer;
    private IRoom iRoom;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom iRoom, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.iRoom = iRoom;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getiRoom() {
        return iRoom;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getReservationId(){
        return hashCode();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", iRoom=" + iRoom +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Reservation))
            return false;
        Reservation reservation = (Reservation) obj;
        return customer.getEmail().equalsIgnoreCase(reservation.customer.getEmail()) && iRoom.getRoomNumber().equalsIgnoreCase(reservation.iRoom.getRoomNumber()) && checkOutDate == reservation.checkOutDate && checkInDate == reservation.checkInDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iRoom.getRoomNumber(), checkInDate, checkOutDate);
    }
}
