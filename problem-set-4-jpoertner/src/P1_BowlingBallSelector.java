import java.util.Scanner;

/*
  	ISYS 320
  	Name(s):  Jordan Poertner
  	Date: 11/16/2017
*/

public class P1_BowlingBallSelector {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What will be the oil length in feet?  ");
		int length = input.nextInt();

		System.out.println(Selector(length));
	}

	public static String Selector(int length) {
		String helpfulTip;
		if (length < 32) {
			helpfulTip = "You might as well just lob the ball down, I cannot give you a recommendation.";
		} else if (length <= 35 && length >= 32) {
			helpfulTip = "I would recommend using the Flintstone Pin-Cracker.";
		} else if (length >= 35 && length <= 42) {
			helpfulTip = "You should give the Moogle Mogball a try for this length.";
		} else if (length >= 42 && length <= 44) {
			helpfulTip = "You should definitely use the Hyrulian Cucco!";
		} else {
			helpfulTip = "With that length, use any ball you want!  It will slide like on butter.";
		}

		return helpfulTip;
	}
}
