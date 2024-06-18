package org.example;


@Singleton
public class Recommendator {

    @InjectProperty("wisky")
    public String alcohol;
    public void recommend(){
        System.out.println("Реклама напитка: " + alcohol );

    }
}
