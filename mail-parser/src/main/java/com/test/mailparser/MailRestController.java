package com.test.mailparser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailRestController {
    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }
}
