import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a password to check its strength: ");
            String password = scanner.nextLine();
            
            String strength = checkPasswordStrength(password);
            System.out.println("Password Strength: " + strength);
        }
    }

    private static String checkPasswordStrength(String password) {
        int lengthCriteria = password.length() >= 8 ? 1 : 0;
        int upperCaseCriteria = password.chars().anyMatch(Character::isUpperCase) ? 1 : 0;
        int lowerCaseCriteria = password.chars().anyMatch(Character::isLowerCase) ? 1 : 0;
        int digitCriteria = password.chars().anyMatch(Character::isDigit) ? 1 : 0;
        int specialCharCriteria = password.chars().anyMatch(ch -> "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~".indexOf(ch) >= 0) ? 1 : 0;

        int criteriaMet = lengthCriteria + upperCaseCriteria + lowerCaseCriteria + digitCriteria + specialCharCriteria;
        
        return switch (criteriaMet)
        {
            case 5 -> "Very Strong";
            case 4 -> "Strong";
            case 3 -> "Moderate";
            case 2 -> "Weak";
            default -> "Very Weak";
       
        };
    }
}