package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import com.mariakh.framework.pages.DepositPage;
import io.cucumber.java.ru.И;

public class DepositPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия страницы 'Вклады'$")
    public void checkOpenDepositPage() {
        pageManager.getPage(DepositPage.class).checkOpenDepositPage();
    }

    @И("^Открытие настроек вкладов$")
    public void clickSettings() {
        pageManager.getPage(DepositPage.class).clickSettings();
    }

}
