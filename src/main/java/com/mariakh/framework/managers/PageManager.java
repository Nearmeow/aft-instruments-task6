package com.mariakh.framework.managers;

import com.mariakh.framework.pages.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PageManager {

    private static PageManager instance;
    private static Map<String, Object> pagesMap = new HashMap<>();

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public <T extends BasePage> T getPage(Class<T> page) {
        if (pagesMap.isEmpty() || pagesMap.get(page.getName()) == null) {
            try {
                pagesMap.put(page.getName(), page.getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return (T) pagesMap.get(page.getName());
    }

    public void clearPages() {
        pagesMap.clear();
    }
}
