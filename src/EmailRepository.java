import java.sql.*;
import java.util.Scanner;

public class EmailRepository {

    static Scanner sc = new Scanner(System.in);

    public static boolean insertEmailInDatabase(String firstName, String lastName, String department, String companyEmail,
                                                String password, int mailBoxCapacity, String alternateEmail) {
        Connection c = ConnectionSingleton.getInstance().getConnection();
        try {
            Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String template = "INSERT INTO companyEmail (first_name, last_name, department, company_email, email_password, " +
                    "mailbox_capacity, alternate_email) VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s')";
            int affectedRows = st.executeUpdate(String.format(template, firstName, lastName, department, companyEmail, password, mailBoxCapacity, alternateEmail));
            System.out.println("\nYour email has been created." +
                    "\nDisplay Name: " + firstName + " " + lastName +
                    "\nCompany Email: " + companyEmail +
                    "\nPassword: " + password +
                    "\nMailbox Capacity: " + mailBoxCapacity + " mb");
            return affectedRows > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("The email was not saved in the database. Try again!");
            return false;
        }
    }

    public static boolean insertChangedPasswordInDatabase(String newPassword) {
        System.out.println("Enter your email address.");
        String emailAdress = sc.nextLine();
        System.out.println("Enter your password.");
        String emailPassword = sc.nextLine();
        Connection c = ConnectionSingleton.getInstance().getConnection();
        try {
            Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String template = "UPDATE companyEmail SET email_password = '%s' WHERE company_email = '%s' AND email_password = '%s'";
            int affectedRows = st.executeUpdate(String.format(template, newPassword, emailAdress, emailPassword));
            if (affectedRows > 0) {
                System.out.println("The password has been changed. The new password is: " + newPassword);
            } else {
                System.out.println("The password has not been changed. Try again!");
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("The password has not been changed. Try again!");
            return false;
        }
    }

    public static boolean insertNewDepartmentInDatabase(String newDepartment) {
        System.out.println("Enter your email address.");
        String emailAdress = sc.nextLine();
        System.out.println("Enter your password.");
        String emailPassword = sc.nextLine();
        Connection c = ConnectionSingleton.getInstance().getConnection();
        try {
            Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Statement s = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet name = s. executeQuery("SELECT * FROM companyEmail WHERE company_email = '" + emailAdress + "'");
            name.next();
            String firstName = name.getString("first_name");
            String lastName = name.getString("last_name");
            String newEmail = firstName.toString().toLowerCase() + "." + lastName.toString().toLowerCase() + "@" + newDepartment + "." + Email.companySuffix;
            String template = "UPDATE companyEmail SET department = '%s', company_email = '%s' WHERE company_email = '%s' AND email_password = '%s'";
            int affectedRows = st.executeUpdate(String.format(template, newDepartment, newEmail, emailAdress, emailPassword));
            if (affectedRows > 0) {
                System.out.println("The department has been changed. Your new email is: " + newEmail);
            } else {
                System.out.println("The department has not been changed.");
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("The department has not been changed.");
            return false;
        }
    }

    public static boolean insertNewCapacityInDatabase(int newCapacity) {
        System.out.println("Enter your email address.");
        String emailAdress = sc.nextLine();
        System.out.println("Enter your password.");
        String emailPassword = sc.nextLine();
        Connection c = ConnectionSingleton.getInstance().getConnection();
        try {
            Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String template = "UPDATE companyEmail SET mailbox_capacity = %d WHERE company_email = '%s' AND email_password = '%s'";
            int affectedRows = st.executeUpdate(String.format(template, newCapacity, emailAdress, emailPassword));
            if (affectedRows > 0) {
                System.out.println("The capacity of the email box has been changed. Now it has " + newCapacity);
            } else {
                System.out.println("The capacity of the email box has not been changed");
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("The capacity of the email box has not been changed");
            return false;
        }
    }

    public static boolean insertNewAlternateEmailInDatabase(String newAlternateEmail) {
        System.out.println("Enter your email address.");
        String emailAdress = sc.nextLine();
        System.out.println("Enter your password.");
        String emailPassword = sc.nextLine();
        Connection c = ConnectionSingleton.getInstance().getConnection();
        try {
            Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String template = "UPDATE companyEmail SET alternate_email = '%s' WHERE company_email = '%s' AND email_password = '%s'";
            int affectedRows = st.executeUpdate(String.format(template, newAlternateEmail, emailAdress, emailPassword));
            if (affectedRows > 0) {
                System.out.println("The alternate email has been changed");
            } else {
                System.out.println("The alternate email has not been changed. Try again!");
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("The alternate email has not been changed");
            return false;
        }
    }


}