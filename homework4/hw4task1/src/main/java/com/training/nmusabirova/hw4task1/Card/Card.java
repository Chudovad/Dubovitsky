package com.training.nmusabirova.hw4task1.Card;

import com.training.nmusabirova.hw4task1.Check.Check;

import java.math.BigDecimal;

import static java.math.RoundingMode.DOWN;

public abstract class Card {
    protected String holderName;
    protected BigDecimal balance;

    public String getHolderName() {
        return holderName;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public Card(String holderName, BigDecimal balance) {
        boolean correctName = Check.checkName(holderName);
        boolean correctBalance = Check.checkAmount(balance);
        if (correctName && correctBalance) {
            this.holderName = holderName;
            this.balance = balance;
        } else {
            this.holderName = "Pavel";
            this.balance = BigDecimal.ZERO;
        }
    }
    public Card(String holderName) {
        if (Check.checkName(holderName)) {
            this.holderName = holderName;
        } else {
            this.holderName = "Pavel";
        }
        balance = BigDecimal.ZERO;
    }
    public boolean addCardBalance(BigDecimal amount) {
        boolean correctAmount = Check.checkAmount(amount);
        if (correctAmount) {
            balance = balance.add(amount).setScale(0, DOWN);
            System.out.print("Added amount: " + amount.toString());
        }
        return correctAmount;
    }

    public abstract boolean withdraw(BigDecimal amount);
    public boolean displayBalance(BigDecimal amount) {
        boolean correctAmount = Check.checkAmount(amount);
        if (correctAmount) {
            balance = balance.multiply(amount).setScale(0, DOWN);
        }
        return correctAmount;
    }
}
