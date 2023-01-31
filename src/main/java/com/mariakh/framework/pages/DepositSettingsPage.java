package com.mariakh.framework.pages;

import com.mariakh.framework.utils.StringHandler;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.file.WatchEvent;
import java.util.List;

public class DepositSettingsPage extends BasePage {

    //@FindBy(xpath = "//div[contains(@class, 'ModalBody')]")
    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]")
    private WebElement settingsBlock;
    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountInput;

    @FindBy(xpath = "//div[@data-test='dropdown-button']")
    private WebElement termButton;

    //@FindBy(xpath = "//div[contains(@class, 'ModalBody')]//div[@tabindex='1']")
    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]//div[@tabindex='1']")
    private List<WebElement> dropDownMenuList;

    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]//label[text()='Срок']/..")
    private WebElement termMenu;

    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]//label[text()='Тип вклада']/..")
    private WebElement depositTypeMenu;

    //@FindBy(xpath = "//div[@tabindex='1']//li[contains(@class, 'DropdownList')]")
    @FindBy(xpath = "//div[@data-placement='bottom']//ul/li")
    private List<WebElement> termList;

    //@FindBy(xpath = "//div[contains(@class, 'ModalBody')]//div[@data-test='dropdown']")
    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]//div[@data-test='dropdown']")
    private List<WebElement> settingBlockFields;

    //@FindBy(xpath = "//div[contains(@class, 'ModalBody')]//input[@type='text' and not(@name)]")
    @FindBy(xpath = "//div[contains(@class, 'StyledBody')]//input[@type='text' and not(@name)]")
    private WebElement banksInput;

    @FindBy(xpath = "//li[contains(@class, 'MultiSelect')]")
    private List<WebElement> banksList;

    //@FindBy(xpath = "//div[@data-placement='bottom']//div[contains(@class, 'MultiSelectDropdown')]/ul[last()]")
    //div[@data-placement='bottom']//ul/li[last()]
    @FindBy(xpath = "//div[@data-placement='bottom']//ul[last()]")
    private WebElement banksElem;


    //@FindBy(xpath = "//label[contains(@class, 'Checkbox')]")
    @FindBy(xpath = "//input[@type='checkbox']/..")
    private List<WebElement> checkboxList;

    //@FindBy(xpath = "//div[contains(@class, 'ModalBody')]//button[@type='button']")
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
    //label[text()='Срок вклада']/..//div[@role]
    public DepositSettingsPage clickDropDownButton(String fieldName) {
        WebElement dropDownMenuButton = settingsBlock.findElement(By.xpath(".//label[text()='" + fieldName + "']/..//div[@role]"));
        dropDownMenuButton.click();
        wait.until(ExpectedConditions.attributeToBe(dropDownMenuButton, "aria-pressed", "true"));

        /*for (WebElement elem : dropDownMenuList) {
            if (elem.findElement(By.xpath("./label")).getText().contains(fieldName)) {
                WebElement termButton = elem.findElement(By.xpath(".//div[@role='button']"));
                termButton.click();
                wait.until(ExpectedConditions.attributeToBe(termButton, "aria-pressed", "true"));
            }
        }*/
        return this;
    }
//div[data-placement='bottom']
    public DepositSettingsPage chooseValue(String term) {
        waitStabilityPage(2500, 250);
        for (WebElement elem : termList) {
            if (elem.findElement(By.xpath("./div")).getText().contains(term)) {
                elem.click();
                return this;
            }
        }
        Assertions.fail("Не смогли кликнуть на значение - " + term);
        return this;
    }

    public DepositSettingsPage clickBanksArray(String[] banksArray) {
        for (String bank : banksArray) {
            banksInput.click();
            banksInput.sendKeys(bank);
            waitStabilityPage(3000, 250);
            List<WebElement> bankListByName = banksElem.findElements(By.xpath("./li"));
            bankListByName.get(0).findElement(By.xpath(".//input[not (@checked)]/../span[1]")).click();
            banksInput.click();
        }
        return this;
    }

    public DepositSettingsPage clickAdditionalCheckArray(String[] checkboxArray) {
        for (String checkbox : checkboxArray) {
            getCheckboxByName(checkbox).click();
            waitStabilityPage(3000, 250);
        }
        return this;
    }

    public ResultPage clickSearch() {
        searchButton.click();
        return pageManager.getResultPage();
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
