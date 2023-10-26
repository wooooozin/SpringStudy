package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServiceV1 userService;

    @Autowired
    public UserController(UserServiceV1 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(
        @RequestBody UserCreateRequest userCreateRequest
    ) {
        userService.saveUser(userCreateRequest);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(
        @RequestBody UserUpdateRequest request
    ) {
        userService.updateUser(request);
    }


    @DeleteMapping("/user")
    public void deleteUser(
        @RequestParam String name
    ) {
        userService.deleteUser(name);
    }

}
