package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/delete-api")
public class DeleteController {

    @DeleteMapping("/{input}")
    public String deleteVariable(
            @PathVariable String input
    ) {
        return input;
    }

    @DeleteMapping("/request1")
    public String getRequestParam1(
            @RequestParam String email
    ) {
        return "email :" + email;
    }
}
