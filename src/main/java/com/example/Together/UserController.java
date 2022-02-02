package com.example.Together;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        User user = new User("fdf", "fdff");
        User user1 = new User("fdf", "fdff");
        User user2 = new User("fdf", "fdff");
        List<User> users = Arrays.asList(user ,user1, user2);
        userService.saveUser(user);
        userService.saveUser(user1);
        userService.saveUser(user2);
        return users;
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
