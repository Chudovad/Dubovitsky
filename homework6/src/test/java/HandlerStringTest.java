import com.training.nmusabirova.hw6.HandlerString;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HandlerStringTest{
    private static final String EMPTY_STRING = "";
    private static final int[] NULL = null;
    private static final String[] NULL_STRING = null;
    private static final String NULL_VALUE = null;
    private static final String EXAMPLE_TEST = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking up, what should he see but a\n" +
            "Lamb just beginning to drink a little lower down.";
    private static final String[] WORD_LIST = { "a", "at", "beginning", "but", "down", "drink", "he", "hillside", "just", "lamb", "lapping", "little",
            "looking", "lower", "on", "once", "see", "should", "spring", "time", "to", "up", "upon", "was", "what", "when", "wolf"};
    private static final int[] NUMBER_LIST = { 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

    @Test
    public void testHandlePositiveCase() {
        HandlerString h = new HandlerString();
        h.handle(EXAMPLE_TEST);
        assertArrayEquals(WORD_LIST, h.getDuplicates());
        assertArrayEquals(NUMBER_LIST, h.getNumberDuplication());
    }

    @Test
    public void testHandleNegativeCase() {
        HandlerString h = new HandlerString();
        h.handle(EMPTY_STRING);
        assertArrayEquals(NULL_STRING, h.getDuplicates());
        assertArrayEquals(NULL, h.getNumberDuplication());
    }

    @Test
    public void testHandleNull() {
        HandlerString h = new HandlerString();
        h.handle(NULL_VALUE);
        assertArrayEquals(NULL_STRING, h.getDuplicates());
        assertArrayEquals(NULL, h.getNumberDuplication());
    }
}