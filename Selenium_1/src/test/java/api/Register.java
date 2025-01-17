package api;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Register {
    private String email;
    private String password;

    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Register() {
        this.email = "email";
        this.password = "password";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
