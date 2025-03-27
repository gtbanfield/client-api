package com.example.actuatordemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public String callApi2(String customHeader) {
        //String api2Url = "http://localhost:8081/api2"; // URL of API 2
        String api2Url = "http://server-api:8080/server-api/api2"; // URL of API 2
        // Set the header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Custom-Header", customHeader);

        // Create the request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Call API 2
        return restTemplate.postForObject(api2Url, requestEntity, String.class);
    }
}