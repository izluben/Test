package od.city.claims.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"od.city.claims.ui"})
@EnableJpaRepositories(basePackages = "od.city.claims.dao")
@EntityScan("od.city.claims.domain")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
