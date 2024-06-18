package org.example;

public class ConsoleAnnouncer implements Announcer {


    @InjectByType
    private Recommendator recommendator;
    @Override
    public void announce(String text) {
        System.out.println(text);
        recommendator.recommend();
    }



}
