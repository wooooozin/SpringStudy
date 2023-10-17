package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();
    
    @PostMapping("/user")
    public void saveUser(
        @RequestBody UserCreateRequest userCreateRequest
    ) {
        users.add(new User(userCreateRequest.getName(), userCreateRequest.getAge()));
    }


}
