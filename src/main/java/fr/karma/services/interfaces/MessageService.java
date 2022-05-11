package fr.karma.services.interfaces;

import fr.karma.models.MessageModel;

import java.util.List;

public interface MessageService {

    List<MessageModel> getAllMessages();
    void pushAllDataToTopic(MessageModel messageModel);
    void inList(MessageModel messageModel);
    void initSomeMessages();


}
