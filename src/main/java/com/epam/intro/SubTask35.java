package com.epam.intro;

import java.util.Scanner;

public class SubTask35 {
    public static void main(String[] args) {

        int a = readVariable("First number: ");
        int b = readVariable("Second number: ");
        int greatestCommonDivisor = getGreatestCommonDivisor(a, b);
        int leastCommonMultiple = getLeastCommonMultiple(a, b, greatestCommonDivisor);
        System.out.println("Greatest Common Divisor: " + greatestCommonDivisor);
        System.out.println("Least Common Multiple: " + leastCommonMultiple);

    }

    private static int getLeastCommonMultiple(int a, int b, int greatestCommonDivisor) {
        return a * b / greatestCommonDivisor;
    }

    private static int getGreatestCommonDivisor(int a, int b) {
        int greatestCommonDivisor = 1;
        for (int i = 2; i <= (a > b ? b : a); i++) {
            if (a % i == 0 && b % i == 0) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
