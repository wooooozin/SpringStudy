package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // http://localhost:8080/api/v1/get-api/hello
    @GetMapping("/hello")
    public String getHello() {
        LOGGER.info("getHello() 메서드 호출");
        return "Hello World!";
    }

    @GetMapping("/variable/{input}")
    public String getVariable(
            @PathVariable String input
    ) {
        return "입력받은 매개변수는 " + input + " 입니다.";
    }

    @GetMapping("/request1")
    public String getRequest1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String mobile
    ) {
        return "이름 : " + name + "<br>"
                + "email : " + email + "<br>"
                + "mobile : " + mobile;
    }

    @GetMapping("/request2")
    public Map getRequest2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String mobile
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("name", name);
        response.put("email", email);
        response.put("mobile", mobile);
        return response;
    }

    @GetMapping("/request3")
    public String getRequest3(
            @RequestParam Map<String, String> param
    ) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/request4")
    public String getRequest4(MemberDto memberDto) {
        return memberDto.toString();
    }

}
