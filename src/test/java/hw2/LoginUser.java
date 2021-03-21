package hw2;

public enum LoginUser {
    ROMAN("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String login;
    private String password;
    private String correctName;

    LoginUser(String login, String password, String correctName){
        this.login = login;
        this.password = password;
        this.correctName = correctName;
    }

    public String getLogin(){ return login;}
    public String getPassword(){ return password;}
    public String getCorrectName(){ return correctName;}
}
