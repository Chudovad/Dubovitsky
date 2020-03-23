package com.training.nmusabirova;

public class SelectionSort implements Sorter {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            int temp = array[i];
            array[i] = array[indexOfMin];
            array[indexOfMin] = temp;
        }
    }
}
