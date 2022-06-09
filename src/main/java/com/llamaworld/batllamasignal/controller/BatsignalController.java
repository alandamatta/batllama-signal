package com.llamaworld.batllamasignal.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BatsignalController {


    private static final String ON = "ON";
    private static final String OFF = "OFF";
    private static String STATUS = ON;

    private Environment env;

    public BatsignalController(Environment env) {
        this.env = env;
    }

    @GetMapping("status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok(STATUS);
    }

    @GetMapping("on")
    public ResponseEntity<String> available(){
        if (STATUS.equals(OFF)) {
            STATUS = ON;
            return ResponseEntity.ok(STATUS);
        }
        return ResponseEntity.ok("BUSY");
    }

    @GetMapping("off")
    public ResponseEntity<String> fightingCrime() {
        STATUS = OFF;
        return ResponseEntity.ok(STATUS);
    }

    @GetMapping
    public ResponseEntity<String> message() {
        return ResponseEntity.ok(env.getProperty("BATSIGNAL_MESSAGE"));
    }


}
