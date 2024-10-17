package exercise2;

import java.util.Scanner;

public class MainGameTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input for game tester's name
        System.out.println("Enter the game tester's name:");
        String name = scanner.nextLine();

        //inpu to choose between full-time or part-time
        System.out.println("Is the game tester full-time or part-time?");
        System.out.println("Enter 1 for Full-Time, 2 for Part-Time:");
        int choice = scanner.nextInt();

        GameTester gameTester;

        if (choice == 1) {
            //creates a full-time game tester
            gameTester = new FullTimeGameTester(name);
        } else {
            //input for number of hours worked by the part time tester
            System.out.println("Enter the number of hours worked by part time tester:");
            int hoursWorked = scanner.nextInt();

            //creates a part-time game tester
            gameTester = new PartTimeGameTester(name, hoursWorked);
        }

        //display game tester information
        System.out.println("\nGame Tester Information:");
        gameTester.displayInfo();

        //closes the scanner
        scanner.close();
    }
}
