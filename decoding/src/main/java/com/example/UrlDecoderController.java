package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decode")
public class UrlDecoderController {
    private final UrlDecoder urlDecoder;
    @Autowired
    public UrlDecoderController(UrlDecoder urlDecoder) {
        this.urlDecoder = urlDecoder;
    }

    @PostMapping
    public ResponseEntity<String> decodeUrl(@RequestBody String shortUrl) {
        try {
            String decodedUrl = urlDecoder.decodeFromBase32(shortUrl);
            return ResponseEntity.ok(decodedUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error decoding URL: " + e.getMessage());
        }
    }


}
