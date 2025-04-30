// src/FileHandler.java
import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<Student> loadStudents(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String roll = parts[0].trim();
                    String name = parts[1].trim();
                    String branch = parts[2].trim();
                    int semester = Integer.parseInt(parts[3].trim());
                    students.add(new Student(roll, name, branch, semester));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }
        return students;
    }

    public static List<Room> loadRooms(String filePath) {
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    int rows = Integer.parseInt(parts[1].trim());
                    int cols = Integer.parseInt(parts[2].trim());
                    rooms.add(new Room(id, rows, cols));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading rooms file: " + e.getMessage());
        }
        return rooms;
    }
}
