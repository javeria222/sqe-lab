package SQE_lab5;

public class BankAccount {

    private String holder;
    private int balance;


    BankAccount(String holder, int openingBalance){
        this.holder = holder;
        this.balance = openingBalance;
    }

    public String getHolder(){
        return holder;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}
