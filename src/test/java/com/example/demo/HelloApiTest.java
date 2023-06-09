package com.example.demo;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloApiTest {
    @Test
    void helloApi(){
        ///http localhost:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();
        
        ResponseEntity<String> res= 
        rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // status 200 인가 
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(contentType text/plain)
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        assertThat(res.getBody()).isEqualTo("Hello Spring");
        
    }
    
}
