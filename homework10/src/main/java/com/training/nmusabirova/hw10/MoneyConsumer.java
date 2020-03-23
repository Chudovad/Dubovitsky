package com.training.nmusabirova.hw10;

import java.math.BigDecimal;

public class MoneyConsumer extends Thread {
    private Card card;
    private int min = 5;
    private int max = 10;

    public MoneyConsumer(Card card) {
        this.card = card;
    }

    @Override
    public synchronized void run() {
        while (card.checkBalanceForRange(card.getCardBalance())) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            int rnd = rnd(min, max);
            card.withdrawFromCardBalance(BigDecimal.valueOf(rnd));
        }
    }

    private int rnd(int min, int max) {
        int diapason = max - min;
        return (int) (Math.random() * diapason) + min;
    }
}
