package com.training.nmusabirova.hw4task1.Check;

import java.math.BigDecimal;

public class Check {
    public static boolean checkName(String holderName) {
        boolean correctName = (holderName != null) && (holderName != "");
        if (! correctName) {
            System.out.println("Error! The name cannot be empty string or zero!");
        }
        return correctName;
    }

    public static boolean checkAmount(BigDecimal amount) {
        boolean correctAmount = (amount != null) && (amount.compareTo(BigDecimal.ZERO) == 1);
        if (! correctAmount) {
            System.out.println("Error! The number must be positive!");
        }
        return correctAmount;
    }
    public static boolean checkWithdrawAmount(BigDecimal balance, BigDecimal amount) {
        boolean correctWithdrawAmount = (amount != null) && (amount.compareTo(BigDecimal.ZERO) == 1) && (amount.compareTo(balance) != 1);
        if (!correctWithdrawAmount) {
            System.out.println("The number must be positive and exceed balance!");
        }
        return correctWithdrawAmount;
    }
}
