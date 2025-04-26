package edu.icet.controller;

import edu.icet.entity.User;
import edu.icet.service.JwtService;
import edu.icet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setRole("STUDENT"); // Default role = STUDENT
        userService.saveUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = userService.findByUsername(user.getUsername());
        if (dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
            return jwtService.generateToken(dbUser);
        }
        return "Invalid credentials!";
    }
}
