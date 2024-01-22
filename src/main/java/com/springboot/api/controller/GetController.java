package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/request")
    public String getRequest() {
        logger.info("[Controller] Call getRequest API ");
        return "request";
    }

    @GetMapping("/variable/{variable}")
    public String getRequestPathVariable(@PathVariable("variable") String variable) {
        return variable;
    }

    @GetMapping("/requestparam")
    public String getRequestParam(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping("/requestparammap")
    public String getRequestParamMap(@RequestParam Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();

        paramMap.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/requestdto")
    public String getRequestDto(MemberDto memberDto) {
        return memberDto.toString();
    }

}