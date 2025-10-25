package dasturlash.uz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "dasturlash.uz")
@EnableJpaRepositories(basePackages = "dasturlash.uz.repository")
@EntityScan(basePackages = "dasturlash.uz.entity")
public class KunUzApplication {
	public static void main(String[] args) {
		SpringApplication.run(KunUzApplication.class, args);
	}
}
