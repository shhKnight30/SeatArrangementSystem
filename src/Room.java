// src/Room.java
public class Room {
    private String roomId;
    private int rows;
    private int cols;
    private int capacity;

    public Room(String roomId, int rows, int cols) {
        this.roomId = roomId;
        this.rows = rows;
        this.cols = cols;
        this.capacity = rows * cols;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return roomId + " [Rows: " + rows + ", Columns: " + cols + ", Capacity: " + capacity + "]";
    }
}
