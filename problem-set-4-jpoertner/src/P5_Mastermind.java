package com.wernercd;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        boolean cheat,won ;
        int attempt;
        String answer,guess;

        do {
            /* Reset variables */
            cheat = true;
            attempt = 0;
            answer = getAnswer(rand);

            /* Game loop */
            printWelcomeMessage();
            printCheat(cheat, answer);
            do {
                attempt++;
                guess = getGuess(input, attempt);
                won = VerifyGuess(answer, guess, attempt);
            } while (attempt <= 10 && won == false);
            printResults(won, attempt, answer);
        } while (printDoYouWantToPlayAgain(input));
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to MASTERMIND");
        System.out.println("The possible color pegs are (R)ed, (O)range, (Y)ellow,");
        System.out.println("(G)reen, (B)lue, (P)urple. The code is only 4 pegs long.");
        System.out.println();
    }
    public static void printCheat(Boolean cheat, String answer){
        if (cheat)
            System.out.println("Hey cheater, the code is : \"" + answer + "\"");
    }
    public static void printResults(Boolean won, Integer attempt, String answer){
        if (won) {
            if (attempt == 1) {
                System.out.println("You got it in " + attempt + " guess.");
            } else {
                System.out.println("You got it in " + attempt + " guesses.");
            }
        } else {
            System.out.println("You failed to get the correct answer (\"" + answer + "\") in 10 guesses. " +
                    "Loser. Luh... hu. Su. Hur.");
        }
    }
    public static boolean printDoYouWantToPlayAgain(Scanner input) {
        do {
            System.out.println("Play another game? (y/n)");
            String yn = input.next();
            if (yn.equals("Y") || yn.equals("y")) {
                return true;
            }
            if (yn.equals("N") || yn.equals("n")) {
                return true;
            }
        } while (true);
    }

    public static String getAnswer(Random rand) {
        String code = "";
        for (int num = 1; num <= 4; num++) {
            int letter = rand.nextInt(6);

            if (letter == 0) {
                code += "R";
            } else if (letter == 1) {
                code += "O";
            } else if (letter == 2) {
                code += "Y";
            } else if (letter == 3) {
                code += "G";
            } else if (letter == 4) {
                code += "B";
            } else {
                code += "P";
            }
        }
        return code;
    }
    public static String getGuess(Scanner input, Integer num){
        do {
            System.out.println("Please enter guess #"+num+":");
            String guess = input.next();
            if (guess.length() == 4)
            return guess.toUpperCase();
        } while (true);
    }
    public static Boolean VerifyGuess(String answer, String guess, Integer attemptNum){
        int correct = 0;
        String answerB = answer;
        String guessB = guess;

        int spot = 0;
        for (int num = 0; num < answer.length(); num++) {
            if (answer.charAt(num) == guess.charAt(num)) {
                answerB = removeCharAt(answerB, spot);
                guessB = removeCharAt(guessB, spot);
                correct++;
            } else {
                spot++;
            }
        }
        if (correct == 4) {
            /* ZOMG YOU WIN!!! */
            System.out.println("Correct: " + correct);
            return true;
        } else if (correct == 3){
            /* If 3 is correct, 4th can't be "right color, wrong spot" */
            System.out.println("Correct: " + correct + ", Partial: " + 0);
            return false;
        } else {
            /* Next loser check... */
            int partial = 0;
            /* Something ain't right here... TODO: FIX THIS SHIT */
            for (int num = 0; num < answerB.length(); num++) {
                for (int checker = 0; checker < answerB.length(); checker++) {
                    if (answerB.charAt(num) == guessB.charAt(checker)) {
                        guessB = removeCharAt(guessB, num);
                        partial++;
                    }
                }
            }

            System.out.println("Correct: " + correct + ", Partial: " + partial);
            return false;
        }
    }
    public static String removeCharAt(String codeSent, int spot) {
        int count = 0;
        String returnCode = "";

        while (count < codeSent.length()) {
            if (count != spot) {
                returnCode += codeSent.charAt(count);
            }
            count++;
        }
        return returnCode;
    }
}
