package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import com.mariakh.framework.pages.StartPage;
import io.cucumber.java.ru.И;

public class StartPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Клик на базовое меню - '(.+)'$")
    public void clickBaseMenu(String linkName) {
        pageManager.getPage(StartPage.class).clickBaseMenu(linkName);
    }
}
