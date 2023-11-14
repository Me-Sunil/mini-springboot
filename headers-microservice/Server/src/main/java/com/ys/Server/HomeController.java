package com.ys.Server;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    ResponseEntity<String> getHome(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY","SECRET-TOKEN");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body("SUCCESS");
    }
}
