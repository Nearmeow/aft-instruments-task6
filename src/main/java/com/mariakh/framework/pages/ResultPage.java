package com.mariakh.framework.pages;

import com.mariakh.framework.utils.StringHandler;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//div[@data-test='search-results']")
    private WebElement searchResults;

    public void checkOpenResultsPage(String expectedCount) {
        actions.moveToElement(searchResults).moveByOffset(-50, 0).build().perform();
        WebElement element = searchResults.findElement(By.xpath("./div/div/div[1]"));
        Assertions.assertEquals(expectedCount, StringHandler.cleanString(element.getText())
                , "Количество вкладов по выбранным критериям не соответствует ожидаемому.");
    }
}
