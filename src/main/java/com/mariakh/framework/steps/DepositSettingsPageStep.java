package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import com.mariakh.framework.pages.DepositSettingsPage;
import io.cucumber.java.ru.И;

import java.util.Arrays;
import java.util.List;

public class DepositSettingsPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия настроек вкладов$")
    public void checkOpenDepositPage() {
        pageManager.getPage(DepositSettingsPage.class).checkOpenDepositSettingsPage();
    }

    @И("^Заполнить поле значением - '(.+)'$")
    public void fillAmount(String amount) {
        pageManager.getPage(DepositSettingsPage.class).fillAmount(amount);
    }

    @И("^Кликнуть на выпадающее меню '(.+)'$")
    public void clickDropDownButton(String fieldName) {
        pageManager.getPage(DepositSettingsPage.class).clickDropDownButton(fieldName);
    }

    @И("^Выбрать из списка значение - '(.+)'$")
    public void chooseValue(String value) {
        pageManager.getPage(DepositSettingsPage.class).chooseValue(value);
    }

    @И("^Выбрать банки из списка - (.*)$")
    public void clickBanksArray(String banksStr) {
        List<String> banks = Arrays.asList(banksStr.split("\\s*,\\s*"));
        pageManager.getPage(DepositSettingsPage.class).clickBanksArray(banks);
    }

    @И("^Отметить дополнительные чекбоксы - (.*)$")
    public void clickAdditionalCheckboxes(String checkboxStr) {
        List<String> checkboxList = Arrays.asList(checkboxStr.split("\\s*,\\s*"));
        pageManager.getPage(DepositSettingsPage.class).clickAdditionalCheckArray(checkboxList);
    }

    @И("^Нажать на кнопку поиска результатов$")
    public void clickSearch() {
        pageManager.getPage(DepositSettingsPage.class).clickSearch();
    }
}
