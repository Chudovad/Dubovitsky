package com.training.nmusabirova.hw8task2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Worker {
    public ArrayList<Skills> skills = new ArrayList<>();
    private BigDecimal finance;

    public Worker(BigDecimal finance, Skills... skills) {
        checkFinance(finance);
        this.finance = finance;
        this.skills.addAll(Arrays.asList(skills));
    }

    public BigDecimal getFinance() {
        return finance;
    }

    private void checkFinance(BigDecimal finance) {
        if (finance.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Error! Finance cannot be negative.");
        }
    }
}
