package com.example;
import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Component;

@Component
public class UrlEncoder {
    // Encode a string to Base32
    public String encodeToBase32(String input) {
        // Ensure non-null input
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        Base32 base32 = new Base32();
        byte[] encodedBytes = base32.encode(input.getBytes());
        return new String(encodedBytes);
    }
}