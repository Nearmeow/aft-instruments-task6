package com.mariakh.framework.managers;

import java.time.Duration;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getInstance();

    private static final TestPropManager props = TestPropManager.getInstance();
    private static PageManager pageManager = PageManager.getInstance();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty("implicitly.wait"))));
        driverManager.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty("page.load.timeout"))));
        driverManager.getDriver().get(props.getProperty("base.url"));
    }

    public static void quitFramework() {
        driverManager.quitDriver();
        pageManager.clearPages();
    }
}
