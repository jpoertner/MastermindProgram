import java.util.Random;
import java.util.Scanner;

/*
  	ISYS 320
  	Name(s):  Jordan Poertner
  	Date: 11/16/2017
*/

public class P4_PasswordGenerator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		String password = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		System.out.print("Enter the desired password length:  ");
		int length = input.nextInt();

		int count = 0;
		while (count != length) {
			password += alphabet.charAt(rand.nextInt(alphabet.length()));
			count++;
		}
		
		System.out.print("Your password is:  " + password);
	}

}
