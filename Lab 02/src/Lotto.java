import javax.swing.JOptionPane;
import java.util.Random;

public class Lotto {
    private int[] numbers = new int[3];  //array holds random number

    //constructor randomly populates array
    public Lotto() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(9) + 1;  //1-9
        }
    }

    //method returns array of lotto numbers
    public int[] getNumbers() {
        return numbers;
    }

    //method for sum of lotto numbers
    public int getSum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    //main method
    public static void main(String[] args) {
        int userNumber = 0;

        // user input
        while (true) {
            String input = JOptionPane.showInputDialog("Choose a number between 3 and 27:");
            try {
                userNumber = Integer.parseInt(input);
                if (userNumber >= 3 && userNumber <= 27) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a number between 3 and 27");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Enter a number.");
            }
        }

        //loop for 5 rolls
        boolean userWins = false;
        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            int sum = lotto.getSum();

            //shows lotto number and sum
            JOptionPane.showMessageDialog(null, "Lotto numbers: " + lotto.getNumbers()[0] + ", " + lotto.getNumbers()[1] + ", " + lotto.getNumbers()[2] + "\nSum: " + sum);

            //checks if user input matches sum
            if (userNumber == sum) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                userWins = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No match. " + (4 - i) + " attempts left.");
            }
        }

        if (!userWins) {
            JOptionPane.showMessageDialog(null, "Game over! The computer wins.");
        }
    }
}
