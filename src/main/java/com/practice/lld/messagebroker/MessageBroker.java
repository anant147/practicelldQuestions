package com.practice.lld.messagebroker;

import java.util.HashMap;
import java.util.Map;

public class MessageBroker {
    private Map<String, Topic> topics;

    public MessageBroker() {
        this.topics = new HashMap<>();
    }

    public synchronized void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    public synchronized Topic getTopic(String topicName) {
        return topics.get(topicName);
    }

    public synchronized void publish(String topicName, Message message) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.publishMessage(message);
        }
    }

    public synchronized void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.addSubscriber(subscriber);
        }
    }
}
