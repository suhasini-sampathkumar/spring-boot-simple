package com.suhasini.simple.service;

import com.suhasini.simple.exception.DefaultException;
import fiftyone.mobile.detection.Match;
import fiftyone.mobile.detection.factories.StreamFactory;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import fiftyone.mobile.detection.Provider;

import fiftyone.device.example.Shared;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;

@Service
public class DefaultService {

    private Provider provider;

    @PostConstruct
    @SneakyThrows
    void init() {

        provider = new Provider(StreamFactory.create(Shared.getLitePatternV32(), false));
    }

    @SneakyThrows
    public String showMessage(String userAgent) {

        Match match = provider.match(userAgent);
        String isMobile = match.getValues("IsMobile").toString();
        return format("<h1>My simple website (Mobile: %s)<h1>", isMobile);
    }
}
