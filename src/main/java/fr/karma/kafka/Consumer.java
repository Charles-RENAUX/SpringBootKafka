package fr.karma.kafka;



import com.google.gson.Gson;
import fr.karma.config.AppConfig;
import fr.karma.models.MessageModel;
import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class Consumer {

    final KafkaConsumer<byte[], String> consumer = new KafkaConsumer<>(AppConfig.getConsumerConfig());
    private final List<MessageModel> messages = new ArrayList<>();

    @KafkaListener(topics = "input-topic", groupId = "1")
    public void consume(String playerJson) throws IOException {

        log.info("consume :");
        log.info(playerJson);

        MessageModel message = new Gson().fromJson(playerJson, MessageModel.class);
        messages.add(message);
    }

    public List<MessageModel> getAllMessage(){
        List<MessageModel> messageModelList = new ArrayList<>();
        messageModelList.addAll(messages);
        System.out.println("Dans Listing ");
        return messageModelList;
    }
}
