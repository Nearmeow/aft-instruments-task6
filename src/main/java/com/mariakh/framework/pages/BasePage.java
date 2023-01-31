package com.mariakh.framework.pages;

import com.mariakh.framework.managers.DriverManager;
import com.mariakh.framework.managers.PageManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(1));

    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

    protected Actions actions = new Actions(driverManager.getDriver());

    protected Duration clickDelay = Duration.ofMillis(300);

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    protected void waitStabilityPage(int maxWaitMillis, int pollDelimiter) {
        double startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + maxWaitMillis) {
            String prevState = driverManager.getDriver().getPageSource();
            sleep(pollDelimiter);
            if (prevState.equals(driverManager.getDriver().getPageSource())) {
                return;
            }
        }
    }

    protected void scrollToPageTop() {
        js.executeScript("window.scrollTo(0, document.body.scrollTop);");
    }

    protected void scrollToPageBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
