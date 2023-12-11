import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static boolean[] userAnswers;

    public static void main(String[] args) {
        // Define quiz questions, options, and correct answers
        String[] questions = {
                "What is the capital of France?",
                "Which planet is known as the Red Planet?",
                "What is the largest mammal on Earth?",
                "Which is the most populated country in the world in 2023",
                "Which is the tallest statue in the world"
        };

        String[][] options = {
                {"A) Paris", "B) Berlin", "C) Madrid", "D) Rome"},
                {"A) Mars", "B) Jupiter", "C) Venus", "D) Saturn"},
                {"A) Elephant", "B) Giraffe", "C) Blue Whale", "D) Lion"},
                {"A) China", "B) Russia", "C) India", "D) USA"},
                {"A) liberty", "B) unity", "C) equality", "D) belief"}
        };

        char[] correctAnswers = {'A', 'A', 'C', 'C', 'B'};
        userAnswers = new boolean[questions.length];

        // Set up a timer for each question (in seconds)
        int timerDuration = 20;
        Timer timer = new Timer();

        for (int i = 0; i < questions.length; i++) {
            displayQuestion(questions[i], options[i]);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.\n");
                    evaluateAnswer(' '); 
                }
            }, timerDuration * 1000);
            char userChoice = getUserChoice();
            timer.cancel(); // Cancel the timer for the current question

            evaluateAnswer(userChoice);

            // Move to the next question
            System.out.println();
        }

        // Display the final score and summary
        displayResult();
    }

    private static void displayQuestion(String question, String[] options) {
        System.out.println(question);
        for (String option : options) {
            System.out.println(option);
        }
    }

    private static char getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        String input = scanner.nextLine().toUpperCase();
        return input.isEmpty() ? ' ' : input.charAt(0);
    }

    private static void evaluateAnswer(char userChoice) {
        char correctAnswer = getCorrectAnswer(currentQuestionIndex);
        boolean isCorrect = userChoice == correctAnswer;
        userAnswers[currentQuestionIndex] = isCorrect;

        if (isCorrect) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + ".\n");
        }
        currentQuestionIndex++;
    }

    private static char getCorrectAnswer(int questionIndex) {
        return (char) ('A' + questionIndex);
    }

    private static void displayResult() {
        System.out.println("Quiz Completed!");
        System.out.println("Your final score: " + score + " out of " + userAnswers.length);

        // Display a summary of correct/incorrect answers
        for (int i = 0; i < userAnswers.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + (userAnswers[i] ? "Correct" : "Incorrect"));
        }
    }
}
