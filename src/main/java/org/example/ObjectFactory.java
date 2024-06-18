package org.example;


import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {

    private final ApplicationContext context;
    private List<ObjectConfiguration> configurations = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
      //  config = new JavaConfig("org.example", new HashMap<>(Map.of(Policeman.class, GoodPoliceman.class)));
        this.context = context;
        for (Class<? extends ObjectConfiguration> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfiguration.class)) {
            configurations.add(aClass.getDeclaredConstructor().newInstance());
        }
    }


    // Class - позволяет узнать информацию о самом классе: поля, методы и т.п.
    @SneakyThrows
    public <T> T createObject(Class<T> implClass){


       T t =  implClass.getDeclaredConstructor().newInstance();

        configurations.forEach(objectConfiguration -> {
            objectConfiguration.configure(t, context);
        });

       return t;
    }
}
