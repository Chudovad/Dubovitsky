package com.training.nmusabirova.hw10;

import java.math.BigDecimal;

public class Card {
    private boolean check;
    private String holderName;
    private BigDecimal balance;

    public Card(String holderName, BigDecimal balance) {
        checkName(holderName);
        checkBalance(balance);
        this.holderName = holderName;
        this.balance = balance;
        check = true;
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

    public synchronized void addCardBalance(BigDecimal amount) {
        if (check) {
            checkAddAmount(amount);
            balance = balance.add(amount);
            check = false;
            if (checkBalanceForRange(balance)) {
                System.out.println("Added " + amount + " dollars. Balance: " + getCardBalance());
                check = true;
            } else {
                System.out.println("Balance reached 1000 dollars.");
            }
        }
    }

    public synchronized void withdrawFromCardBalance(BigDecimal amount) {
        if (check) {
            check = false;
            balance = balance.subtract(amount);
            if (checkBalanceForRange(balance)) {
                check = true;
                System.out.println("Withdrawn " + amount + " dollars. Balance: " + getCardBalance());
            } else {
                System.out.println("Balance reached 0 dollars.");
            }
        }
    }

    public BigDecimal getAnotherCurrency(BigDecimal exchangeRate) {
        checkAddAmount(exchangeRate);
        return balance.multiply(exchangeRate);
    }

    public boolean checkBalanceForRange(BigDecimal number) {
        return ((number.compareTo(new BigDecimal(1000)) == -1) && (number.compareTo(BigDecimal.ZERO) == 1));
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
