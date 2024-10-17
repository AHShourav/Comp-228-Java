package exercise1;

//exercise 1
//life class extends inherits from Insurance
class Life extends Insurance {

    // Constructor
    public Life() {
        super("Life Insurance");
    }

    //method to set the cost of life insurance
    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost; //sets monthly cost of life insurance
    }

    //method to display life insurance details
    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + insuranceType);
        System.out.println("Monthly Cost: $" + monthlyCost);
    }
}
