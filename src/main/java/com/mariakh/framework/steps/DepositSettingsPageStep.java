package com.mariakh.framework.steps;

import com.mariakh.framework.managers.PageManager;
import io.cucumber.java.ru.И;

import java.util.Arrays;
import java.util.List;

public class DepositSettingsPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия настроек вкладов$")
    public void checkOpenDepositPage() {
        pageManager.getDepositSettingsPage().checkOpenDepositSettingsPage();
    }

    @И("^Заполнить поле значением - '(.+)'$")
    public void fillAmount(String amount) {
        pageManager.getDepositSettingsPage().fillAmount(amount);
    }

    @И("^Кликнуть на выпадающее меню '(.+)'$")
    public void clickDropDownButton(String fieldName) {
        pageManager.getDepositSettingsPage().clickDropDownButton(fieldName);
    }

    @И("^Выбрать из списка значение - '(.+)'$")
    public void chooseValue(String value) {
        pageManager.getDepositSettingsPage().chooseValue(value);
    }

    @И("^Выбрать банки из списка$")
    public void clickBanksArray(List<String> banksList) {
        pageManager.getDepositSettingsPage().clickBanksArray(banksList);
    }

    @И("^Отметить дополнительные чекбоксы$")
    public void clickAdditionalCheckboxes(List<String> checkboxList) {
        pageManager.getDepositSettingsPage().clickAdditionalCheckArray(checkboxList);
    }

    @И("^Нажать на кнопку поиска результатов$")
    public void clickSearch() {
        pageManager.getDepositSettingsPage().clickSearch();
    }
}
