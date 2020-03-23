package com.training.nmusabirova.hw4task1.Atm;

import com.training.nmusabirova.hw4task1.Card.Card;
import com.training.nmusabirova.hw4task1.Card.CreditCard;
import com.training.nmusabirova.hw4task1.Card.DebitCard;
import com.training.nmusabirova.hw4task1.Check.Check;

import java.math.BigDecimal;

import static java.math.RoundingMode.DOWN;

public class Atm {
    private Card card;
    private static BigDecimal availableFunds = new BigDecimal(100);

    public Atm(DebitCard debitCard) {
        card = debitCard;
    }
    public Atm(CreditCard creditCard) {
        card = creditCard;
    }

    public boolean addCardBalance(BigDecimal amount) {
        boolean correctAdd = card.addCardBalance(amount);
        if (correctAdd) {
            addToAtm(amount);
        }
        return correctAdd;
    }
    public boolean withdraw(BigDecimal amount) {
        boolean correctWithdrawing = Check.checkWithdrawAmount(availableFunds, amount);
        if (Check.checkAmount(amount)) {
            if (!correctWithdrawing) {
                System.out.println("Not enough money in the ATM!");
            } else if (card.withdraw(amount)) {
                withdrawFromAtm(amount);
            }
        }
        return correctWithdrawing;
    }

    public void addToAtm(BigDecimal amount) {
        availableFunds = availableFunds.add(amount).setScale(0, DOWN);
    }

    public void withdrawFromAtm(BigDecimal amount) {
        availableFunds = availableFunds.subtract(amount).setScale(0, DOWN);
    }
}
