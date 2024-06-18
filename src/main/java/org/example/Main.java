package org.example;

public class Main {

    public static void main(String[] args) {
        CoronaDisinfection coronaDisinfection = ObjectFactory.getInstance().createObject(CoronaDisinfection.class);
        coronaDisinfection.start(new Room());

    }
}
