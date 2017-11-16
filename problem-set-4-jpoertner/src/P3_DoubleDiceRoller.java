import java.util.Random;
import java.util.Scanner;

/*
  	ISYS 320
  	Name(s):  Jordan Poertner
  	Date: 11/16/2017
*/

public class P3_DoubleDiceRoller {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the sum of the dice to stop at:  ");
		int sumDesired = input.nextInt();

		rollTheDie(sumDesired);

	}

	public static void rollTheDie(int sumDesired) {
		Random rand = new Random();
		int newSum = 0;
		int rollOne = 0;
		int rollTwo = 0;

		while (newSum != sumDesired) {
			rollOne = rand.nextInt(5) + 1;
			rollTwo = rand.nextInt(5) + 1;
			newSum = rollOne + rollTwo;

			System.out.println("Rolled a " + rollOne + " and a " + rollTwo + ", sum is " + newSum);
		}
	}

}
