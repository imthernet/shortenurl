package com.example;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class UrlEncoder {
    private final CassandraConnection connection;

    public UrlEncoder(CassandraConnection connection) {
        this.connection = connection;
    }

    public String encodeToBase32(String longUrl) {
        // Generate a short code and encode to Base32 (update the method as required)
        String shortCode = generateShortCode(longUrl); // Generate your short URL code here
        CqlSession session = connection.getSession();
        session.execute("INSERT INTO my_keyspace.urls (short_code, long_url) VALUES (?, ?)",
                shortCode, longUrl);
        return "http://yourdomain.com/" + shortCode;
    }

    private String generateShortCode(String url) {
        // Example: Create a simple hash and encode it (this is just a placeholder)
        return Base64.getEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8)).substring(0, 8);
    }
}
