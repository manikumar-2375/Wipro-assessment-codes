package springqns;

public class AccountQ4 {
    private int number;
    private String holder;
    private double balance;
    private String type;

    // Getters and Setters
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getHolder() { return holder; }
    public void setHolder(String holder) { this.holder = holder; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public void display() {
        System.out.println("Account Number: " + number);
        System.out.println("Account Holder: " + holder);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Type: " + type);
    }
}
