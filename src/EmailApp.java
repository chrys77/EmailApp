import java.util.Scanner;

public class EmailApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Email email = new Email();

        System.out.println(email.showInfo());

        startFlow();

    }


    private static void startFlow() {
        while(true) {
            System.out.println("Enter the desired operation:" +
                    "\n1 to Create a new Email Address" +
                    "\n2 to Change the Password" +
                    "\n3 to Change the Department" +
                    "\n4 to Change Mailbox Capacity" +
                    "\n5 to Change Alternate Email\n");
            String chosenOperation = sc.nextLine();
            switch(chosenOperation) {
                case "1":
                    System.out.println();
                case "2":
                    System.out.println();
                case "3":
                    System.out.println();
                default:
                    System.out.println("Invalid operation. Choose again!");
            }
        }
    }


}