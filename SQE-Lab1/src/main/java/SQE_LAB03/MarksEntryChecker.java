package SQE_LAB03;

import java.util.Scanner;

public class MarksEntryChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter marks: ");
        int marks = input.nextInt();
        if (marks > 0 && marks <= 100) {
            System.out.println("Valid marks");
        } else if (marks <= 0) {
            System.out.println("Invalid marks (minimum is 0)");
        } else {
            System.out.println("Invalid marks (maximum is 100)");
        }
    }
}
