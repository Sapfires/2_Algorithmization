package com.epam.intro;

import java.util.Scanner;

public class SubTask14 {
    public static void main(String[] args) {
        int n = readVariable("count of columns and rows: ");
        int[][] a = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (j % 2 != 0) {
                    a[i][j] = n - i;
                } else {
                    a[i][j] = i + 1;
                }
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
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