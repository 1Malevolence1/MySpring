package org.example;


import lombok.SneakyThrows;

import java.lang.invoke.SerializedLambda;

public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("org.example");


    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    private ObjectFactory() {
    }


    // Class - позволяет узнать информацию о самом классе: поля, методы и т.п.
    @SneakyThrows
    public <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;

        if(type.isInterface()){
            implClass = config.getImplClass(type);
        }
       return implClass.getDeclaredConstructor().newInstance();
    }
}
