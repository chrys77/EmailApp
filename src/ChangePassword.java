import java.util.Scanner;

public class ChangePassword {

    private static Scanner sc = new Scanner(System.in);

    public static String changePassword() {
        System.out.println("The password must have between 8 and 20 characters and must contain at least one uppercase letter, " +
                "at least one lowercase letter, at least one digit and at least one special character.");
        while (true) {
            System.out.println("\nEnter the new password: ");
            String newPassword = sc.nextLine();
            if (PasswordValidator.isValid(newPassword)) {
                return newPassword;
            } else {
                System.out.println("Try again!");
            }
        }

    }



}
