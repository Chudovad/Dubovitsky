package com.training.nmusabirova.hw2task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for select the type of algorithm, the type of loop
 * and setting the parameter passed to the algorithm.
 *
 * @author nmusabirova
 *
 * @version 1.0
 */
public class Algorithm {
    /**
     * The main method of the program.
     * @param args - arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers (type of calculation, loop type, quantity of numbers)");
        try {
            int action1 = sc.nextInt();
            int action2 = sc.nextInt();
            int number = sc.nextInt();
            if (number <= 0) {
                System.out.println("Number must be positive!");
            } else {

                Calculator calc = new Calculator();
                if (action1 == 1) {
                    switch (action2) {
                        case 1:
                            printResult(calc.calculateFibonacciByWhile(number));
                            break;
                        case 2:
                            printResult(calc.calculateFibonacciByDoWhile(number));
                            break;
                        case 3:
                            printResult(calc.calculateFibonacciByFor(number));
                            break;
                        default:
                            System.out.println("\n" + "Invalid input!");
                            break;
                    }
                } else if (action1 == 2) {
                    switch (action2) {
                        case 1:
                            System.out.println(calc.calculateFactorialByWhile(number));
                            break;
                        case 2:
                            System.out.println(calc.calculateFactorialByDoWhile(number));
                            break;
                        case 3:
                            System.out.println(calc.calculateFactorialByFor(number));
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Method for displaying the result.
     *
     * @param array - array of Fibonacci numbers
     */
    private static void printResult(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}