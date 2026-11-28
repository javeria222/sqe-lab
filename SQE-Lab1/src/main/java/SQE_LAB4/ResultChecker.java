package SQE_LAB4;

public class ResultChecker {

    public static String getResult(int marks, int attendance) {
        String result; 
        if (attendance < 75) {
            result = "Not eligible";
        } else if (marks >= 80) {  
            result = "Distinction"; 
        } else if (marks >= 50) {  
            result = "Pass";        
        } else {
            result = "Fail";               
        }
        return result;                     
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ResultChecker.java <marks> <attendance>");
            return;
        }
        int marks = Integer.parseInt(args[0]);
        int attendance = Integer.parseInt(args[1]);
        System.out.println("Final result: " + getResult(marks, attendance));
    }
}
