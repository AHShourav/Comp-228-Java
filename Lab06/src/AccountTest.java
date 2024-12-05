
//main class

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//test class to simulate multiple transactions
public class AccountTest {
    public static void main(String[] args) {
        //creates an account with initial balance
        Account account = new Account(350.00);

        // create a list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, 200.00, true));  // deposit
        transactions.add(new Transaction(account, 150.00, false)); // withdraw
        transactions.add(new Transaction(account, 600.00, true));  // deposit
        transactions.add(new Transaction(account, 350.00, false));  // withdraw

        //creates an executor service with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //executes each transaction
        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }

        //shutdown executor and wait for tasks to finish
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        //displays final balance
        System.out.printf("Final Balance: $%.2f%n", account.getBalance());
    }
}
