package com.mariakh.framework.managers;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static DriverManager instance = null;

    private WebDriver driver;

    private TestPropManager propManager = TestPropManager.getInstance();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        if (OS.isFamilyWindows()) {
            initDriverWindowsOsFamily();
        } else if (OS.isFamilyMac()) {
            initDriverMacOsFamily();
        }   else if (OS.isFamilyUnix()) {
            initDriverUnixOsFamily();
        }
    }

    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily(propManager.getProperty("path.chrome.driver.windows")
        , propManager.getProperty("path.firefox.driver.windows")
        , propManager.getProperty("path.edge.driver.windows"));
    }

    private void initDriverMacOsFamily() {
        initDriverAnyOsFamily(propManager.getProperty("path.chrome.driver.mac")
                , propManager.getProperty("path.firefox.driver.mac")
                , propManager.getProperty("path.edge.driver.mac"));
    }

    private void initDriverUnixOsFamily() {
        initDriverAnyOsFamily(propManager.getProperty("path.chrome.driver.unix")
                , propManager.getProperty("path.firefox.driver.unix")
                , propManager.getProperty("path.edge.driver.unix"));
    }

    private void initDriverAnyOsFamily(String chrome, String gecko, String edge) {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", chrome);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", gecko);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", edge);
                driver = new EdgeDriver();
                break;
        }
    }
}
