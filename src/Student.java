// src/Student.java
public class Student {
    private String rollNumber;
    private String name;
    private String branch;
    private int semester;

    public Student(String rollNumber, String name, String branch, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return rollNumber + " - " + name + " - " + branch + " - Sem " + semester;
    }
}
