package win.ddd.response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"win.ddd.*"})
@EnableJpaRepositories(basePackages = {"win.ddd.*"})
public class GeneralApiResponseApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralApiResponseApplication.class, args);
    }

}
