package com.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="hello controller")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "測試用", description = "利用GET方法，Hello,World!")
    public String hello() {
        return "Hello, World!";
    }
}
