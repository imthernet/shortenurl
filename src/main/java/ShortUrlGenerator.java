import java.util.HashMap;
import java.util.Map;

public class ShortUrlGenerator {

    private Map<String, String> urlMap;

    public ShortUrlGenerator() {
        this.urlMap = new HashMap<>();
    }

    public String shortenUrl(String longUrl) {
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    private String generateShortUrl() {
        // Logika generowania krótkiego URL
        return "shortUrl";
    }
}
