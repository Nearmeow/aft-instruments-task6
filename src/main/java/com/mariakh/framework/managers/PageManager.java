package com.mariakh.framework.managers;

import com.mariakh.framework.pages.DepositPage;
import com.mariakh.framework.pages.DepositSettingsPage;
import com.mariakh.framework.pages.ResultPage;
import com.mariakh.framework.pages.StartPage;

public class PageManager {

    private static PageManager instance;
    private StartPage startPage;
    private DepositPage depositPage;
    private DepositSettingsPage depositSettingsPage;

    private ResultPage resultPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public DepositPage getDepositPage() {
        if (depositPage == null) {
            depositPage = new DepositPage();
        }
        return depositPage;
    }

    public DepositSettingsPage getDepositSettingsPage() {
        if (depositSettingsPage == null) {
            depositSettingsPage = new DepositSettingsPage();
        }
        return depositSettingsPage;
    }

    public ResultPage getResultPage() {
        if (resultPage == null) {
            resultPage = new ResultPage();
        }
        return resultPage;
    }
}
