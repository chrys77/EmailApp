import java.util.Scanner;

public class EmailService {

    private Scanner sc = new Scanner(System.in);

    public Email createEmail() {
        return new Email();
    }

    public void changePassword() {
        System.out.println("The password must have between 8 and 20 characters and must contain at least one uppercase letter, " +
                "at least one lowercase letter, at least one digit and at least one special character.");
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\nEnter the new password: ");
            String newPassword = sc.nextLine();
            if (PasswordValidator.isValid(newPassword)) {
                EmailRepository.insertChangedPasswordInDatabase(newPassword);
                isValid = true;
            } else {
                System.out.println("Try again!");
            }
        }
    }

    public void changeDepartment() {
        String newDepartment = SetDepartment.setDepartment();
        EmailRepository.insertNewDepartmentInDatabase(newDepartment);
    }

    public void changeEmailCapacity() {
        int newCapacity = ChangeMailboxCapacity.changeMailboxCapacity();
        EmailRepository.insertNewCapacityInDatabase(newCapacity);
    }

    public void changeAlternateEmail() {
        System.out.println("Enter the alternate email");
        String newAlternateEmail = sc.nextLine();
        if (CheckAlternateEmail.checkAlternateEmail(newAlternateEmail)) {
            EmailRepository.insertNewAlternateEmailInDatabase(newAlternateEmail);
        }
    }


}
