// src/SeatAllocator.java
import java.util.*;

public class SeatAllocator {

    public static Map<String, String[][]> allocateSeats(
            List<Student> students,
            List<Room> rooms,
            int studentsPerBench
    ) {
        Map<String, String[][]> roomSeatingMap = new LinkedHashMap<>();

        int studentIndex = 0;
        for (Room room : rooms) {
            int rows = room.getRows();
            int cols = room.getCols();
            String[][] seating = new String[rows][cols];

            for (int i = 0; i < rows && studentIndex < students.size(); i++) {
                for (int j = 0; j < cols && studentIndex < students.size(); j++) {
                    String seatInfo = "";
                    for (int k = 0; k < studentsPerBench && studentIndex < students.size(); k++) {
                        Student s = students.get(studentIndex++);
                        seatInfo += s.getRollNumber();
                        if (k == 0 && studentsPerBench == 2 && studentIndex < students.size()) {
                            seatInfo += "/";
                        }
                    }
                    seating[i][j] = seatInfo;
                }
            }
            roomSeatingMap.put(room.getRoomId(), seating);
        }

        if (studentIndex < students.size()) {
            System.out.println("⚠ Warning: Not all students could be seated due to room capacity.");
        } else {
            System.out.println("✅ All students seated.");
        }

        return roomSeatingMap;
    }
}
