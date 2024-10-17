package exercise1;

import java.util.Scanner;

//exercise 1
public class MainInsurance {
    public static void main(String[] args) {
        //creates a Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        //creates an array to store insurance objects like health or life
        Insurance[] insuranceArray = new Insurance[2];

        //input for user to get cost of health insurance
        System.out.println("Enter the monthly cost for Health Insurance:");
        double healthCost = scanner.nextDouble();


        Insurance healthInsurance = new Health(); //creates health object
        healthInsurance.setInsuranceCost(healthCost); //sets the cost

        //input for user to get cost of life insurance
        System.out.println("Enter the monthly cost for Life Insurance:");
        double lifeCost = scanner.nextDouble();


        Insurance lifeInsurance = new Life(); // creates life object
        lifeInsurance.setInsuranceCost(lifeCost); //set the cost

        //stores both objects in the array
        insuranceArray[0] = healthInsurance;
        insuranceArray[1] = lifeInsurance;

        // Displays insurance information
        System.out.println("\nInsurance Information:");
        for (Insurance insurance : insuranceArray) {
            insurance.displayInfo(); //calls the displayInfo method (polymorphism)
            System.out.println("               ");
        }

        //closes the scanner
        scanner.close();
    }
}
