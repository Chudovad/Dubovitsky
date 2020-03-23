package com.training.nmusabirova.hw8task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomListTest {
    public static final Object NULL = null;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final String STRING_ONE = "one";
    public static final String STRING_TWO = "two";
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;
    CustomList customList;

    @Before
    public void init() {
        customList = new CustomList();
    }

    @Test
    public void testAddPositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(STRING_ONE, customList.get(ZERO));
    }

    @Test
    public void testAddNegativeCase() {
        for (int i = 0; i < 9; i++) {
            customList.add(i);
        }
        Assert.assertEquals(FALSE, customList.add(9));
    }

    @Test
    public void testAddForType() {
        customList.add(ZERO);
        Assert.assertEquals(FALSE, customList.add(STRING_ONE));
    }

    @Test
    public void testRemovePositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(TRUE, customList.remove(STRING_ONE));
        Assert.assertEquals(ZERO, customList.size());
    }

    @Test
    public void testRemoveNegativeCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(FALSE, customList.remove(STRING_TWO));
    }

    @Test
    public void testSizePositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(ONE, customList.size());
    }

    @Test
    public void testSizeNegativeCase() {
        customList.remove(STRING_ONE);
        Assert.assertEquals(ZERO, customList.size());
    }

    @Test
    public void testIsEmptyPositiveCase() {
        Assert.assertEquals(TRUE, customList.isEmpty());
    }

    @Test
    public void testIsEmptyNegativeCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(FALSE, customList.isEmpty());
    }

    @Test
    public void testContainsPositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(TRUE, customList.contains(STRING_ONE));
    }

    @Test
    public void testContainsNegativeCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(FALSE, customList.contains(STRING_TWO));
    }

    @Test
    public void testClear() {
        customList.add(STRING_ONE);
        customList.clear();
        Assert.assertEquals(ZERO, customList.size());
    }

    @Test
    public void testGetPositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(STRING_ONE, customList.get(ZERO));
    }

    @Test
    public void testGetNegativeCase() {
        Assert.assertEquals(NULL, customList.get(ZERO));
    }

    @Test
    public void testSetPositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(STRING_TWO, customList.set(ZERO, STRING_TWO));
    }

    @Test
    public void testSetNegativeCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(NULL, customList.set(ONE, STRING_TWO));
    }

    @Test
    public void testSetForTypePositiveCase() {
        customList.add(STRING_ONE);
        Assert.assertEquals(ONE, customList.set(ZERO, ONE));
    }

    @Test
    public void testSetForTypeNegativeCase() {
        customList.add(STRING_ONE);
        customList.add(STRING_TWO);
        Assert.assertEquals(STRING_ONE, customList.set(ZERO, ONE));
    }
}