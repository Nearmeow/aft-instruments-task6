package com.mariakh.tests;

import com.mariakh.framework.model.Deposit;
import com.mariakh.tests.base.BaseTests;
import com.mariakh.tests.data.InputData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest extends BaseTests {

    static InputData[] inData() {
        return new InputData[] {
                new InputData("deposits", "1000000", "6 месяцев", "Обычные вклады"
                        , new String[] {"Открытие", "Тинькофф", "ВТБ", "ГазпромБанк", "Сбербанк"}
                        , new String[] {"Со снятием", "С пополнением", "С капитализацией"}, "13"
                , new Deposit("Газпромбанк", "6,67", "182", "33726")),
                new InputData("deposits", "500000", "2 года", "Детский"
                        , new String[] {"Ак Барс Банк", "РОССИЯ", "Сбербанк"}
                        , new String[] {"С выплатой процентов"}, "7"
                , new Deposit("Сбербанк", "6,80", "730", "72514"))
        };
    }

    @ParameterizedTest(name = "Проверка настройки вкладов")
    @MethodSource("inData")
    public void myTest(InputData inputData) {
        pageManager.getStartPage().clickBaseMenu(inputData.getBaseMenuName())
                .checkOpenDepositPage()
                .clickSettings()
                .checkOpenDepositSettingsPage()
                .fillAmount(inputData.getAmount())
                .clickDropDownButton("Срок")
                .chooseValue(inputData.getTerm())
                .clickDropDownButton("Тип вклада")
                .chooseValue(inputData.getDepositType())
                .clickBanksArray(inputData.getBankArray())
                .clickAdditionalCheckArray(inputData.getCheckboxArray())
                .clickSearch()
                .checkOpenResultsPage(inputData.getExpectedCount())
                .depositCheck(inputData.getExpectedDeposit());

    }
}
