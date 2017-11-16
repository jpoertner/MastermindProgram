import java.util.Scanner;

/*
  	ISYS 320
  	Name(s):  Jordan Poertner
  	Date: 11/16/2017
*/

public class P2_SluggingPctComputer {

	public static void printWelcomeAndInstructions() {
		System.out.println("This program computes the slugging percentage for a baseball batter.");
		System.out.println("You will need to enter the number of bases for each of the batter's at bats.");
		System.out.println("Please enter:");
		System.out.println("\t0 for no hit");
		System.out.println("\t1 for a single");
		System.out.println("\t2 for a double");
		System.out.println("\t3 for a triple");
		System.out.println("\t4 for a home run");
		System.out.println("\t-1 to quit and get the slugging percentage");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		printWelcomeAndInstructions();

		System.out.println();
		getSlugPercent(input);
	}

	public static void getSlugPercent(Scanner input) {
		double sluggingPercentage = 0;
		int batChances = 0;
		int basesTouched = 0;
		int totalBases = 0;
		while (basesTouched != -1) {
			totalBases += basesTouched;
			System.out.print("Enter the bases touched for the next at bat:  ");
			basesTouched = input.nextInt();
			if (basesTouched != -1) {
				batChances++;
			}
		}

		sluggingPercentage = (double) totalBases / (double) batChances;

		System.out.println("Total at bats:  " + batChances);
		System.out.printf("Slugging Pct:  %.3f", sluggingPercentage);

	}
}
