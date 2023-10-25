package controllers;

import lombok.Data;




@Data
public class User {
    private String name;
    private String password;

    User() {}
    User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return String.format("User: %1s, Password entered: %2s", name, password.equals("") ? "false" : "true");
    }
}
