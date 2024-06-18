package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfiguration implements ObjectConfiguration {
    private Map<String, String> propertisMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfiguration() {
        String path = ClassLoader.getSystemClassLoader().getResource("ap.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();

        propertisMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));

    }

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            if (annotation != null) {
                String value = annotation.value().isEmpty() ? propertisMap.get(field.getName()) : propertisMap.get(annotation.value());
                field.set(t, value);
            }
        }
    }
}

