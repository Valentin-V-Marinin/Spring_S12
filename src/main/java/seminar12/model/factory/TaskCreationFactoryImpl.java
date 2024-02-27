package seminar12.model.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Component
public class TaskCreationFactoryImpl {

    @Autowired
    private Map<String, iTaskCreationFactory> services;

        public iTaskCreationFactory getService (String method) {
            return services.get(method);
        }
}
