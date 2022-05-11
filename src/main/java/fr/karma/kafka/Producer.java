package fr.karma.kafka;

import fr.karma.config.AppConfig;
import fr.karma.models.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(MessageModel message) {
        logger.info(String.format("$$$$ => Producing message: %s", message.toString()));
        this.kafkaTemplate.send("input-topic", message.toString());
    }

}