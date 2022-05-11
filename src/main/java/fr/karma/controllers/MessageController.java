package fr.karma.controllers;

import fr.karma.models.MessageModel;
import fr.karma.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public String index(Model model){
        //messageService.initSomeMessages();
        model.addAttribute("MessageModel",new MessageModel());
        model.addAttribute("messageList",messageService.getAllMessages());
        return "index";
    }

    @PostMapping("/")
    public String submitForm(@ModelAttribute("MessageModel") MessageModel messageModel) {
        System.out.println(messageModel);
        //messageService.inList(messageModel);
        messageService.pushAllDataToTopic(messageModel);
        return "index";
    }
}
