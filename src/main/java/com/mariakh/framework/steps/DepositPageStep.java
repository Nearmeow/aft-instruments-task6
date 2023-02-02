package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import io.cucumber.java.ru.И;

public class DepositPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия страницы 'Вклады'$")
    public void checkOpenDepositPage() {
        pageManager.getDepositPage().checkOpenDepositPage();
    }

    @И("^Открытие настроек вкладов$")
    public void clickSettings() {
        pageManager.getDepositPage().clickSettings();
    }

}
