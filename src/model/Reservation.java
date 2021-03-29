package model;

import java.util.Collection;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom iRoom;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom iRoom, Date checkInDate, Date checkOutDate){
        this.customer=customer;
        this.iRoom=iRoom;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setiRoom(IRoom iRoom) {
        this.iRoom = iRoom;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
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
}
