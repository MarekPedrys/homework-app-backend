package pl.marekpedrys.mathematicalproblems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db-postgres.properties")
public class MathematicalProblemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathematicalProblemsApplication.class, args);
	}

}
