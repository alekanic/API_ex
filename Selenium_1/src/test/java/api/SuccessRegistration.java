package api;

public class SuccessRegistration {
    private Integer id;
    private String token;

    public SuccessRegistration(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessRegistration() {
        this.id = 0;
        this.token = "token";
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
