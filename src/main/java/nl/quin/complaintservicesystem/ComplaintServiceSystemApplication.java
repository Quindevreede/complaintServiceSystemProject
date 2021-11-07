package nl.quin.complaintservicesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ComplaintServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintServiceSystemApplication.class, args);
    }

}
