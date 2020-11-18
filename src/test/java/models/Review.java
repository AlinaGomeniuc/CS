package models;

public class Review {
    private String username;
    private String email;
    private String message;

    public Review(String username, String email, String message) {
        this.username = username;
        this.email = email;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }
}
