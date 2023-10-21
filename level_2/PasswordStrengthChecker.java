package level_2;

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = input.nextLine();
        input.close();
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        int strengthScore = 0;
        if (length >= 8) {
            strengthScore=3;
        }
        if (hasUppercase) {
            strengthScore++;
        }
        if (hasLowercase) {
            strengthScore++;
        }
        if (hasDigit) {
            strengthScore++;
        }
        if (hasSpecialChar) {
            strengthScore++;
        }

        String feedback=null;
        switch (strengthScore) {
            case 0-3:
                feedback = "Very weak";
                break;
            case 4:
                feedback = "Weak";
                break;
            case 5:
                feedback = "Moderate";
                break;
            case 6:
                feedback = "Strong";
                break;
            case 7:
                feedback = "Very strong";
                break;
            default:
                feedback = "Invalid password";
                break;
        }

        System.out.println("Password strength: " + feedback);
    }
}

