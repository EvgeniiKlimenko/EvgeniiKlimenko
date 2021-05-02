package hw6.entities;

public class User {

    public final static User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String name;
    private String password;
    private String fullName;

    public User(String login, String password, String fullName) {
        this.name = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
