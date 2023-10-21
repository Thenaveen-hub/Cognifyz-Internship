package level_1;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the desired length of the password: ");
		int length = scn.nextInt();
		System.out.print("Do you want to include numbers? (y/n): ");
		String numbers = scn.next();
		System.out.print("Do you want to include special characters? (y/n): ");
		String specialChars = scn.next();

		String password = generatePassword(length, numbers, specialChars);
		System.out.println("Your generated password is: " + password);
		scn.close();
	}

	public static String generatePassword(int length, String numbers, String specialChars) {
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbersString = "0123456789";
		String specialCharsString = "!@#$%^&*()_+-=[]{}|;':\",./<>?";

		String allChars = upperCaseLetters + lowerCaseLetters;
		if (numbers.equals("y")) {
			allChars += numbersString;
		}
		if (specialChars.equals("y")) {
			allChars += specialCharsString;
		}

		Random random = new Random();
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(allChars.length());
			password.append(allChars.charAt(index));
		}
		return password.toString();
	}
}
