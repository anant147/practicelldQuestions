package com.practice.lld.messagebroker;

public class Subscriber1 implements Subscriber {
    private String name;

    public Subscriber1(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println(name + " received: " + message);
    }
}
