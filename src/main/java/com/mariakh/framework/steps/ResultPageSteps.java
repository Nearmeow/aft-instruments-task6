package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import com.mariakh.framework.pages.DepositSettingsPage;
import com.mariakh.framework.pages.ResultPage;
import io.cucumber.java.ru.И;

public class ResultPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверить, что в списке содержится ожидаемое количество вкладов - '(.+)'$")
    public void checkOpenResultPage(String expectedCount) {
        pageManager.getPage(ResultPage.class).checkOpenResultsPage(expectedCount);
    }

}
