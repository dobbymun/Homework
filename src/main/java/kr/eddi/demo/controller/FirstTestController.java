package kr.eddi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstTestController {

    @GetMapping("/")
    public String index() {
        return "첫번째 스프링 테스트";
    }


}
