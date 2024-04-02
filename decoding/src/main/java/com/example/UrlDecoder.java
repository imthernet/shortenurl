package com.example;
import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Component;

@Component
public class UrlDecoder {
    // Decode a Base32 encoded string
    public String decodeFromBase32(String input) {
        // Ensure non-null input
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        Base32 base32 = new Base32();
        byte[] decodedBytes = base32.decode(input);
        return new String(decodedBytes);
    }
}