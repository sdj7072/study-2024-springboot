package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PutMapping(value = "/putmap")
    public String postMap(@RequestBody Map<String, Objects> putMap) {
        StringBuilder sb = new StringBuilder();

        putMap.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping("/putdto")
    public MemberDto postDto(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    @PutMapping("/putentity")
    public ResponseEntity<MemberDto> postEntity(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }

}
