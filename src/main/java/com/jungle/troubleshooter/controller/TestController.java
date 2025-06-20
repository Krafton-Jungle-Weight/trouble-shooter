package com.jungle.troubleshooter.controller;

import com.jungle.troubleshooter.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public String test(@RequestParam(defaultValue = "1") Long id) {
        return testService.getMessageById(id);
    }
}
