package org.example.jpa2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor // 생성자 주입
public class MainController {
    @GetMapping
    public String index() {
        return "index";
    }
}
