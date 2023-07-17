package project.example.registration.dtos;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private String username;
    private String password;
    private Set<UserDto> userDtoset = new HashSet<>();

    // Getters and setters
    // ...


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
