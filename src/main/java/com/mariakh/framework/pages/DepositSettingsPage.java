package com.mariakh.framework.pages;

import com.mariakh.framework.utils.StringHandler;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DepositSettingsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]")
    private WebElement settingsBlock;
    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountInput;
    @FindBy(xpath = "//div[@data-placement='bottom']//ul/li")
    private List<WebElement> dropDownList;
    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]//input[@type='text' and not(@name)]")
    private WebElement banksInput;
    @FindBy(xpath = "//div[@data-placement='bottom']//ul[last()]")
    private WebElement banksElem;
    @FindBy(xpath = "//input[@type='checkbox']/..")
    private List<WebElement> checkboxList;
    @FindBy(xpath = "//div[contains(@class, 'StyledBottom')]/button")
    private WebElement searchButton;

    public DepositSettingsPage checkOpenDepositSettingsPage() {
        Assertions.assertTrue(searchButton.isDisplayed(), "Блок параметров выбора вклада не отображен на странице.");
        return this;
    }

    public DepositSettingsPage fillAmount(String amount) {
        amountInput.sendKeys(amount);
        wait.until(ExpectedConditions.attributeToBe(amountInput, "value", StringHandler.getFormattedString(amount)));
        return this;
    }

    public DepositSettingsPage clickDropDownButton(String fieldName) {
        WebElement dropDownMenuButton = settingsBlock.findElement(By.xpath(".//label[text()='" + fieldName + "']/..//div[@role]"));
        dropDownMenuButton.click();
        wait.until(ExpectedConditions.attributeToBe(dropDownMenuButton, "aria-pressed", "true"));
        return this;
    }

    public DepositSettingsPage chooseValue(String value) {
        waitStabilityPage(2500, 250);
        for (WebElement elem : dropDownList) {
            if (elem.findElement(By.xpath("./div")).getText().contains(value)) {
                elem.click();
                Assertions.assertEquals(settingsBlock.findElement(By.xpath(".//span[text()='" + value + "']"))
                        .getAttribute("color"), "minorDarkBlue", "Поле выпадающего меню не содержит ожидаемого значения - " + value);
                return this;
            }
        }
        Assertions.fail("Не нашли значение " + value + " в выпадающем списке.");
        return this;
    }

    public DepositSettingsPage clickBanksArray(List<String> banksList) {
        for (String bank : banksList) {
            banksInput.click();
            banksInput.sendKeys(bank);
            waitStabilityPage(3000, 250);
            List<WebElement> bankListByName = banksElem.findElements(By.xpath("./li"));
            bankListByName.get(0).findElement(By.xpath(".//input[not (@checked)]/../span[1]")).click();
            banksInput.click();
        }
        return this;
    }

    public DepositSettingsPage clickAdditionalCheckArray(List<String> checkboxList) {
        for (String checkbox : checkboxList) {
            getCheckboxByName(checkbox).click();
            waitStabilityPage(3000, 250);
        }
        return this;
    }

    public ResultPage clickSearch() {
        searchButton.click();
        return pageManager.getPage(ResultPage.class);
    }

    private WebElement getCheckboxByName(String checkboxName) {
        for (WebElement element : checkboxList) {
            if (element.findElement(By.xpath("./span[2]")).getText().contains(checkboxName)) {
                return element.findElement(By.xpath("./span[1]"));
            }
        }
        Assertions.fail("Не найден чекбокс с текстом " + checkboxName);
        return null;
    }
}
