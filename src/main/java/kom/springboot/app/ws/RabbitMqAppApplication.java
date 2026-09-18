package kom.springboot.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RabbitMqAppApplication {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(RabbitMqAppApplication.class, args);		
		Environment env = context.getEnvironment();
        String appName = env.getProperty("spring.application.name");
        String port = env.getProperty("server.port", "8080");
		log.info("APP NAME <{}> AND PORT <{}>", appName,  port);
	}
}
