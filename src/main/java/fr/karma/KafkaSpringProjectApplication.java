package fr.karma;

import fr.karma.models.MessageModel;
import fr.karma.services.interfaces.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EnableCaching
@EnableKafka
@SpringBootApplication
public class KafkaSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringProjectApplication.class, args);

	}

}
