import java.util.Scanner;

public class EmailApp {

    private static EmailService emailService = new EmailService();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startFlow();
    }


    private static void startFlow() {
        boolean exitProgram = false;
        while(!exitProgram) {
            System.out.println("\nEnter the desired operation:" +
                    "\n1 to Create a new Email Address" +
                    "\n2 to Change the Password" +
                    "\n3 to Change the Department" +
                    "\n4 to Change Mailbox Capacity" +
                    "\n5 to Change Alternate Email" +
                    "\n6 to Exit");
            String chosenOperation = sc.nextLine();
            switch(chosenOperation) {
                case "1":
                    emailService.createEmail();
                    break;
                case "2":
                    emailService.changePassword();
                    break;
                case "3":
                    emailService.changeDepartment();
                    break;
                case "4":
                    emailService.changeEmailCapacity();
                    break;
                case "5":
                    emailService.changeAlternateEmail();
                    break;
                case "6":
                    System.out.println("See you soon!");
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid operation. Choose again!");
            }
        }
    }


}