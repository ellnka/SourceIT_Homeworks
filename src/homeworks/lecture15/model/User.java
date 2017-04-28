package homeworks.lecture15.model;

public class User {
    private long id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private UserRole userRole;

    public User() {
    }

    public User(String name, String lastName, String login, String password, String email, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public User(long id, String name, String lastName, String login, String password, String email, UserRole userRole) {
        this(name, lastName, login, password, email, userRole);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
