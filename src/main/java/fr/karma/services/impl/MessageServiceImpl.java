package fr.karma.services.impl;

import fr.karma.kafka.Consumer;
import fr.karma.kafka.Producer;
import fr.karma.models.MessageModel;
import fr.karma.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    public List<MessageModel> messageList = new ArrayList<>();
    private final Producer producer;
    private final Consumer consumer;

    @Autowired
    public MessageServiceImpl(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public List<MessageModel> getAllMessages() {
        messageList.addAll(consumer.getAllMessage());
        return messageList;
    }

    @Override
    public void pushAllDataToTopic(MessageModel messageModel) {
        this.producer.sendMessage(messageModel);
    }

    @Override
    public void inList(MessageModel messageModel){
        this.messageList.add(messageModel);
        System.out.println(messageModel.getBody());
    }

    @Override
    public void initSomeMessages() {
        MessageModel m1 = new MessageModel("Test","coucou je suis content","Charles","Slime");
        MessageModel m2 = new MessageModel("Test2","coucou je suis malheureux","Charles","Slime");
        MessageModel m3 = new MessageModel("Test3","coucou je suis en colère","Charles","Slime");
        MessageModel m4 = new MessageModel("Test4","coucou je suis affamé","Charles","Slime");


        this.messageList.add(m1);
        this.messageList.add(m2);
        this.messageList.add(m3);
        this.messageList.add(m4);

        System.out.println("messageList : "+this.messageList.toString());


    }


}
