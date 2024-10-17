package exercise3;

public class PersonalMortgage extends Mortgage {
    //constructor adds 2% to the prime rate
    public PersonalMortgage(String mortgageNumber, String customerName, double mortgageAmount, double primeRate, int term) {
        super(mortgageNumber, customerName, mortgageAmount, primeRate + 2, term);
    }

    //calculates total amount owed, including interest
    @Override
    public double calculateTotalOwed() {
        return mortgageAmount + (mortgageAmount * interestRate * term / 100);
    }
}

