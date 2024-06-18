package org.example;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass){
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext applicationContext = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(applicationContext);
        applicationContext.setFactory(factory);
        return applicationContext;
    }
}
