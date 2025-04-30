// src/Admin.java
import java.io.*;
import java.util.*;

public class Admin {
    private String username;
    private String password;
    private static final String ADMIN_FILE = "data/admins.csv";

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static boolean register(String username, String password) {
        if (adminExists(username)) {
            System.out.println("Admin already exists!");
            return false;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ADMIN_FILE, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to admin file.");
            return false;
        }
    }

    public static boolean login(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading admin file.");
        }
        return false;
    }

    private static boolean adminExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(username + ",")) {
                    return true;
                }
            }
        } catch (IOException e) {
            // File might not exist yet
        }
        return false;
    }
}
