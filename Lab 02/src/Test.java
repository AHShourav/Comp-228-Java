import javax.swing.JOptionPane;
import java.util.Random;

public class Test {
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    //questions of array
    private String[] questions = {
            "Which of the following Java program units defines a group of related objects?",
            "What does an instance variable describe?",
            "How many significant digits does a floating-point number have?",
            "Which of the following typically groups related classes so that they could be imported into programs and reused?",
            "Method arguments may be..."
    };

    //array options
    private String[][] options = {
            {"1. Java method", "2. Java", "3. Java Class", "4. Java default constructor"},
            {"1. Behaviour of an object", "2. Properties of an object", "3. Height of an object.", "4. Measurement of an object"},
            {"1. 7", "2. 5", "3. 15", "4. 10"},
            {"1. IDE", "2. Function", "3. Package", "4. Method"},
            {"1. only variables", "2. constants, variables, or expressions.", "3. only strings", "4. only constants"}
    };

    //correct array or answers
    private int[] correctOptions = {3, 2, 3, 3, 2};

    //random object for creating random messages
    private Random random = new Random();

    //simulate question method
    private void simulateQuestion(int questionNumber) {
        String question = questions[questionNumber];
        StringBuilder optionList = new StringBuilder();

        for (String option : options[questionNumber]) {
            optionList.append(option).append("\n");
        }

        String message = question + "\n" + optionList;
        boolean validInput = false;

        while (!validInput) {
            String userInput = JOptionPane.showInputDialog(message);

            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Test canceled.");
                System.exit(0);
            }

            try {
                int userAnswer = Integer.parseInt(userInput);

                if (userAnswer >= 1 && userAnswer <= 4) {
                    checkAnswer(questionNumber, userAnswer);
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between 1 and 4.");
            }
        }
    }


    //checks if answer is correct
    private void checkAnswer(int questionNumber, int userAnswer) {
        if (userAnswer == correctOptions[questionNumber]) {
            correctAnswers++;
            generateMessage(true);
        } else {
            incorrectAnswers++;
            generateMessage(false);
            String correctAnswer = options[questionNumber][correctOptions[questionNumber] - 1];
            JOptionPane.showMessageDialog(null, "Correct answer is: " + correctAnswer);
        }
    }

    //generates random message
    private void generateMessage(boolean isCorrect) {
        String[] correctMessages = {"Excellent!", "Good!", "Keep up the good work!", "Nice work!"};
        String[] incorrectMessages = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying..."};

        int randomIndex = random.nextInt(4);
        String message;

        if (isCorrect) {
            message = correctMessages[randomIndex];
        } else {
            message = incorrectMessages[randomIndex];
        }

        JOptionPane.showMessageDialog(null, message);
    }

    //displays final result
    private void displayResult() {
        int totalQuestions = questions.length;
        double percentage = (correctAnswers * 100.0) / totalQuestions;

        JOptionPane.showMessageDialog(null, "Test finished!\nCorrect answers: " + correctAnswers +
                "\nIncorrect answers: " + incorrectAnswers +
                "\nPercentage: " + String.format("%.2f", percentage) + "%");
    }

    //input from user
    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            simulateQuestion(i);
        }
        displayResult();
    }

    //main method
    public static void main(String[] args) {
        Test test = new Test();
        test.inputAnswer();
    }
}
