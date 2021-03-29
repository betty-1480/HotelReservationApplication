package model;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, price, roomType);
    }

    @Override
    public Double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getRoomNumber() {
        return super.getRoomNumber();
    }

    @Override
    public Double getRoomPrice() {
        return super.getRoomPrice();
    }

    @Override
    public RoomType getRoomType() {
        return super.getRoomType();
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
