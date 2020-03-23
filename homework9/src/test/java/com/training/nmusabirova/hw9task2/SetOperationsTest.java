package com.training.nmusabirova.hw9task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class SetOperationsTest {
    private static final HashSet NULL = null;
    private static final HashSet SETS_AFTER_UNION = new HashSet<>(Arrays.asList("cat", "dog", "mouse"));
    private static final HashSet SETS_AFTER_INTERSECTION = new HashSet<>(Arrays.asList("dog"));
    private static final HashSet SETS_AFTER_MINUS = new HashSet<>(Arrays.asList("cat"));
    private static final HashSet SETS_AFTER_DIFFERENCE = new HashSet<>(Arrays.asList("cat", "mouse"));
    private HashSet SET_1;
    private HashSet SET_2;
    SetOperations setOperations;

    @Before
    public void init() {
        setOperations = new SetOperations();
        SET_1 = new HashSet<>(Arrays.asList("cat", "dog"));
        SET_2 = new HashSet<>(Arrays.asList("dog", "mouse"));
    }

    @Test
    public void testGetUnion() {
        Assert.assertEquals(SETS_AFTER_UNION, setOperations.getUnion(SET_1, SET_2));
    }

    @Test
    public void testGetIntersection() {
        Assert.assertEquals(SETS_AFTER_INTERSECTION, setOperations.getIntersection(SET_1, SET_2));
    }

    @Test
    public void testGetMinus() {
        Assert.assertEquals(SETS_AFTER_MINUS, setOperations.getMinus(SET_1, SET_2));
    }

    @Test
    public void testGetDifference() {
        Assert.assertEquals(SETS_AFTER_DIFFERENCE, setOperations.getDifference(SET_1, SET_2));
    }

    @Test(expected = NullPointerException.class)
    public void testForNull() {
        Assert.assertEquals(SETS_AFTER_UNION, setOperations.getUnion(NULL, SET_2));
    }
}