import java.util.Scanner;

public class Email {

    private Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLenght = 8;
    private String alternateEmail;
    private String companySuffix = "mycompany.com";

    //Constructor
    public Email() {
        this.firstName = setFirstName();
        this.lastName = setLastName();
        this.department = setDepartment();
        this.password = PasswordGenerator.generatePassword();
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for first name
    private String setFirstName() {
        System.out.println("Enter your first name: ");
        return setName();
    }

    //Ask for last name
    private String setLastName() {
        System.out.println("Enter your last name: ");
        return setName();
    }

    //Set first and last name
    private String setName() {
        while (true) {
            String name = sc.nextLine();
            if (name.matches("[a-zA-Z]+")) {
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                return name;
            } else {
                System.out.println("The name must contain only letters. Try again!");
            }
        }
    }

    //Ask for the departament
    private String setDepartment() {
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
                System.out.println("You did not enter a correct answer");
            }
        }
    }

    //Set the mailbox capacity
//    public void setMailboxCapacity(int capacity) {
//        this.mailboxCapacity = capacity;
//    }
//
//    //Set the alternate email
//    public void setAlternateEmail(String altEmail) {
//        this.alternateEmail = altEmail;
//    }
//
//    public int getMailboxCapacity() {
//        return mailboxCapacity;
//    }
//
//    public String getAlternateEmail() {
//        return alternateEmail;
//    }
//
//    public String getPassword() {
//        return password;
//    }

    public String showInfo() {
        return "\nYour email has been created." +
                "\nDisplay Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nPassowrd: " + password +
                "\nMailbox Capacity: " + mailboxCapacity + " mb";
    }

    //Check if you want to change the password
    public void changePassword(String password) {
        ChangePassword.verifyChangePassword();
        this.password = password;
    }
}



