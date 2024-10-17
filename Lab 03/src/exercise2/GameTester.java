package exercise2;

//abstract class
abstract class GameTester {
    protected String name; //name of game tester
    protected boolean isFullTime; //true if full-time and false if part-time

    // Constructor
    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    //abstract method to calculate salary
    public abstract double determineSalary();

    //method to display information
    public void displayInfo() {
        System.out.println("Game Tester Name: " + name);
        System.out.println("Full-Time: " + (isFullTime ? "Yes" : "No"));
    }
}
