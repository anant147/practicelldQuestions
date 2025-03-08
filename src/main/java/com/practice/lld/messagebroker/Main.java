package com.practice.lld.messagebroker;

public class Main {
    public static void main(String[] args) {
        // Create a message broker
        MessageBroker broker = new MessageBroker();

        // Create topics
        broker.createTopic("Sports");
        broker.createTopic("News");

        // Create subscribers
        Subscriber subscriber1 = new Subscriber1("Subscriber1");
        Subscriber subscriber2 = new Subscriber2("Subscriber2");

        // Subscribe to topics
        broker.subscribe("Sports", subscriber1);
        broker.subscribe("News", subscriber2);

        // Create publishers
        Publisher publisher = new Publisher(broker);

        // Publish messages
        publisher.publish("Sports", "Football World Cup Update");
        publisher.publish("News", "Breaking News: Market Crash");
    }
}
