package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import com.mariakh.framework.model.Deposit;
import com.mariakh.framework.pages.ResultPage;
import io.cucumber.java.ru.И;

import java.util.Arrays;
import java.util.List;

public class ResultPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверить, что в списке содержится ожидаемое количество вкладов - '(.+)'$")
    public void checkOpenResultPage(String expectedCount) {
        pageManager.getPage(ResultPage.class).checkOpenResultsPage(expectedCount);
    }

    @И("^Проверить наличие вклада в списке результатов - (.+)$")
    public void checkDepositPresence(String depositString) {
        List<String> depositInfo = Arrays.asList(depositString.split("\\s*,\\s*"));
        Deposit deposit = new Deposit(depositInfo.get(0), depositInfo.get(1).replace(".", ","), depositInfo.get(2), depositInfo.get(3));
        pageManager.getPage(ResultPage.class).depositCheck(deposit);
    }

}
