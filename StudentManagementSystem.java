
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    listStudents();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("3. Remove Student");
        System.out.println("4. Search Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name;
        name = scanner.next();
        System.out.print("Enter student roll number: ");
        int rollNo = scanner.nextInt();

        Student student = new Student(name , rollNo);
        
        students.add(student);
        System.out.println("Student added successfully!");
        scanner.nextLine(); 
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\nStudent List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void removeStudent() {
        System.out.print("Enter student roll number to remove: ");
        int rollNo = scanner.nextInt();

        int studentIndex = findStudentIndex(rollNo);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        students.remove(studentIndex);
        System.out.println("Student removed successfully!");
        scanner.nextLine(); // Consume newline character after integer input
    }

    private static void searchStudent() {
        System.out.print("Enter student roll number to search: ");
        int rollNo = scanner.nextInt();

        int studentIndex = findStudentIndex(rollNo);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Student details:");
        System.out.println(students.get(studentIndex));
        scanner.nextLine(); // Consume newline character after integer input
    }

    private static int findStudentIndex(int rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == rollNo) {
                return i;
            }
        }
        return -1;
    }
}

class Student {

    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo;
    }
}