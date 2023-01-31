package com.mariakh.tests.data;

import com.mariakh.framework.model.Deposit;

public class InputData {

    private String baseMenuName;
    private String amount;
    private String term;
    private String depositType;
    private String[] bankArray;
    private String[] checkboxArray;
    private String expectedCount;
    private Deposit expectedDeposit;

    public InputData(String baseMenuName, String amount, String term, String depositType, String[] bankArray
            , String[] checkboxArray, String expectedCount, Deposit expectedDeposit) {
        this.baseMenuName = baseMenuName;
        this.amount = amount;
        this.term = term;
        this.depositType = depositType;
        this.bankArray = bankArray;
        this.checkboxArray = checkboxArray;
        this.expectedCount = expectedCount;
        this.expectedDeposit = expectedDeposit;
    }

    public InputData() {
    }

    public String getBaseMenuName() {
        return baseMenuName;
    }

    public String getAmount() {
        return amount;
    }

    public String getTerm() {
        return term;
    }

    public String getDepositType() {
        return depositType;
    }

    public String[] getBankArray() {
        return bankArray;
    }

    public String[] getCheckboxArray() {
        return checkboxArray;
    }

    public String getExpectedCount() {
        return expectedCount;
    }

    public Deposit getExpectedDeposit() {
        return expectedDeposit;
    }
}
