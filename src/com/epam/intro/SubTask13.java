package com.epam.intro;

import java.util.Scanner;

public class SubTask13 {
    public static void main(String[] args) {
        int y = readVariable("count of rows: ");
        int x = readVariable("count of columns: ");
        int[][] a = new int[x][y];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                a[i][j] = readVariable("a[" + i + "," + j + "]");
            }
        }
        int k = readVariable("number of row: ");
        int p = readVariable("number of column: ");
        for (int i = 0; i < x; i++) {
            System.out.print(a[i][k]);
        }
        System.out.println();
        System.out.println();
        for (int j = 0; j < y; j++) {
            System.out.println(a[p][j]);
        }
    }


    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
