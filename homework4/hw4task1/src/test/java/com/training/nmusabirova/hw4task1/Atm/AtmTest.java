package com.training.nmusabirova.hw4task1.Atm;

import com.training.nmusabirova.hw4task1.Card.CreditCard;
import com.training.nmusabirova.hw4task1.Card.DebitCard;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AtmTest {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;
    private static final String NAME_OWNER = "Pavel";
    private static final BigDecimal INITIAL_BALANCE = new BigDecimal(100);
    private static final BigDecimal AMOUNT_FOR_OPERATIONS = new BigDecimal(30);
    private static final BigDecimal HUGE_AMOUNT_FOR_OPERATIONS = new BigDecimal(250);
    private static final BigDecimal NEGATIVE_AMOUNT = new BigDecimal(-50);

    Atm atm;
    DebitCard debitCard;
    CreditCard creditCard;

    @Before
    public void init() {
        debitCard = new DebitCard(NAME_OWNER, INITIAL_BALANCE);
        creditCard = new CreditCard(NAME_OWNER, INITIAL_BALANCE);
    }

    @Test
    public void testAddToDebitCardPositiveCase() {
        atm = new Atm(debitCard);
        assertEquals(TRUE, atm.addCardBalance(AMOUNT_FOR_OPERATIONS));
    }

    @Test
    public void testAddToDebitCardNegativeCase() {
        atm = new Atm(debitCard);
        assertEquals(FALSE, atm.addCardBalance(NEGATIVE_AMOUNT));
    }

    @Test
    public void testAddToCreditCardPositiveCase() {
        atm = new Atm(creditCard);
        assertEquals(TRUE, atm.addCardBalance(AMOUNT_FOR_OPERATIONS));
    }

    @Test
    public void testAddToCreditCardNegativeCase() {
        atm = new Atm(creditCard);
        assertEquals(FALSE, atm.addCardBalance(NEGATIVE_AMOUNT));
    }

    @Test
    public void testWithdrawFromDebitCardPositiveCase() {
        atm = new Atm(debitCard);
        atm.addToAtm(INITIAL_BALANCE);
        assertEquals(TRUE, atm.withdraw(AMOUNT_FOR_OPERATIONS));
    }

    @Test
    public void testWithdrawFromDebitCardNegativeCase() {
        atm = new Atm(debitCard);
        atm.addToAtm(INITIAL_BALANCE);
        assertEquals(FALSE, atm.withdraw(NEGATIVE_AMOUNT));
    }

    @Test
    public void testWithdrawFromDebitCardLargeAmount() {
        atm = new Atm(debitCard);
        atm.addToAtm(INITIAL_BALANCE);
        assertEquals(FALSE, atm.withdraw(HUGE_AMOUNT_FOR_OPERATIONS));
    }

    @Test
    public void testWithdrawFromCreditCardPositiveCase() {
        atm = new Atm(creditCard);
        assertEquals(TRUE, atm.withdraw(AMOUNT_FOR_OPERATIONS));
    }

    @Test
    public void testWithdrawFromCreditCardNegativeCase() {
        atm = new Atm(creditCard);
        assertEquals(FALSE, atm.withdraw(NEGATIVE_AMOUNT));
    }

    @Test
    public void testWithdrawFromCreditCardLargeAmount() {
        atm = new Atm(creditCard);
        atm.addToAtm(INITIAL_BALANCE);
        assertEquals(TRUE, atm.withdraw(HUGE_AMOUNT_FOR_OPERATIONS));
    }
}