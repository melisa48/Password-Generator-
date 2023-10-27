import java.security.SecureRandom;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useUpperCase, boolean useLowerCase, boolean useNumbers, boolean useSpecialChars) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numericChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        StringBuilder validChars = new StringBuilder();

        if (useUpperCase) {
            validChars.append(uppercaseChars);
        }
        if (useLowerCase) {
            validChars.append(lowercaseChars);
        }
        if (useNumbers) {
            validChars.append(numericChars);
        }
        if (useSpecialChars) {
            validChars.append(specialChars);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int length = 12;
        boolean useUpperCase = true;
        boolean useLowerCase = true;
        boolean useNumbers = true;
        boolean useSpecialChars = true;

        String generatedPassword = generatePassword(length, useUpperCase, useLowerCase, useNumbers, useSpecialChars);

        System.out.println("Generated Password: " + generatedPassword);
    }
}
