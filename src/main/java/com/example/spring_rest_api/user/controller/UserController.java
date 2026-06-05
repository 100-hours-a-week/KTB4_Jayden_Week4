package com.example.spring_rest_api.user.controller;

import com.example.spring_rest_api.user.service.UserService;
import com.example.spring_rest_api.user.service.request.UserCreateRequest;
import com.example.spring_rest_api.user.service.request.UserUpdateRequest;
import com.example.spring_rest_api.user.service.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserResponse create(@Valid @RequestBody UserCreateRequest request) {
        return userService.create(request);
    }

    @GetMapping("/users/{userId}")
    public UserResponse read(@PathVariable Long userId) {
        return userService.read(userId);
    }

    @PatchMapping("/users/{userId}")
    public UserResponse updateInformation(@PathVariable Long userId, @Valid @RequestBody UserUpdateRequest request) {
        return userService.updateInformation(userId, request);
    }

    @PatchMapping("/users/{userId}/password")
    public UserResponse updatePassword(@PathVariable Long userId, @Valid @RequestBody UserUpdateRequest request) {
        return userService.updatePassword(userId, request);
    }

    @DeleteMapping("/users/{userId}")
    public UserResponse delete(@PathVariable Long userId) {
        return userService.delete(userId);
    }
}
