package pl.markiewicz.teai_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.markiewicz.teai_2.shopProperties.ShopPlusProperties;
import pl.markiewicz.teai_2.shopProperties.ShopProProperties;

@EnableConfigurationProperties({ShopPlusProperties.class, ShopProProperties.class})
@SpringBootApplication
public class Teai2Application {

    public static void main(String[] args) {
        SpringApplication.run(Teai2Application.class, args);
    }

}
