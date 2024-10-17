package exercise3;


public class BusinessMortgage extends Mortgage {
    //constructor adds 1% to the prime rate
    public BusinessMortgage(String mortgageNumber, String customerName, double mortgageAmount, double primeRate, int term) {
        super(mortgageNumber, customerName, mortgageAmount, primeRate + 1, term);
    }

    //calculates total amount owed, including interest
    @Override
    public double calculateTotalOwed() {
        return mortgageAmount + (mortgageAmount * interestRate * term / 100);
    }
}


