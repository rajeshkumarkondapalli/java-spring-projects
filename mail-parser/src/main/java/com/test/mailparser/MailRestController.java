package com.test.mailparser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailRestController {
    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }

    @PostMapping(path = "/parse")
    public String addMember(@RequestBody String value) {
        return value;
    }

}
