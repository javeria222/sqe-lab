public class scholarshipPath {
    public static int calculateLateFee(int daysLate){
        int fee;
        if(daysLate <= 0) fee=0;
        else if(daysLate <= 7) fee= daysLate * 10;
        else fee = 70 + daysLate * 10;
        return fee;
    }
}
