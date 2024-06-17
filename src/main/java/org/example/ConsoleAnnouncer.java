package org.example;

public class ConsoleAnnouncer implements Announcer {
    @Override
    public void announce(String text) {
        System.out.println(text);
    }
}
