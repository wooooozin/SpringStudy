package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {

        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException("User with ID " + request.getId() + " not found.");
        }

        String sql = "UPDATE USER SET NAME = ? WHERE id = ?";

        jdbcTemplate.update(sql, request.getName(), request.getId());

    }

}
