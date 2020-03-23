package com.training.nmusabirova;

public class SortingContext {
    private Sorter sortStrategy;

    public SortingContext(Sorter sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public boolean execute(int[] array) {
        boolean correctSort = checkForElements(array);
        if (correctSort) {
            sortStrategy.sort(array);
        } else {
            System.out.println("The array contains no elements.");
        }
        return correctSort;
    }

    private static boolean checkForElements(int[] array) {
        boolean result = false;
        if (array.length > 0) {
            result = true;
        }
        return result;
    }
}
