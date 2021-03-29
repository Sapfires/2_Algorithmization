package com.epam.intro;

import java.util.Scanner;

public class SubTask7 {
    public static void main(String[] args) {
        int n = readVariable("number of elements");
        double[] a = new double[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = readDoubleVariable("a[" + i + "]");
        }
        double max = a[0] + a[2 * n - 1];
        for (int i = 0; i < n; i++) {
            double sum = a[i] + a[2 * n - i - 1];
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println("The result is: " + max);

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result < 0) {
            throw new RuntimeException("It must be more than 0");
        }
        return result;
    }

    public static double readDoubleVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
