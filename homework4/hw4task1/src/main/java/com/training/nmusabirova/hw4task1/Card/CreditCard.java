package com.training.nmusabirova.hw4task1.Card;

import com.training.nmusabirova.hw4task1.Check.Check;

import java.math.BigDecimal;

import static java.math.RoundingMode.DOWN;

public class CreditCard extends Card {
    private BigDecimal debt;

    public BigDecimal getDebt() {
        return debt;
    }

    public CreditCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
        debt = BigDecimal.ZERO;
    }
    public CreditCard(String holderName) {
        super(holderName);
        debt = BigDecimal.ZERO;
    }

    public boolean withdraw(BigDecimal amount) {
        boolean correctWithdrawAmount = Check.checkWithdrawAmount(balance, amount);
        if (Check.checkAmount(amount)) {
            if (!correctWithdrawAmount) {
                BigDecimal debt = amount.subtract(balance).setScale(0, DOWN);
                balance = BigDecimal.ZERO;
                System.out.println("Balance: " + balance.toString());
                System.out.println("Amount of debt: " + debt.toString());
                correctWithdrawAmount = true;
            } else {
                System.out.println("Withdrawn amount " + amount.toString());
                balance = balance.subtract(amount).setScale(0, DOWN);
            }
        }
        return correctWithdrawAmount;
    }
}
