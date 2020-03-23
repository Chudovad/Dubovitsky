package com.training.nmusabirova.hw8task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContractTest {
    private static final Object NULL = null;
    private static final BigDecimal FIFTY = new BigDecimal(50.00);
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100.00);
    private static final Brigade BRIGADE_ONE = new Brigade("Brigade1",
            new Worker(FIFTY, Skills.DRAWING_UP_ESTIMATED_DOCUMENTATION, Skills.BASIC_LEVEL_OF_PC_OWNERSHIP),
            new Worker(ONE_HUNDRED, Skills.TECHNICAL_EVALUATION_OF_PROJECT, Skills.REPLACEMENT_ELECTRICAL_WIRING),
            new Worker(FIFTY, Skills.BASIC_LEVEL_OF_PC_OWNERSHIP, Skills.READ_DRAWINGS, Skills.TEAMWORK));
    private static final Brigade BRIGADE_TWO = new Brigade("Brigade2",
            new Worker(FIFTY, Skills.FINISHING_WORKS, Skills.KNOWLEDGE_OF_ENGLISH, Skills.TEAMWORK),
            new Worker(FIFTY, Skills.KNOWLEDGE_OF_MATERIAL_PROPERTIES, Skills.MANAGEMENT_OF_CONSTRUCTION_BRIGADE));
    private static final Brigade BRIGADE_THREE = new Brigade("Brigade3",
            new Worker(ONE_HUNDRED, Skills.MANAGEMENT_OF_CONSTRUCTION_BRIGADE),
            new Worker(ONE_HUNDRED, Skills.BASIC_LEVEL_OF_PC_OWNERSHIP, Skills.MANAGEMENT_OF_CONSTRUCTION_BRIGADE),
            new Worker(FIFTY, Skills.TEAMWORK, Skills.DRAWING_UP_ESTIMATED_DOCUMENTATION, Skills.ECONOMIC_EVALUATION_OF_PROJECT));
    private Contract contract;
    ArrayList<Brigade> brigades;
    private ArrayList<Skills> skills;


    @Before
    public void init() {
        brigades = new ArrayList<>();
        brigades.add(BRIGADE_ONE);
        brigades.add(BRIGADE_TWO);
        brigades.add(BRIGADE_THREE);

    }

    @Test
    public void testSearchBrigadePositiveCase() {
        skills = new ArrayList<>();
        skills.add(Skills.BASIC_LEVEL_OF_PC_OWNERSHIP);
        skills.add(Skills.READ_DRAWINGS);
        skills.add(Skills.TEAMWORK);
        contract = new Contract(skills, brigades);
        Assert.assertEquals(BRIGADE_ONE, contract.searchBrigadeWithNeededSkills());
    }

    @Test
    public void testSearchBrigadeNegativeCase() {
        skills = new ArrayList<>();
        skills.add(Skills.KNOWLEDGE_OF_ENGLISH);
        skills.add(Skills.KNOWLEDGE_OF_MATERIAL_PROPERTIES);
        skills.add(Skills.WORK_WITH_POWER_TOOLS);
        contract = new Contract(skills, brigades);
        Assert.assertEquals(NULL, contract.searchBrigadeWithNeededSkills());
    }
}