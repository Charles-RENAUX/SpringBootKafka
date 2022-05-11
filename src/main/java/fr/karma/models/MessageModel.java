package fr.karma.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;


public class MessageModel implements Serializable {
    @JsonProperty("object")
    private String object;

    @JsonProperty("body")
    private String body;

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("ordre")
    private AtomicInteger ordre;


    public MessageModel() {
    }

    public MessageModel(String object, String body, String from, String to) {
        this.object = object;
        this.body = body;
        this.from = from;
        this.to = to;
    }


    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getJsonInString(String object, String body, String from, String to){
        return "{" +
                "'object':'" + object + '\'' +
                ", 'body':'" + body + '\'' +
                ", 'from':'" + from + '\'' +
                ", 'to':'" + to + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "{" +
                "'object':'" + object + '\'' +
                ", 'body':'" + body + '\'' +
                ", 'from':'" + from + '\'' +
                ", 'to':'" + to + '\'' +
                '}';
    }


}
