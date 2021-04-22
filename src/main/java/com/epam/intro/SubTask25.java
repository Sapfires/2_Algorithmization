package com.epam.intro;

import java.util.Scanner;

public class SubTask25 {
    public static void main(String[] args) {
        int y = readVariable("count of rows: ");
        int x = readVariable("count of columns: ");
        int[][] a = new int[x][y];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                a[i][j] = readVariable("a[" + i + "," + j + "]");
            }
        }
        int max = a[1][1];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (a[i][j] > max)
                    max = a[i][j];
            }
        }
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (a[i][j] % 2 != 0)
                    a[i][j] = max;
            }
        }
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                System.out.print(a[i][j] + " ");
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
