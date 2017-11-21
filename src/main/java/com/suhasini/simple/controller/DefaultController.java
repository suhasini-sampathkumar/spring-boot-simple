package com.suhasini.simple.controller;

import com.suhasini.simple.service.DefaultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.*;

@RestController
public class DefaultController {

    private final DefaultService ds;

    public DefaultController(DefaultService ds) {
        this.ds = ds;
    }

    @GetMapping("/message")
    public String message(@RequestHeader(USER_AGENT) String userAgent) {

        return ds.showMessage(userAgent);
    }

}
