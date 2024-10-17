package exercise3;


import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //input for the current prime interest rate
        System.out.print("Enter the current prime interest rate: ");
        double primeRate = input.nextDouble();

        Mortgage[] mortgages = new Mortgage[3]; //creates array to store 3 mortgages

        // Loop 3 times to get mortgage details from the user
        for (int i = 0; i < mortgages.length; i++) {
            //input mortgage type (1 for Business, 2 for Personal)
            System.out.print("Enter mortgage type (1 for Business, 2 for Personal): ");
            int type = input.nextInt();

            //input for mortgage number, customer name, amount and term
            System.out.print("Enter mortgage number: ");
            String mortgageNumber = input.next();

            System.out.print("Enter customer name: ");
            String customerName = input.next();

            System.out.print("Enter mortgage amount: ");
            double mortgageAmount = input.nextDouble();

            System.out.print("Enter term (1, 3 or 5 years): ");
            int term = input.nextInt();

            //creates BusinessMortgage or PersonalMortgage based on the user input
            if (type == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, primeRate, term);
            } else if (type == 2) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, mortgageAmount, primeRate, term);
            } else {
                System.out.println("Invalid mortgage type.");
            }
        }

        //display the details of all the mortgages
        System.out.println("\nMortgage Details:");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println("Total Owed: $" + mortgage.calculateTotalOwed());
            System.out.println();
        }
    }
}
