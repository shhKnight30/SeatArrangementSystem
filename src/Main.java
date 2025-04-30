// src/Main.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== College Seating Arrangement System ====");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n1. Login\n2. Register\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (choice == 1) {
                if (Admin.login(username, password)) {
                    System.out.println("Login successful!");
                    loggedIn = true;
                    // Proceed to next menu
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (choice == 2) {
                if (Admin.register(username, password)) {
                    System.out.println("Registration successful. You can now login.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                return;
            } else {
                System.out.println("Invalid option.");
            }
        }
        // TO DO: Call next functions like loading students and rooms
        // Add after admin login
        System.out.print("\nEnter path to students CSV file (e.g., data/students.csv): ");
        String studentFile = scanner.nextLine();
        List<Student> students = FileHandler.loadStudents(studentFile);
        System.out.println("Loaded " + students.size() + " students.");

        System.out.print("Enter path to rooms CSV file (e.g., data/rooms.csv): ");
        String roomFile = scanner.nextLine();
        List<Room> rooms = FileHandler.loadRooms(roomFile);
        System.out.println("Loaded " + rooms.size() + " rooms.");

        // Step 3: Seating preference
        System.out.println("\nChoose seating preference:");
        System.out.println("1. One student per bench");
        System.out.println("2. Two students per bench");
        int seatingChoice;
        do {
            System.out.print("Enter 1 or 2: ");
            seatingChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } while (seatingChoice != 1 && seatingChoice != 2);

        int studentsPerBench = seatingChoice;
        System.out.println("Selected: " + studentsPerBench + " student(s) per bench.");

        // Step 3: Select rooms
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println((i + 1) + ". " + rooms.get(i));
        }

        System.out.println("Enter room numbers to use (comma-separated, e.g., 1,3):");
        String roomSelection = scanner.nextLine();
        String[] selectedIndexes = roomSelection.split(",");

        List<Room> selectedRooms = new ArrayList<>();
        for (String indexStr : selectedIndexes) {
            try {
                int idx = Integer.parseInt(indexStr.trim()) - 1;
                if (idx >= 0 && idx < rooms.size()) {
                    selectedRooms.add(rooms.get(idx));
                } else {
                    System.out.println("Invalid room index: " + (idx + 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + indexStr);
            }
        }

        System.out.println("Selected rooms:");
        for (Room room : selectedRooms) {
            System.out.println("✔ " + room);
        }
        // Add this after selecting rooms and studentsPerBench:
        System.out.println("\nStarting seat allocation...");
        Map<String, String[][]> seatingPlan = SeatAllocator.allocateSeats(students, selectedRooms, studentsPerBench);

        // Show a preview in console (optional)
        for (String roomId : seatingPlan.keySet()) {
            System.out.println("\nRoom: " + roomId);
            String[][] seats = seatingPlan.get(roomId);
            for (String[] row : seats) {
                for (String seat : row) {
                    System.out.print((seat == null ? "--" : seat) + "\t");
                }
                System.out.println();
            }
        }
        // System.out.print("\nEnter path to save the PDF (e.g., output/SeatingPlan.pdf): ");
        // String pdfPath = scanner.nextLine();
        PDFGenerator.generatePDF(seatingPlan, "./output/output.pdf");

    }
}
