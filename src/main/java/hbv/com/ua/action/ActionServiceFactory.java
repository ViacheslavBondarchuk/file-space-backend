package hbv.com.ua.action;

import hbv.com.ua.action.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ActionServiceFactory {
    private static Map<String, ActionService> ACTION_MAP = new HashMap<>() {{
        this.put("read", new ReadActionServiceImpl());
        this.put("create", new CreateActionServiceImpl());
        this.put("update", new UpdateActionServiceImpl());
        this.put("delete", new DeleteActionServiceImpl());
        this.put("view", new ViewActionServiceImpl());
        this.put("edit", new EditActionServiceImpl());
    }};

    public static Map<String, ActionService> getAllActionService() {
        return ACTION_MAP;
    }

    public static ActionService getActionService(final String action) {
        return ACTION_MAP.getOrDefault(action, new DefaultActionServiceImpl());
    }
}
