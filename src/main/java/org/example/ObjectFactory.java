package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ObjectFactory {


    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    private List<ObjectConfiguration> configurations = new ArrayList<>();
    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    @SneakyThrows
    private ObjectFactory( ) {
        config = new JavaConfig("org.example", new HashMap<>(Map.of(Policeman.class, GoodPoliceman.class)));
        for (Class<? extends ObjectConfiguration> aClass : config.getScanner().getSubTypesOf(ObjectConfiguration.class)) {
            configurations.add(aClass.getDeclaredConstructor().newInstance());
        }
    }


    // Class - позволяет узнать информацию о самом классе: поля, методы и т.п.
    @SneakyThrows
    public <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;

        if(type.isInterface()){
            implClass = config.getImplClass(type);
        }

       T t =  implClass.getDeclaredConstructor().newInstance();

        configurations.forEach(objectConfiguration -> {
            objectConfiguration.configure(t);
        });

       return t;
    }
}
