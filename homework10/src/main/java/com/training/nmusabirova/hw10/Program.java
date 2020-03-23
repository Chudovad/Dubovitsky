package com.training.nmusabirova.hw10;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {
    public static void main(String[] args) {
        Card card = new Card("Pavel", new BigDecimal(500));

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 1; i < 4; i++) {
            executorService.submit(new MoneyConsumer(card));
            executorService.submit(new MoneyProducer(card));
        }
        /*
        for (int i = 1; i < 4; i++) {
            Thread thread1 = new Thread(new MoneyProducer(card));
            thread1.setName("MoneyProducer " + i);
            Thread thread2 = new Thread(new MoneyConsumer(card));
            thread2.setName("MoneyConsumer " + i);
            thread1.start();
            thread2.start();
        }
        */
    }
}
