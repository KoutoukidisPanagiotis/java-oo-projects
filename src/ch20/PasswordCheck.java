package ch20;

public class PasswordCheck {

    public static void main(String[] args) {
        String password = "abAB765!!";
        if (isValidPassword(password)) {
            System.out.println("Ο κωδικός πρόσβασης είναι έγκυρος.");
        } else {
            System.out.println("Ο κωδικός πρόσβασης δεν είναι έγκυρος.");
        }
    }
    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#?!@$%^&*]).{8,}$");
    }
}
