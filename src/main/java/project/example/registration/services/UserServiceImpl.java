package project.example.registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.example.registration.dtos.UserDto;
import project.example.registration.entities.User;
import project.example.registration.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<String> registerUser(UserDto userDto) {
        List<String> response = new ArrayList<>();

        // Check if the username already exists
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            response.add("Username already exists. Please choose a different username.");
            return response;
        }

        // Create a new User entity
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        // Set other properties as needed

        // Save the new user
        userRepository.save(newUser);

        // Add a success message to the response
        response.add("User registered successfully.");
        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();

        // Find the user by username
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null) {
            response.add("User not found.");
            return response;
        }

        // Check if the password matches
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            response.add("Incorrect password.");
            return response;
        }

        // Add a success message to the response
        response.add("Login successful.");
        return response;
    }

    @Override
    public void loginUser() {

    }

    @Override
    public boolean loginUser(UserDto userDto) {
        return false;
    }
}
