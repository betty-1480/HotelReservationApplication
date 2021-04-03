package model;

import java.util.Objects;

public class Room implements IRoom, Comparable<Room> {
    private String roomNumber;
    private Double price;
    private RoomType roomType;

     Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Double getRoomPrice(){
        return price;
    }

    public RoomType getRoomType(){
        return roomType;
    }

    public boolean isFree(){
         return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
    public int compareTo(Room o) {
        return roomNumber.compareTo(o.roomNumber);
    }

}
