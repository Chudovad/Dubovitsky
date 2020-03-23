package com.training.nmusabirova;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortingContextTest {
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;
    public static final int [] NULL_ARRAY = {};
    public static final int [] SORTED_ARRAY = {0, 2, 3, 5, 7, 9, 12, 15, 17};
    public static final Sorter BubbleStrategy = new BubbleSort();
    public static final Sorter SelectionStrategy = new SelectionSort();
    int[] array;
    SortingContext context;

    @Before
    public void init() {
        array = new int[] {3, 7, 12, 5, 2, 9, 17, 0, 15};
    }

    @Test
    public void testArrayForNull() {
        context = new SortingContext(BubbleStrategy);
        assertEquals(FALSE, context.execute(NULL_ARRAY));
    }

    @Test
    public void testBubbleSort() {
        context = new SortingContext(BubbleStrategy);
        assertEquals(TRUE, context.execute(array));
        assertArrayEquals(SORTED_ARRAY, array);
    }

    @Test
    public void testSelectionSort() {
        context = new SortingContext(SelectionStrategy);
        assertEquals(TRUE, context.execute(array));
        assertArrayEquals(SORTED_ARRAY, array);
    }
}