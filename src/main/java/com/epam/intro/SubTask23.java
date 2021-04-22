package com.epam.intro;

import java.util.Scanner;

public class SubTask23 {
    public static void main(String[] args) {
        int y = readVariable("count of rows: ");
        int x = readVariable("count of columns: ");
        int[][] a = new int[x][y];
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                a[i][j] = readVariable("a[" + i + "," + j + "]");
            }
        }
        for (int j = 0; j < y; j++) {
            int countOfReplacement = 0;
            do {
                countOfReplacement = 0;
                for (int i = 0; i < x - 1; i++) {
                    if (a[i][j] < a[i + 1][j]) {
                        int tmp = a[i][j];
                        a[i][j] = a[i + 1][j];
                        a[i + 1][j] = tmp;
                        countOfReplacement++;
                    }
                }

            }
            while (countOfReplacement > 0);
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
