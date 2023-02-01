package com.mariakh.framework.pages;

import com.mariakh.framework.model.Deposit;
import com.mariakh.framework.utils.StringHandler;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//div[@data-test='search-results']")
    private WebElement searchResults;
    @FindBy(xpath = "//div[contains(@class, 'SearchResults')]")
    private List<WebElement> resultItems;

    @Step("Проверить, что страница результатов открылась, ожидаемое количество вкладов в списке - {expectedCount}")
    public ResultPage checkOpenResultsPage(String expectedCount) {
        //actions.moveToElement(searchResults, -200, 0).click().build().perform();
        actions.sendKeys(Keys.TAB).click().build().perform();
        WebElement element = searchResults.findElement(By.xpath("./div/div/div[1]"));
        Assertions.assertEquals(expectedCount, StringHandler.cleanString(element.getText())
                , "Количество вкладов по выбранным критериям не соответствует ожидаемому.");
        return this;
    }

    @Step("Проверить, что ожидаемый вклад есть в списке")
    public ResultPage depositCheck(Deposit deposit) {
        WebElement expectedBank = getResultItemByBankName(deposit.getBank());
        String actualRate = StringHandler.cleanString(expectedBank.findElement(By.xpath(".//span[text()='Cтавка']/../../following-sibling::div")).getText());
        String actualTerm = StringHandler.cleanString(expectedBank.findElement(By.xpath(".//div[text()='Срок']/following-sibling::div")).getText());
        String actualIncome = StringHandler.cleanString(expectedBank.findElement(By.xpath(".//div[text()='Доход']/following-sibling::div")).getText());

        Assertions.assertAll(
                () -> Assertions.assertEquals(deposit.getRate(), actualRate, "Актуальная ставка не соответствует ожидаемой."),
                () -> Assertions.assertEquals(deposit.getTerm(), actualTerm, "Актуальный срок не соответствует ожидаемому."),
                () -> Assertions.assertEquals(deposit.getIncome(), actualIncome, "Актуальный доход не соответствует ожидаемому.")
        );
        return this;

    }

    private WebElement getResultItemByBankName(String bank) {
        for (WebElement elem : resultItems) {
            if (elem.findElement(By.xpath(".//div[@data-test='text']")).getText().equals(bank)) {
                return elem;
            }
        }
        Assertions.fail("Не нашли банк " + bank + " в списке результатов.");
        return null;
    }
}
