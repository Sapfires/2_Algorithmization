package com.epam.intro;

import java.util.Scanner;

public class SubTask6 {
    public static void main(String[] args) {
        int n = readVariable("number of elements");
        double sum = 0;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = readDoubleVariable("a[" + i + "]");
        }
        for (int i = 2; i < n; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j != 0) {
                    isSimple = false;
                    break;
                }
            }
            sum = sum + a[i];
        }
        System.out.println("The result is: " + sum);

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
