import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ShortUrlGenerator shortUrlGenerator() {
        return new ShortUrlGenerator();
    }
}
