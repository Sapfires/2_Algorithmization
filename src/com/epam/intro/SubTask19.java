package com.epam.intro;

import java.util.Scanner;

public class SubTask19 {
    public static void main(String[] args) {
        int y = readVariable("count of rows: ");
        int x = readVariable("count of columns: ");
        int[][] a = new int[x][y];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                a[i][j] = readVariable("a[" + i + "," + j + "]");
            }
        }
        int[] sum = new int [x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                sum[i] = sum[i] + a[i][j];
            }
        }
        int k = 1;
        int max = sum[1];
        for (int i = 0; i < x; i++) {
            if (sum[i] > max) {
                max = sum[i];
                k = i;
            }
        }
        System.out.print("Maximum sum is: " + k);
    }


    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
