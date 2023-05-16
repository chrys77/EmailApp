import java.util.Scanner;

public class SetDepartment {

    public static String setDepartment() {
        System.out.print("Enter the department code: " +
                "\n1 for Sales" +
                "\n2 for Development" +
                "\n3 for Accounting" +
                "\n0 for none" +
                "\nEnter department code: ");
        while (true) {
            Scanner in = new Scanner(System.in);
            int depChoice = in.nextInt();
            if (depChoice == 1) {
                return "sales";
            } else if (depChoice == 2) {
                return "dev";
            } else if (depChoice == 3) {
                return "acct";
            } else if (depChoice == 0) {
                return "any";
            } else {
                System.out.println("You did not enter a correct answer. Try again!");
            }
        }
    }

}
