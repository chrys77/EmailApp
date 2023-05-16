import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean isValid (String password) {

        boolean validPassword = true;

        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        boolean containsUppercase = uppercaseMatcher.find();

        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
        boolean containsLowercase = lowercaseMatcher.find();

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        boolean containsDigit = digitMatcher.find();

        Pattern specialCharPattern = Pattern.compile("[!@#&–:;',?/*~+=<>]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        boolean containsSpecialChar = specialCharMatcher.find();

        if (!containsUppercase) {
            System.out.println("The password does not contain an uppercase letter");
            validPassword = false;
        }

        if (!containsLowercase) {
            System.out.println("The password does not contain an lowercase letter");
            validPassword = false;
        }

        if (!containsDigit) {
            System.out.println("The password does not contain a digit");
            validPassword = false;
        }

        if (!containsSpecialChar) {
            System.out.println("The password does not contain a special character");
            validPassword = false;
        }

        if (password.length() < 8) {
            System.out.println("The password does not have at least 8 characters");
            validPassword = false;
        }

        if (password.length() > 20) {
            System.out.println("Password has more than 20 characters");
            validPassword = false;
        }

        return validPassword;
    }
}
