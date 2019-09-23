package com.example.controller;

import com.example.persistence.TestEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AppController {
    private TestEntityService service;

    public AppController(TestEntityService service) {
        this.service = service;
    }

    @GetMapping(value = "/attribute")
    public ResponseEntity<List<Map<String, Object>>> getAttributes() {
        List<Map<String, Object>> result = service.getAttributes(1);
        System.out.println("result: " + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
