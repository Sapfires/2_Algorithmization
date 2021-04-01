package com.epam.intro;

import java.util.Scanner;

public class SubTask18 {
    public static void main(String[] args) {
        int y = readVariable("count of rows: ");
        int x = readVariable("count of columns: ");
        int[][] a = new int[x][y];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                a[i][j] = readVariable("a[" + i + "," + j + "]");
            }
        }
        int k = readVariable("number of first column: ");
        int p = readVariable("number of second column: ");
        int tmp = 0;
        for (int j = 0; j < y; j++) {
            tmp = a[k][j];
            a[k][j] = a[p][j];
            a[p][j] = tmp;
        }
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }


    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
