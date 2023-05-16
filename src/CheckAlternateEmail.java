public class CheckAlternateEmail {

    public static boolean checkAlternateEmail(String alternateEmail) {
        boolean emailValid = true;
            if (!alternateEmail.contains("@") || (!alternateEmail.endsWith(".com") && !alternateEmail.endsWith(".ro"))) {
                emailValid = false;
                System.out.println("The alternate email is not valid. Try again!");
            }
            return emailValid;
        }

}
