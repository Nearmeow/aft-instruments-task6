package com.mariakh.framework.model;

public class Deposit {

    private String bank;
    private String rate;
    private String term;
    private String income;

    public Deposit(String bank, String rate, String term, String income) {
        this.bank = bank;
        this.rate = rate;
        this.term = term;
        this.income = income;
    }

    public Deposit() {
    }

    public String getBank() {
        return bank;
    }

    public String getRate() {
        return rate;
    }

    public String getTerm() {
        return term;
    }

    public String getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Вклад{" +
                "Банк='" + bank + '\'' +
                ", Ставка='" + rate + '\'' +
                ", Срок='" + term + '\'' +
                ", Доход='" + income + '\'' +
                '}';
    }
}
