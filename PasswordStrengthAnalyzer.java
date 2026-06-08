import java.util.Scanner;

public class PasswordStrengthAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        analyzePassword(password);
        sc.close();
    }

    public static void analyzePassword(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))
                hasUpper = true;
            else if (Character.isLowerCase(ch))
                hasLower = true;
            else if (Character.isDigit(ch))
                hasDigit = true;
            else
                hasSpecial = true;
        }

        int score = 0;

        if (password.length() >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        System.out.println("\nPassword Analysis:");

        if (score <= 2)
            System.out.println("Strength: Weak");
        else if (score <= 4)
            System.out.println("Strength: Medium");
        else
            System.out.println("Strength: Strong");

        System.out.println("\nSuggestions:");

        if (password.length() < 8)
            System.out.println("- Use at least 8 characters");
        if (!hasUpper)
            System.out.println("- Add uppercase letters");
        if (!hasLower)
            System.out.println("- Add lowercase letters");
        if (!hasDigit)
            System.out.println("- Add numbers");
        if (!hasSpecial)
            System.out.println("- Add special characters");
    }
}
