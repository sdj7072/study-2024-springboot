package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/postmap")
    public String postMap(@RequestBody Map<String, String> postMap) {
        StringBuilder sb = new StringBuilder();

        postMap.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/postdto")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
