package com.springboot.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DeleteMapping(value = "/{deletepathvariable}")
    public String deletePathVariable(@PathVariable String variable) {
        return variable;
    }

    @DeleteMapping(value = "/deleteparam")
    public String deleteParam(@RequestParam String email) {
        return "email : " + email;
    }
}
