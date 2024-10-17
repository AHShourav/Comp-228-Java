package exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber; // Unique number for the mortgage
    protected String customerName;
    protected double mortgageAmount;
    protected double interestRate; //interest rate applied to mortgage
    protected int term; //term of mortgage

    //constructor that sets up the mortgage details
    public Mortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        //checks if mortgage amount is higher than allowed, throws error if its higher
        if (mortgageAmount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed $" + MAX_MORTGAGE_AMOUNT);
        }
        this.mortgageAmount = mortgageAmount;

        //if term is not 1, 3 or 5 years, sets it to 1 year (short-term)
        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
            this.term = SHORT_TERM;
        } else {
            this.term = term;
        }

        this.interestRate = interestRate; //sets the interest rate
    }

    //abstract method calculate total amount owed
    public abstract double calculateTotalOwed();

    //method to return mortgage details as string
    public String getMortgageInfo() {
        return "Mortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nMortgage Amount: $" + mortgageAmount +
                "\nInterest Rate: " + interestRate + "%" +
                "\nTerm: " + term + " years";
    }
}
