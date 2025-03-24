package com.example.actuatordemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api1")
public class ClientController {

    private final RestTemplate restTemplate;
    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/get-data")
    public ResponseEntity<String> getDataFromApi2() {
        //URL of API22
        String api2Url = "http://localhost:8081/api2/data";
        //Call API2
        ResponseEntity<String> response = restTemplate.getForEntity(api2Url, String.class);
        //Return response
        return ResponseEntity.ok("Grant this is the response Data from API 2 on host 8081: " + response.getBody());
    }

    @GetMapping(path = "test", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> headerDemo(@RequestHeader(name = "reg-channel-version") String header) {
        System.out.println("Header reg-channel-version is : " + header);
        String response = "Header reg-channel-version is : " + header;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
