//represents a bank account with deposit and withdrawal methods
public class Account {
    private double balance; // account balance

    //initialize account with starting balance
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    //deposit money (synchronized for thread safety)
    public synchronized void deposit(double amount) {
        if (amount > 0) { //checks if amount is positive
            balance += amount;
            System.out.printf("Deposited: $%.2f | Current Balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    //withdraw money (synchronized for thread operations)
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) { //checks if balance is enough
            balance -= amount;
            System.out.printf("Withdrew: $%.2f | Current Balance: $%.2f%n", amount, balance);
        } else if (amount > 0) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    //gets current balance
    public synchronized double getBalance() {
        return balance;
    }
}
