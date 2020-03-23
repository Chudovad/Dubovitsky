package com.training.nmusabirova.hw8task2;

import java.math.BigDecimal;
import java.util.*;

public class Contract {
    private ArrayList<Skills> needSkills;
    private ArrayList<Brigade> brigades;

    public Contract(ArrayList<Skills> needSkills, ArrayList<Brigade> brigades) {
        this.needSkills = needSkills;
        this.brigades = brigades;
    }

    public Brigade searchBrigadeWithNeededSkills() {
        ArrayList<Brigade> needBrigades = new ArrayList<Brigade>();
        for (Brigade brigade : brigades) {
            if (checkForSkills(brigade)) {
                needBrigades.add(brigade);
            }
        }
        if (searchBestBrigade(needBrigades) == null) {
            System.out.println("Construction is closed!");;
        }
        return searchBestBrigade(needBrigades);
    }

    private boolean checkForSkills(Brigade brigade) {
        int amount = 0;
        boolean check = false;
        if (checkSizeSkills(brigade.getSkills()) && checkSizeSkills(needSkills)) {
            for (Skills skill : brigade.getSkills()) {
                for (Skills skills : needSkills) {
                    if (skill == skills) {
                        amount++;
                    }
                }
            }
            if (brigade.getSkills().size() > needSkills.size()) {
                if (amount == needSkills.size()) {
                    check = true;
                }
            } else if (brigade.getSkills().size() == needSkills.size()) {
                if (amount == brigade.getSkills().size()) {
                    check = true;
                }
            }
        }
        return check;
    }

    private boolean checkSizeSkills(ArrayList<Skills> skill) {
        if (skill.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkSizeBrigades(ArrayList<Brigade> brigades) {
        if (brigades.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private Brigade searchBestBrigade(ArrayList<Brigade> needBrigades) {
        if (checkSizeBrigades(needBrigades)) {
            BigDecimal minFinance = needBrigades.get(0).getFinance();
            Brigade bestBrigade = needBrigades.get(0);
            for (Brigade brigade : needBrigades) {
                if (brigade.getFinance().compareTo(minFinance) == -1) {
                    bestBrigade = brigade;
                }
            }
            return bestBrigade;
        } else {
            return null;
        }
    }
}
