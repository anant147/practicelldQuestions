package com.practice.lld.messagebroker;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topic {
    private String name;
    private Queue<Message> messages;
    private List<Subscriber> subscribers;

    public Topic(String name) {
        this.name = name;
        this.messages = new LinkedList<>();
        this.subscribers = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public synchronized void publishMessage(Message message) {
        messages.offer(message);
        notifySubscribers(message);
    }

    public synchronized void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public synchronized void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
    private void notifySubscribers(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveMessage(message);
        }
    }
}
