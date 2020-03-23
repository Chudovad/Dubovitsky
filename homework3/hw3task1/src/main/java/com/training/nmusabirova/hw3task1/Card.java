package com.training.nmusabirova.hw3task1;

import java.math.BigDecimal;

public class Card {
    private String holderName;
    private BigDecimal balance;

    public Card(String holderName, BigDecimal balance) {
        checkName(holderName);
        checkBalance(balance);
        this.holderName = holderName;
        this.balance = balance;
    }

    public Card(String holderName) {
        checkName(holderName);
        this.holderName = holderName;
        balance = BigDecimal.ZERO;
    }

    public String getHolderName() {
        return holderName;
    }

    public BigDecimal getCardBalance() {
        return balance;
    }

    public void addCardBalance(BigDecimal amount) {
        checkAddAmount(amount);
        balance = balance.add(amount);
    }

    public void withdrawFromCardBalance(BigDecimal amount) {
        checkWithdrawAmount(balance, amount);
        balance = balance.subtract(amount);
    }

    public BigDecimal getAnotherCurrency(BigDecimal exchangeRate) {
        checkAddAmount(exchangeRate);
        return balance.multiply(exchangeRate);
    }

    private void checkName(String holderName) {
        if (!holderName.matches("^[a-zA-Z]+")) {
            throw new IllegalArgumentException("Error! The name cannot be empty string or zero!");
        }
    }

    private void checkBalance(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) != 1) {
            throw new IllegalArgumentException("Error! Card Balance cannot be negative or zero!");
        }
    }

    private void checkAddAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) != 1) {
            throw new IllegalArgumentException("Error! The number must be positive!");
        }
    }

    private void checkWithdrawAmount(BigDecimal balance, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) != 1 || amount.compareTo(balance) == 1) {
            throw new IllegalArgumentException("The number must be positive and exceed balance!");
        }
    }
}