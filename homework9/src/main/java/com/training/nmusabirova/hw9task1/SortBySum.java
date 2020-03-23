package com.training.nmusabirova.hw9task1;

public class SortBySum {

    public int[] sortBySum(int[] array) {
        if (checkForNull(array)) {
            array = sort(array);
        } else {
            System.out.println("Error! The array is empty.");
        }
        return array;
    }

    private int[] sort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && checkChangeOfValue(array, j); j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return array;
    }

    private boolean checkForNull(int[] array) {
        return (array.length > 0);
    }

    private int getSum(int number) {
        int sum = 0;
        number *= checkSign(number);

        for (; number > 0; number /= 10) {
            sum += number % 10;
        }
        return sum;
    }

    private int checkSign(int number) {
        if (number < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    private boolean checkChangeOfValue(int[] array, int index) {
        return getSum(array[index]) < getSum(array[index - 1]);
    }
}
