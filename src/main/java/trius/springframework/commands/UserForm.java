package trius.springframework.commands;


public class UserForm {
    private String email;
    private String password;

    public UserForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
