import java.util.Scanner;

public class ChangeMailboxCapacity {

    private static Scanner sc = new Scanner(System.in);

    public static int changeMailboxCapacity () {
        System.out.println("The capacity of the email box can be between 500 mb and 1000 mb");
        while (true) {
            System.out.println("Enter the new capacity");
            int newCapacity = sc.nextInt();
            if (newCapacity < 500) {
                System.out.println("The capacity cannot be less than 500 mb");
            } else if (newCapacity > 1000) {
                System.out.println("The capacity cannot be greater than 1000 mb");
            } else {
                return newCapacity;
            }
        }
    }

}
