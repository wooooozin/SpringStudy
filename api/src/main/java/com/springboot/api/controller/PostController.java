package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping("member")
    public String postMember(
            @RequestBody Map<String, String> postData
    ) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(
                map -> {
                    sb.append(map.getKey() + " : " + map.getValue() + "\n");
                }
        );
        return sb.toString();
    }

    @PostMapping("member1")
    public String postMember1(
            @RequestBody MemberDto memberDto
    ) {
        return memberDto.toString();
    }

    @PostMapping("member2")
    public ResponseEntity<MemberDto> postMember2(
            @RequestBody MemberDto memberDto
    ) {
        return ResponseEntity.ok(memberDto);
    }
}

