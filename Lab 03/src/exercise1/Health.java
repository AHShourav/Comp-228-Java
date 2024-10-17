package exercise1;

//exercise 1
//health class extends and inherits from Insurance
class Health extends Insurance {

    //constructor calls the parent constructor to set the insurance type
    public Health() {
        super("Health Insurance");
    }

    //method to set the cost of health insurance
    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost; //sets the monthly cost for health insurance
    }

    //method to display health insurance details
    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + insuranceType);
        System.out.println("Monthly Cost: $" + monthlyCost);
    }
}
