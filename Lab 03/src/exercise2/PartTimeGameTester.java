package exercise2;

// subclass
class PartTimeGameTester extends GameTester {
    private int hoursWorked; //number of hours

    // Constructor
    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false); //for part-time status it's false
        this.hoursWorked = hoursWorked; //sets the hours worked
    }

    //method to determine the salary
    @Override
    public double determineSalary() {
        return hoursWorked * 20; //part time gamer earns $20 per hour
    }

    //method to display part time tester details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Salary: $" + determineSalary());
    }
}
