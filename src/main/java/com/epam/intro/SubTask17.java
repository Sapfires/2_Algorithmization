package com.epam.intro;

import java.util.Scanner;

import static java.lang.Math.pow;

public class SubTask17 {
    public static void main(String[] args) {
        int n = readVariable("count of columns and rows: ");
        int countPositive = 0;
        double[][] a = new double[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                a[i][j] = Math.sin((pow(i, 2) - pow(j, 2)) / n);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (a[i][j] > 0) {
                    countPositive = countPositive + 1;
                }
            }

        }
        System.out.println("Count of positive elements: " + countPositive);
    }


    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result % 2 > 0) {
            throw new RuntimeException("It must be even number");
        }
        return result;
    }
}
