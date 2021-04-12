package com.epam.intro;

import java.util.Scanner;

public class SubTask21 {
    public static void main(String[] args) {
        double[][] a = new double[10][20];
        int[][] b = new int[10][20];
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 10; i++) {
                a[i][j] = Math.random() * 15;
            }
        }

        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 10; i++) {
                b[i][j] = (int) a[i][j];
            }
        }

        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int j = 0; j < 20; j++) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if (b[i][j] == 5) {
                    count = count + 1;
                }
            }
            if (count >= 3) {
                System.out.print(j + " ");
            }
        }
    }

}
