package com.ys.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    ResponseEntity<String> getHome(){
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8081", String.class);
        String apiKeyHeader = entity.getHeaders().getFirst("X-API-KEY");

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY",apiKeyHeader);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(apiKeyHeader);
    }
}
