package hbv.com.ua.action;

import hbv.com.ua.action.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ActionServiceFactory {
    private static ActionServiceFactory instance;
    private Map<String, ParametrizedActionService> actionMap = new HashMap<>();


    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private void init() {
        actionMap.put("read", applicationContext.getBean(ReadParametrizedActionServiceImpl.class));
        actionMap.put("create",applicationContext.getBean(CreateParametrizedActionServiceImpl.class));
        actionMap.put("update", applicationContext.getBean(UpdateParametrizedActionServiceImpl.class));
        actionMap.put("delete", applicationContext.getBean(DeleteParametrizedActionServiceImpl.class));
        actionMap.put("view", applicationContext.getBean(ViewParametrizedActionServiceImpl.class));
        actionMap.put("edit", applicationContext.getBean(EditParametrizedActionServiceImpl.class));
        actionMap.put("registration", applicationContext.getBean(RegistrationParametrizedActionServiceImpl.class));
    }

    public Map<String, ParametrizedActionService> getAllActionService() {
        return Collections.unmodifiableMap(actionMap);
    }

    public static ActionServiceFactory getInstance() {
        if (instance == null)
            instance = new ActionServiceFactory();
        return instance;
    }

    public ParametrizedActionService getActionService(final String action) {
        return actionMap.getOrDefault(action, new DefaultParametrizedActionServiceImpl());
    }
}
