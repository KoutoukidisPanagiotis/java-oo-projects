package ch11.model;

public class Main {
    public static void main(String[] args) {
        User john = new User(12345,"John","Doe");
        UserCredentials forJohn = new UserCredentials(12345,"John_123","123qweasd");

        System.out.printf("ID: %d, firstname %s, lastname: %s \n",john.getId(),john.getFirstname(),john.getLastname());
        System.out.printf("ID: %d, username: %s, lastname: %s", forJohn.getId(),forJohn.getUsername(),forJohn.getPassword());
    }
}
