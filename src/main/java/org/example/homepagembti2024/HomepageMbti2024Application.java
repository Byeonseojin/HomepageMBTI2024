package org.example.homepagembti2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HomepageMbti2024Application {

    public static void main(String[] args) {
        SpringApplication.run(HomepageMbti2024Application.class, args);
    }

}
