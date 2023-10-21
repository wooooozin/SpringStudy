package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")
    public void saveUser(
        @RequestBody UserCreateRequest userCreateRequest
    ) {
        String sql = "INSERT INTO USER (name, age) VALUES (?,?)";
        jdbcTemplate.update(sql, userCreateRequest.getName(), userCreateRequest.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM USER";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(
        @RequestBody UserUpdateRequest request
    ) {
        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException("User with ID " + request.getId() + " not found.");
        }

        String sql = "UPDATE USER SET NAME = ? WHERE id = ?";

        jdbcTemplate.update(sql, request.getName(), request.getId());

        return ResponseEntity.ok("User updated successfully"); // HTTP 응답
    }


    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(
        @RequestParam String name
    ) {

        String readSql = "SELECT * FROM user WHERE name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException("User with name " + name + " not found.");
        }
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);

        return ResponseEntity.ok("User deleted successfully");
    }

}
