import java.util.Random;
import java.util.Scanner;

/*
  	ISYS 320
  	Name(s):
  	Date: 
*/

public class P5_Mastermind {

	public static void printWelcomeMessage() {
		System.out.println("Welcome to MASTERMIND");
		System.out.println("The possible color pegs are (R)ed, (O)range, (Y)ellow,");
		System.out.println("(G)reen, (B)lue, (P)urple. The code is only 4 pegs long.");
		System.out.println();
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);

		printWelcomeMessage();
		String code = getCode(rand);

		System.out.println("The code was " + code);
		breakerAttempts(code, input);

		System.out.print("The code was " + code);
	}

	public static void breakerAttempts(String code, Scanner input) {
		boolean broken = false;
		int guesses = 1;
		while (!broken && guesses <= 10) {
			System.out.println("Enter guess number " + guesses + ":");
			String attempt = input.next();
			if (checkCode(attempt, code, guesses)) {
				broken = true;
			}
			guesses++;
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

	public static boolean checkCode(String attempt, String code, int guesses) {
		int positions = 0;
		int colors = 0;
		String newAttempt = "";
		String newCode = "";
		for (int num = 0; num < code.length(); num++) {
			if (attempt.charAt(num) == code.charAt(num)) {
				newAttempt = removeCharAt(attempt, num);
				newCode = removeCharAt(code, num);
				positions++;

			}
		}
		if (positions == 4) {
			System.out.println("You got it in " + guesses + " guesses");
			return true;
		} else {
			for (int num = 0; num < newCode.length(); num++) {
				for (int checker = 0; checker < newCode.length(); checker++) {
					if (newAttempt.charAt(num) == newCode.charAt(checker)) {
						newAttempt = removeCharAt(newAttempt, num);
						colors++;
					}
				}
			}

			System.out.println(positions + " correct positions");
			System.out.println(colors + " correct colors in wrong positions");
			return false;
		}
	}

	public static String getCode(Random rand) {
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

}
