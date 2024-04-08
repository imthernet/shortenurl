package com.example.wojtula;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/")
public class ShortUrlController {

    private final ShortUrlGenerator shortUrlGenerator;
    public ShortUrlController(ShortUrlGenerator shortUrlGenerator) {
        this.shortUrlGenerator = shortUrlGenerator;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String longUrl, UriComponentsBuilder ucb) {
        String shortUrl = shortUrlGenerator.shortenUrl(longUrl);
        URI locationOfNewUrl = ucb
                .path("/url/{shortUrl}")
                .buildAndExpand(shortUrl)
                .toUri();
        return locationOfNewUrl.toString();

    }

    //@GetMapping("/url/{shortUrl}")
    /* public RedirectView redirect(@PathVariable String shortUrl) {
        String longUrl = shortUrlGenerator.decode(shortUrl);
        return new RedirectView(longUrl);
    } */
    @GetMapping("/url/{shortUrl}")
    private RedirectView redirectToUrl(@PathVariable String shortUrl) {
        String longUrl = shortUrlGenerator.decode(shortUrl);
        return new RedirectView(longUrl);
    }
}
