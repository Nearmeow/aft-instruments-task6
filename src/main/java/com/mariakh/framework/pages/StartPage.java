package com.mariakh.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//li[@class='main-menu__sections-item ']")
    private List<WebElement> baseMenuLinksList;

    public DepositPage clickBaseMenu(String linkName) {
        for (WebElement elem : baseMenuLinksList) {
            if (elem.getAttribute("data-submenu-idx").equals(linkName)) {
                elem.findElement(By.xpath("./div/a")).click();
                return pageManager.getDepositPage();
            }
        }
        Assertions.fail("Меню по заданному имени не найдено.");
        return pageManager.getDepositPage();
    }

}
