package com.training.nmusabirova.hw4task1.Card;

import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class CreditCardTest {

    private static final boolean TRUE = true;
    private static final boolean FALSE = false;
    private static final String NAME_PAVEL = "Pavel";
    private static final String NAME_OWNER = "Alex";
    private static final String EMPTY_NAME_OWNER = "";
    private static final BigDecimal TWENTY_NINE_HUNDREDTH = new BigDecimal("0.29");
    private static final BigDecimal TWENTY_NINE = new BigDecimal("29");
    private static final BigDecimal FIFTY = new BigDecimal(50);
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private static final BigDecimal EMPTY_BALANCE = null;
    private static final BigDecimal NEGATIVE_AMOUNT = new BigDecimal(-50);

    CreditCard card;
    CreditCard cardWithoutBalance;

    @Before
    public void init() {
        card = new CreditCard(NAME_OWNER, ONE_HUNDRED);
        cardWithoutBalance = new CreditCard(NAME_OWNER);
    }

    @Test
    public void testFirstConstructorForNamePositiveCase() {
        assertEquals(NAME_OWNER, card.getHolderName());
    }

    @Test
    public void testFirstConstructorForNameNegativeCase() {
        card = new CreditCard(EMPTY_NAME_OWNER, ONE_HUNDRED);
        assertEquals(NAME_PAVEL, card.getHolderName());
    }

    @Test
    public void testFirstConstructorForBalancePositiveCase() {
        assertEquals(ONE_HUNDRED, card.getBalance());
    }

    @Test
    public void testFirstConstructorForBalanceNegativeCase() {
        card = new CreditCard(NAME_OWNER, NEGATIVE_AMOUNT);
        assertEquals(BigDecimal.ZERO, card.getBalance());
    }

    @Test
    public void testFirstConstructorGetBalanceForNull() {
        card = new CreditCard(NAME_OWNER, EMPTY_BALANCE);
        assertEquals(BigDecimal.ZERO, card.getBalance());
    }

    @Test
    public void testSecondConstructorForNamePositiveCase() {
        assertEquals(NAME_OWNER, cardWithoutBalance.getHolderName());
    }

    @Test
    public void testSecondConstructorForNameNegativeCase() {
        cardWithoutBalance = new CreditCard(EMPTY_NAME_OWNER);
        assertEquals(NAME_PAVEL, cardWithoutBalance.getHolderName());
    }

    @Test
    public void testSecondConstructorForBalance() {
        assertEquals(BigDecimal.ZERO, cardWithoutBalance.getBalance());
    }

    @Test
    public void testAddCardBalancePositiveCase() {
        assertEquals(TRUE, cardWithoutBalance.addCardBalance(FIFTY));
        assertEquals(FIFTY, cardWithoutBalance.getBalance());
    }

    @Test
    public void testAddCardBalanceNegativeCase() {
        assertEquals(FALSE, card.addCardBalance(NEGATIVE_AMOUNT));
        assertEquals(ONE_HUNDRED, card.getBalance());
    }

    @Test
    public void testAddCardBalanceForNull() {
        assertEquals(FALSE, card.addCardBalance(EMPTY_BALANCE));
        assertEquals(ONE_HUNDRED, card.getBalance());
    }

    @Test
    public void testWithdrawPositiveCase() {
        assertEquals(TRUE, card.withdraw(FIFTY));
        assertEquals(FIFTY, card.getBalance());
    }

    @Test
    public void testWithdrawNegativeCase() {
        assertEquals(FALSE, card.withdraw(NEGATIVE_AMOUNT));
        assertEquals(ONE_HUNDRED, card.getBalance());
    }

    @Test
    public void testWithdrawForNull() {
        assertEquals(FALSE, card.withdraw(EMPTY_BALANCE));
        assertEquals(ONE_HUNDRED, card.getBalance());
    }

    @Test
    public void testWithdrawLargeAmount() {
        card = new CreditCard(NAME_OWNER, FIFTY);
        assertEquals(TRUE, card.withdraw(ONE_HUNDRED));
    }

    @Test
    public void testDisplayBalancePositiveCase() {
        assertEquals(TRUE, card.displayBalance(TWENTY_NINE_HUNDREDTH));
        assertEquals(TWENTY_NINE, card.getBalance());
    }

    @Test
    public void testDisplayBalanceNegativeCase() {
        assertEquals(FALSE, card.displayBalance(NEGATIVE_AMOUNT));
    }

    @Test
    public void testDisplayBalanceForNull() {
        assertEquals(FALSE, card.displayBalance(EMPTY_BALANCE));
    }
}