package com.mariakh.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//h1[@itemprop]")
    private WebElement title;

    @FindBy(xpath = "//div[@id='deposit_search_form']//button[@data-role='button'][1]")
    private WebElement settingsButton;

    public DepositPage checkOpenDepositPage() {
        assertTrue(title.getText().contains("Вклады"), "Заголовок не соответствует ожидаемому.");
        return this;
    }

    public DepositSettingsPage clickSettings() {
        settingsButton.click();
        return pageManager.getPage(DepositSettingsPage.class);
    }
}
