package com.training.nmusabirova.hw8task2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Brigade {
    private String name;
    private ArrayList<Worker> workers = new ArrayList<>();
    private BigDecimal finance = BigDecimal.ZERO;

    public Brigade(String name, Worker... workers) {
        this.name = name;
        this.workers.addAll(Arrays.asList(workers));
        for (Worker worker : workers) {
            finance = finance.add(worker.getFinance());
        }
    }

    public ArrayList<Skills> getSkills() {
        ArrayList<Skills> skills = new ArrayList<>();
        for (Worker worker : workers) {
            for (Skills skill : worker.skills) {
                if (!skills.contains(skill)) {
                    skills.add(skill);
                }
            }
        }
        return skills;
    }

    public BigDecimal getFinance() {
        return finance;
    }
}
