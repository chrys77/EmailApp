import java.util.Scanner;

public class ChangePassword {

    private static Scanner sc = new Scanner(System.in);

    public static void verifyChangePassword() {
        while (true) {
            System.out.println("Do you want to change your password? (y / n)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("The password will not be changed");
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                System.out.println("The password must have between 8 and 20 characters and must contain at least one uppercase letter, " +
                        "at least one lowercase letter, at least one number and at least one special character.");
                System.out.println("Enter the new password: ");
                changePassword(sc.nextLine());
            } else {
                System.out.println("You did not enter a correct answer");
            }

        }
    }

    //Change password
    private static void changePassword(String password) {
        if(PasswordValidator.isValid(password)) {

        } else {
            System.out.println("Try again!");
        }

    }

}
