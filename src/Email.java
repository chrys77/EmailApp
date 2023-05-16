import java.util.Scanner;

public class Email {

    private Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail = "test@email.com";
    public static String companySuffix = "mycompany.com";

    //Constructor
    public Email() {
        this.firstName = setFirstName();
        this.lastName = setLastName();
        this.department = SetDepartment.setDepartment();
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        this.password = PasswordGenerator.generatePassword();
        this.alternateEmail = setAlternateEmail();
        EmailRepository.insertEmailInDatabase(this.firstName, this.lastName, this.department, this.email, this.password, this.mailboxCapacity, this.alternateEmail);
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

    private String setAlternateEmail() {
        System.out.println("Enter the alternate email");
        while (true) {
            String newAlternateEmail = sc.nextLine();
            if (CheckAlternateEmail.checkAlternateEmail(newAlternateEmail)) {
                return newAlternateEmail;
            }
        }
    }


}



