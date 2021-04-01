package com.epam.intro;

import java.util.Scanner;

public class SubTask16 {    public static void main(String[] args) {
    int n = readVariable("count of columns and rows: ");
    int[][] a = new int[n][n];
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < n; i++) {
            if (((i+j>n-1) && i>j)||(i+j<n-1 && i<j)) {
                a[i][j] = 0;
            } else {
                a[i][j] = 1;
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
