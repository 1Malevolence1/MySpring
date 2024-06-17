package org.example;

public class Recommendator {

    @InjectProperty("wisky")
    public String alcohol;
    public void recommend(){
        System.out.println("Реклама напитка: " + alcohol );

    }
}
