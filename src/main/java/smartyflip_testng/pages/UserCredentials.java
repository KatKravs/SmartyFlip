package smartyflip_testng.pages;

public class UserCredentials {
    private String login;
    private String password;

    public UserCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static UserCredentials userWithValidLoginInvalidPassword() {
        return new UserCredentials("user", "w_ertyuiop&&");
    }
    public static UserCredentials userWithInvalidLoginValidPassword() {
        return new UserCredentials("ali", "User1234!");
    }

    public static UserCredentials userWithEmptyLoginValidPassword() {
        return new UserCredentials("", "User1234!");
    }

    public static UserCredentials userWithValidLoginEmptyPassword() {
        return new UserCredentials("user", "");
    }
}

