
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student name
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        // Get number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Declare variables to store subject names and marks
        String[] subjectNames = new String[numSubjects];
        int[] subjectMarks = new int[numSubjects];

        // Get subject names and marks
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            subjectNames[i] = scanner.next();
            System.out.print("Enter marks for " + subjectNames[i] + ": ");
            subjectMarks[i] = scanner.nextInt();
        }

        // Calculate total marks and average percentage
        int totalMarks = 0;
        for (int mark : subjectMarks) {
            totalMarks += mark;
        }
        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        // Determine letter grade based on average percentage
        String Grade;
        if (averagePercentage >= 90) {
            Grade = "A";
        } else if (averagePercentage >= 80) {
            Grade = "B";
        } else if (averagePercentage >= 70) {
            Grade = "C";
        } else if (averagePercentage >= 60) {
            Grade = "D";
        } else {
            Grade = "F";
        }

        // Display results
        System.out.println("\nStudent Name: " + studentName);
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjectNames[i] + " Marks: " + subjectMarks[i]);
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Letter Grade: " + Grade);

        scanner.close();
    }
}