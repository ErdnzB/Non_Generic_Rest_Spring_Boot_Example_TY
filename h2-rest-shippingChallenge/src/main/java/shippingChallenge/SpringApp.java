package shippingChallenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan
@EntityScan
@SpringBootApplication
public class SpringApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringApp.class);

    public static void main(String[] args) {
        LOGGER.info("Application Getting Start");
        SpringApplication.run(SpringApp.class, args);
    }
}
