package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {

    private final UserRepository userRepository;

    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    public List<UserResponse> getUsers() {
        return userRepository.geUsers();
    }

    public void updateUser(UserUpdateRequest request) {

        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException("User with ID " + request.getId() + " not found.");
        }
        userRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name) {

        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException("User with name " + name + " not found.");
        }
        userRepository.deleteUser(name);
    }

}
