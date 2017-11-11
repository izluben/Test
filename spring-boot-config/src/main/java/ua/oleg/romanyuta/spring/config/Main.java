package ua.oleg.romanyuta.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"ua.oleg.romanyuta.ui"})
@EnableJpaRepositories(basePackages = "ua.oleg.romanyuta.dao")
@EntityScan("ua.oleg.romanyuta.domain")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
