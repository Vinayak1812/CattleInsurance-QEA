package proj.cattleinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.cattleinsurance.entity.User;
import proj.cattleinsurance.entity.UserRole;
import proj.cattleinsurance.repository.UserRepository;
import proj.cattleinsurance.repository.UserRoleRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        // For demo purposes, hardcoded admin credentials
        if ("juniorAdmin".equals(username) && "Junior@12345".equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("role", "JUNIOR_ADMIN");
            response.put("userId", 2L); // Junior Admin user ID
            response.put("username", username);
            return ResponseEntity.ok(response);
        } else if ("seniorAdmin".equals(username) && "Senior@12345".equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("role", "SENIOR_ADMIN");
            response.put("userId", 3L); // Senior Admin user ID
            response.put("username", username);
            return ResponseEntity.ok(response);
        } else {
            // Check regular user login
            User user = userRepository.findByUsernameAndPasswordHash(username, password);
            if (user != null) {
                UserRole role = userRoleRepository.findById(user.getRoleId()).orElse(null);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("role", role != null ? role.getName() : "FARMER");
                response.put("userId", user.getUserId());
                response.put("username", username);
                return ResponseEntity.ok(response);
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Invalid credentials");
        return ResponseEntity.badRequest().body(response);
    }
} 