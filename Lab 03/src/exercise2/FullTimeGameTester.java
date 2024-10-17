package exercise2;

//subclass
class FullTimeGameTester extends GameTester {

    //constructor
    public FullTimeGameTester(String name) {
        super(name, true); // full-time status it passes as true
    }

    //method to determine the salary
    @Override
    public double determineSalary() {
        return 3000; //full time gamers get $3000 fixed salary
    }

    //method to display full time tester details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: $" + determineSalary());
    }
}
