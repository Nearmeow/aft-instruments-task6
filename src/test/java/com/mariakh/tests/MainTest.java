package com.mariakh.tests;

import com.mariakh.tests.base.BaseTests;
import com.mariakh.tests.data.InputData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest extends BaseTests {

    static InputData[] inData() {
        return new InputData[] {
                new InputData("deposits", "1000000", "6 месяцев", "Обычные вклады"
                        , new String[] {"Открытие", "Тинькофф", "ВТБ", "ГазпромБанк", "Сбербанк"}
                        , new String[] {"Со снятием", "С пополнением", "С капитализацией"}, "14"),
                new InputData("deposits", "500000", "2 года", "Детский"
                        , new String[] {"Ак Барс Банк", "РОССИЯ", "Сбербанк"}
                        , new String[] {"С выплатой процентов"}, "7")
        };
    }

    @ParameterizedTest
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
                .checkOpenResultsPage(inputData.getExpectedCount());
    }
    //@Test
    /*public void test() {
        pageManager.getStartPage().clickBaseMenu("deposits")
                .checkOpenDepositPage()
                .clickSettings()
                .fillAmount("1000000")
                .clickDropDownButton("Срок")
                .chooseValue("6 месяцев")
                .clickDropDownButton("Тип вклада")
                .chooseValue("Обычные вклады")
                .clickBanksButton("Открытие")
                .clickBanksButton("Тинькофф")
                .clickBanksButton("ВТБ")
                .clickBanksButton("ГазпромБанк")
                .clickBanksButton("Сбербанк")
                .clickAdditionalCheckbox("Со снятием")
                .clickAdditionalCheckbox("С пополнением")
                .clickAdditionalCheckbox("С капитализацией")
                .clickSearch()
                .checkOpenResultsPage();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/
}
