package com.practice.lld.messagebroker;

public class Publisher {
    private MessageBroker broker;

    public Publisher(MessageBroker broker) {
        this.broker = broker;
    }

    public void publish(String topicName, String messageContent) {
        Message message = new Message(messageContent);
        broker.publish(topicName, message);
    }
}
