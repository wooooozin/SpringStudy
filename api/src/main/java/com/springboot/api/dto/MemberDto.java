package com.springboot.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String email;
    private String mobile;

    @Override
    public String toString() {
        return "MemberDto { " +
                "name'" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile'" + mobile + '\'' +
                "}";
    }
}
