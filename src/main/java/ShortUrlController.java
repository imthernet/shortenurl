import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShortUrlController {

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String longUrl) {
        // Logika skracania linku
        //return "shortenedUrl";
        return "http://short.url/abc123";
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        // Logika przekierowania
        return "redirectedUrl";
    }
}
