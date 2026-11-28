public class Average {
    public static double average(int[] marks) {
        int sum = 0;
        for (int i = 0; i <= marks.length - 1; i++) { // FAULT
            sum += marks[i];
        }
        return (double) sum / marks.length;
    }
    public static void main(String[] args) {
        int[] marks = {60, 70, 80};
        System.out.println("Average = " + average(marks));
    }
}
