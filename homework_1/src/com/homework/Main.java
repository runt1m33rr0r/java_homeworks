package com.homework;

public class Main {

    public static void main(String[] args) {
        Main.task1(10, 10000, 5000);
        Main.task2(6);
        Main.task2(4);
    }

    private static void task1(int bottom, int top, int difference) {
        for (int number = bottom; number <= top; number++) {
            // calculate last digit in number
            int firstDigit = number;
            int digitsCount = 0;
            while (firstDigit > 9) {
                firstDigit /= 10;
                digitsCount += 1;
            }

            // remove first digit by subtracting raised to the power of 10
            int result = number - firstDigit * (int)Math.pow(10, digitsCount);

            // add first digit as last
            result *= 10;
            result += firstDigit;

            int subtraction = Math.abs(result - number);
            if (subtraction > difference) {
                System.out.println(number + " " + result + " => " + number + " - " + result + " = " +
                        subtraction + " > " + difference);
            }
        }
    }

    private static void task2(int size) {
        for (int row = 1; row <= size; row++) {
            for (int i = 1; i < row; i++) {
                System.out.print(" ");
            }

            for (int i = row; i <= size; i++) {
                System.out.print(i);
            }

            for (int i = size; i >= row; i--) {
                System.out.print(i);
            }

            System.out.println();
        }

        for (int row = size - 1; row > 0; row--) {
            for (int i = 1; i < row; i++) {
                System.out.print(" ");
            }

            for (int i = row; i <= size; i++) {
                System.out.print(i);
            }

            for (int i = size; i >= row; i--) {
                System.out.print(i);
            }

            System.out.println();
        }
    }
}