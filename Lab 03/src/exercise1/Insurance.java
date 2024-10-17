package exercise1;

//exercise 1
//abstract class insurance
abstract class Insurance {
    //variable to store
    protected String insuranceType;
    protected double monthlyCost;

    //constructor
    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    //method to getinsurance type
    public String getInsuranceType() {
        return insuranceType;
    }

    //method to get
    public double getMonthlyCost() {
        return monthlyCost;
    }

    //abstract method to set the cost of insurance
    public abstract void setInsuranceCost(double cost);

    //abstract method to display insurance info
    public abstract void displayInfo();
}
