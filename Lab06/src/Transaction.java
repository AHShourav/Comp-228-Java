//represents a transaction (deposit or withdraw)
public class Transaction implements Runnable {
    private final Account account;
    private final double amount;
    private final boolean isDeposit; //true for deposit, false for withdrawal

    //initialize transaction with details
    public Transaction(Account account, double amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    //run transaction (executes in a thread)
    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount); //perform deposit
        } else {
            account.withdraw(amount); //perform withdrawal
        }
    }
}
