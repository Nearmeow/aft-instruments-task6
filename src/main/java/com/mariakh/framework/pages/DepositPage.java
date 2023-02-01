package com.mariakh.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//h1[@itemprop]")
    private WebElement title;

    @FindBy(xpath = "//div[@id='deposit_search_form']//button[@data-role='button'][1]")
    private WebElement settingsButton;

    @Step("Проверить, что страница 'Вклады' открылась")
    public DepositPage checkOpenDepositPage() {
        assertTrue(title.getText().contains("Вклады"), "Заголовок не соответствует ожидаемому.");
        return this;
    }

    @Step("Перейти в раздел настроек вкладов")
    public DepositSettingsPage clickSettings() {
        settingsButton.click();
        return pageManager.getDepositSettingsPage();
    }
}
