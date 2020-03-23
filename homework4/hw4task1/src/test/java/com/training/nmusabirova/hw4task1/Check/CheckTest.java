package com.training.nmusabirova.hw4task1.Check;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CheckTest {

    private static final boolean TRUE = true;
    private static final boolean FALSE = false;
    private static final String NAME_OWNER = "Maxim";
    private static final String EMPTY_NAME_OWNER = "";
    private static final BigDecimal BALANCE = new BigDecimal(100);
    private static final BigDecimal EMPTY_BALANCE = null;
    private static final BigDecimal AMOUNT = new BigDecimal(500);
    private static final BigDecimal NEGATIVE_AMOUNT = new BigDecimal(-50);

    @Test
    public void testCheckNamePositiveCase() {
        assertEquals(TRUE, Check.checkName(NAME_OWNER));
    }

    @Test
    public void testCheckNameNegativeCase() {
        assertEquals(FALSE, Check.checkName(EMPTY_NAME_OWNER));
    }

    @Test
    public void testCheckAmountPositiveCase() {
        assertEquals(TRUE, Check.checkAmount(BALANCE));
    }

    @Test
    public void testCheckAmountNegativeCase() {
        assertEquals(FALSE, Check.checkAmount(NEGATIVE_AMOUNT));
    }

    @Test
    public void testCheckAmountForEmptiness() {
        assertEquals(FALSE, Check.checkAmount(EMPTY_BALANCE));
    }

    @Test
    public void testCheckWithdrawAmountPositiveCase() {
        assertEquals(TRUE, Check.checkWithdrawAmount(BALANCE, BALANCE));
    }

    @Test
    public void testCheckWithdrawAmountNegativeCase() {
        assertEquals(FALSE, Check.checkWithdrawAmount(BALANCE, AMOUNT));
    }
}