package com.example.actuatordemo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "client")
public class CustomEndpoint {

    @ReadOperation
    public String customEndpoint() {
        return "Hi Grant, this is Client endpoint! from Harnesslive branch";
    }
}
