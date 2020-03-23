package com.training.nmusabirova.hw3task2;

import java.util.Arrays;

public class Median {
    private Median() {
    }

    public static float median(int[] array) {
        checkForNull(array);
        int[] copyArray = array.clone();
        Arrays.sort(copyArray);

        int index = copyArray.length / 2;
        if (copyArray.length % 2 == 0) {
            return (float)((copyArray[index] + copyArray[index - 1]) / 2.0);
        } else {
            System.out.println("copyArray[index] = " + copyArray[index]);
            return copyArray[index];
        }
    }

    public static double median(double[] array) {
        checkForNull(array);
        double[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);

        int index = copyArray.length / 2;
        if (copyArray.length % 2 == 0) {
            double result = (copyArray[index] + copyArray[index - 1]) / 2.0;
            return result;
        } else {
            return copyArray[index];
        }
    }

    private static void checkForNull(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Error! Array cannot be null!");
        }
    }

    private static void checkForNull(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Error! Array cannot be null!");
        }
    }
}
