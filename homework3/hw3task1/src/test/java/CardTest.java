import com.training.nmusabirova.hw3task1.Card;
import org.junit.*;

import java.math.BigDecimal;

public class CardTest {

    private static final String NAME_PAVEL = "Pavel";
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    private static final BigDecimal ZERO = new BigDecimal("0");
    private static final BigDecimal TWENTY_NINE_HUNDREDTH = new BigDecimal("0.29");
    private static final BigDecimal TWENTY_ONE = new BigDecimal("21");
    private static final BigDecimal TWENTY_NINE = new BigDecimal("29.00");
    private static final BigDecimal SEVENTY_NINE = new BigDecimal("79");
    private static final BigDecimal ONE_HUNDRED_TWENTY_ONE = new BigDecimal("121");

    @Test
    public void testCreateCardWithHolderNamePositiveCase() {
        Card card = new Card(NAME_PAVEL);
        Assert.assertEquals("Pavel", card.getHolderName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateCardWithHolderNameNegativeCase() {
        Card card = new Card("");
    }

    @Test
    public void testCreateNewCardWithNameAndBalancePositiveCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        Assert.assertEquals("Pavel", card.getHolderName());
        Assert.assertEquals(ONE_HUNDRED, card.getCardBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNewCardWithNameAndBalanceNegativeCase() {
        Card card = new Card("", ONE_HUNDRED);
    }

    @Test
    public void testAddCardBalancePositiveCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        card.addCardBalance(TWENTY_ONE);
        Assert.assertEquals(ONE_HUNDRED_TWENTY_ONE, card.getCardBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCardBalanceNegativeCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        card.addCardBalance(null);
    }

    @Test
    public void testWithdrawFromCardBalancePositiveCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        card.withdrawFromCardBalance(TWENTY_ONE);
        Assert.assertEquals(SEVENTY_NINE, card.getCardBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFromCardBalanceNegativeCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        card.withdrawFromCardBalance(ONE_HUNDRED_TWENTY_ONE);
    }

    @Test
    public void testGetAnotherCurrencyPositiveCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        Assert.assertEquals(TWENTY_NINE, card.getAnotherCurrency(TWENTY_NINE_HUNDREDTH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAnotherCurrencyNegativeCase() {
        Card card = new Card(NAME_PAVEL, ONE_HUNDRED);
        card.getAnotherCurrency(ZERO);
    }
}