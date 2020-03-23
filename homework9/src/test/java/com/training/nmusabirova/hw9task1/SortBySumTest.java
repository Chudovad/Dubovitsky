package com.training.nmusabirova.hw9task1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SortBySumTest {
    public static final int[] NULL_ARRAY = {};
    public static final int[] SORTED_ARRAY = { 20, 32, 25, 9, 84 };
    public static final int[] UNSORTED_ARRAY = { 9, 32, 20, 84, 25};
    public static final int[] SORTED_ARRAY_OF_NEGATIVE_NUMBERS = { 20, -32, 25, 9, -84 };
    public static final int[] UNSORTED_ARRAY_OF_NEGATIVE_NUMBERS = { -32, 25, 20, -84, 9 };
    SortBySum sort = new SortBySum();

    @Test
    public void testSortBySumPositiveCase() {
        Assert.assertArrayEquals(SORTED_ARRAY, sort.sortBySum(UNSORTED_ARRAY));
    }

    @Test
    public void testSortBySumNegativeCase() {
        Assert.assertArrayEquals(SORTED_ARRAY_OF_NEGATIVE_NUMBERS, sort.sortBySum(UNSORTED_ARRAY_OF_NEGATIVE_NUMBERS));
    }

    @Test
    public void testSortBySumForNull() {
        Assert.assertArrayEquals(NULL_ARRAY, sort.sortBySum(NULL_ARRAY));
    }
}