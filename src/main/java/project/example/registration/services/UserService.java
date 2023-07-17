package project.example.registration.services;

import project.example.registration.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<String> registerUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);

     void loginUser( );

    boolean loginUser(UserDto userDto);
}
