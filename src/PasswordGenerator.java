import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordGenerator {
    private static final String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
    private static final String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String digits = "0123456789";
    private static final String specialChars = "!@#&–:;',?/*~+=<>";
    private static final int passwordLength = 10;


    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Add at least one character from each category
        password.append(getRandomChar(lowercaseChars, random));
        password.append(getRandomChar(uppercaseChars, random));
        password.append(getRandomChar(digits, random));
        password.append(getRandomChar(specialChars, random));

        // The rest of the characters are generated up to the maximum length of the password
        int remainingLength = passwordLength - password.length();
        for (int i = 0; i < remainingLength; i++) {
            String charSet = getRandomCharSet(random);
            password.append(getRandomChar(charSet, random));
        }

        // The order of the characters is mixed up
        ArrayList<Character> charsList = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            charsList.add(c);
        }
        Collections.shuffle(charsList);
        //StringBuilder shuffledPassword = new StringBuilder();
        password.setLength(0);
        for (char c : charsList) {
            password.append(c);
        }

        return password.toString();
    }

    // A random character is returned from a string passed as a parameter
    private static char getRandomChar(String charSet, SecureRandom random) {
        int randomIndex = random.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    // All the characters are added to a list and a random one from that list is returned
    private static String getRandomCharSet(SecureRandom random) {
        ArrayList<String> charSets = new ArrayList<>();
        charSets.add(lowercaseChars);
        charSets.add(uppercaseChars);
        charSets.add(digits);
        charSets.add(specialChars);
        int randomIndex = random.nextInt(charSets.size());
        return charSets.get(randomIndex);
    }


}
