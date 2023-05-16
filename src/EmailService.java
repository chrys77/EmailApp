import java.util.Scanner;

public class EmailService {

    private Scanner sc = new Scanner(System.in);

    public Email createEmail() {
        return new Email();
    }

    public void changePassword() {
        String newPassword = ChangePassword.changePassword();
        EmailRepository.insertChangedPasswordInDatabase(newPassword);
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
