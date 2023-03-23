package lab.padroesdeprojeto.labpadroesdeprojetojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
@EnableFeignClients
@Configuration
//@EnableSwagger2
@SpringBootApplication(scanBasePackages={
		"com.example.something", "com.example.application"})
@EnableJpaRepositories(
		entityManagerFactoryRef = "someEntityManagerFactory",
		transactionManagerRef = "someTransactionManager",
		basePackages = {"com.pack.some.database.repository"})

public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
