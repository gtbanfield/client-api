package com.example.actuatordemo.controller;

import com.example.actuatordemo.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api1Controller {

    @Autowired
    private ApiService apiService;

    @GetMapping("/api1")
    public ResponseEntity<String> callApi2(@RequestHeader("reg-channel-version") String customHeader) {
        // Call API 2 and pass the header
        System.out.println("Header reg-channel-version is : " + customHeader);
        String response = apiService.callApi2(customHeader);
        return ResponseEntity.ok(response);
    }
}
