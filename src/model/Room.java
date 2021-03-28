package model;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType roomType;

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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

}
