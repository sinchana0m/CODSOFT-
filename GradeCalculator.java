import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of subjects: "); //input the number of subjects
            int n = sc.nextInt();
            if (n < 1) {
                System.out.println("Invalid number of subjects. Please enter a positive number.");
                return;
            }
            int[] marks = new int[n];
            //  input  marks for each subject
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the marks for subject " + (i + 1) + " out of 100: ");
                marks[i] = sc.nextInt();
                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Invalid marks for subject " + (i + 1) +"");
                    return;
                }
            }
            // Calculate the total marks and the average percentage
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            double average = (double) total / n;
            String grade;
            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B+";
            } else if (average >= 60) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C+";
            } else if (average >= 40) {
                grade = "C";
            } else {
                grade = "F";
            }
            System.out.println("Total marks: " + total);
            System.out.println("Average percentage: " + average + "%"); //display the output
            System.out.println("Grade: " + grade);
            sc.close();
        }
    }
}
