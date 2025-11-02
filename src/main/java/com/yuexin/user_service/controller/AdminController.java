package com.yuexin.user_service.controller;

import com.yuexin.user_service.dto.UserDTO;
import com.yuexin.user_service.dto.UserPageDTO;
import com.yuexin.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getusers")
    public ResponseEntity<UserPageDTO> getAllUsers(
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers(page));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PutMapping("/update-role")
    public ResponseEntity<String> updateUserRole(
            @RequestParam Long userId, @RequestParam String roleName) {
        userService.updateUserRole(userId, roleName);
        return ResponseEntity.status(HttpStatus.OK).body("User role updated successfully");
    }

}
