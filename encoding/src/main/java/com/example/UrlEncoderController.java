package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlEncoderController {
    private final UrlEncoder urlEncoder;

    @Autowired
    public UrlEncoderController(UrlEncoder urlEncoder) {
        this.urlEncoder = urlEncoder;
    }

    @PostMapping("/encode")
    public ResponseEntity<String> encodeUrl(@RequestBody String longUrl) {
        String encodedUrl = urlEncoder.encodeToBase32(longUrl);
        return ResponseEntity.ok(encodedUrl);
    }
}
