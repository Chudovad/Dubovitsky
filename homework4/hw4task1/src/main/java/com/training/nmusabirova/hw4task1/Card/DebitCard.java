package com.training.nmusabirova.hw4task1.Card;

import com.training.nmusabirova.hw4task1.Check.Check;

import java.math.BigDecimal;

import static java.math.RoundingMode.DOWN;

public class DebitCard extends Card {
    public DebitCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }
    public DebitCard(String holderName) {
        super(holderName);
    }

    public boolean withdraw(BigDecimal amount) {
        boolean correctWithdraw = Check.checkWithdrawAmount(balance, amount);
        if (correctWithdraw) {
            balance = balance.subtract(amount).setScale(0, DOWN);
            System.out.println("Withdrawn amount: " + amount.toString());
        }
        return correctWithdraw;
    }
}
