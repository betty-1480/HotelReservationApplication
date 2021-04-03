package model;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, price, roomType);
    }

    @Override
    public boolean isFree() {
        return true;
    }

}
