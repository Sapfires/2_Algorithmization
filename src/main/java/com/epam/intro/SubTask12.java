package com.epam.intro;

import java.util.Scanner;

public class SubTask12 {
    public static void main(String[] args) {
        int n = readVariable("count of columns and rows: ");
        int[][] a = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                a[i][j] = readVariable("a[" + i + "," + j + "]");
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i][i] + " ");
        }
        for (int i = 0; i < n; i++) {
            if (a[n-i-1][i]!=a[i][i])
            System.out.print(a[n - i-1][i] + " ");
        }
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
