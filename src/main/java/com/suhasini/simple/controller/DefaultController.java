package com.suhasini.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/message")
    public String message() {
        //TODO Get UserAgent header
        return "My simple website";
    }

}
