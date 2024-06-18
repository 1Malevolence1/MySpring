package org.example;

public class ConsoleAnnouncer implements Announcer {


    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);
    @Override
    public void announce(String text) {
        System.out.println(text);
        recommendator.recommend();
    }



}
