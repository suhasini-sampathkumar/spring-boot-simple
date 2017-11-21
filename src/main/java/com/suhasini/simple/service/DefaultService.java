package com.suhasini.simple.service;

import com.suhasini.simple.exception.DefaultException;
import fiftyone.mobile.detection.factories.StreamFactory;
import org.springframework.stereotype.Service;
import fiftyone.mobile.detection.Provider;

import fiftyone.device.example.Shared;
import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class DefaultService {

    private Provider provider;

    @PostConstruct
    void init() {

        try {
            provider = new Provider(StreamFactory.create(Shared.getLitePatternV32(), false));
        } catch (IOException e) {
            throw new DefaultException(e);
        }

    }
    public String showMessage() {

        return "My simple website";
    }
}
