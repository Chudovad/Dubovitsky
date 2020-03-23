package com.training.nmusabirova.hw2task2;

/**
 * Class for calculating Fibonacci numbers and factorials.
 *
 * @author nmusabirova
 *
 * @version 1.0
 */
public class Calculator {
    /**
     * Function for calculating Fibonacci numbers through a while loop.
     * @param number - quantity of numbers
     * @return returns a series of Fibonacci numbers
     */
    public int[] calculateFibonacciByWhile(int number) {
        int[] array = new int[number];
        array[0] = 0;

        if (number == 1) {
            return array;
        } else {
            int count = 2;
            array[1] = 1;
            while (count < number) {
                array[count] = array[count - 1] + array[count - 2];
                count++;
            }
            return array;
        }
    }

    /**
     * Function for calculating Fibonacci numbers through a do-while loop.
     * @param number - quantity of numbers
     * @return returns a series of Fibonacci numbers
     */
    public int[] calculateFibonacciByDoWhile(int number) {
        int[] array = new int[number];
        array[0] = 0;

        if (number == 1) {
            return array;
        } else {
            int count = 2;
            array[1] = 1;
            do {
                array[count] = array[count - 1] + array[count - 2];
                count++;
            } while (count < number);
            return array;
        }
    }

    /**
     * Function for calculating Fibonacci numbers through a for loop.
     * @param number - quantity of numbers
     * @return returns a series of Fibonacci numbers
     */
    public int[] calculateFibonacciByFor(int number) {
        int[] array = new int[number];
        array[0] = 0;

        if (number == 1) {
            return array;
        } else {
            array[1] = 1;
            for (int i = 2; i < number; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            return array;
        }
    }

    /**
     * Function for calculating the factorial of numbers through a while loop.
     * @param number - number to find the factorial
     * @return returns the factorial of a number
     */
    public int calculateFactorialByWhile(int number) {
        int count = 1;
        int result = 1;
        while (count <= number) {
            result = result * count;
            count++;
        }
        return result;
    }

    /**
     * Function for calculating the factorial of numbers through a do-while loop.
     * @param number - number to find the factorial
     * @return returns the factorial of a number
     */
    public int calculateFactorialByDoWhile(int number) {
        int count = 1;
        int result = 1;
        do {
            result = result * count;
            count++;
        } while (count <= number);
        return result;
    }

    /**
     * Function for calculating factorial of numbers through a for loop.
     * @param number - number to find the factorial
     * @return returns the factorial of a number
     */
    public int calculateFactorialByFor(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}
