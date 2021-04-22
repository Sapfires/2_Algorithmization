package com.epam.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SubTask24 {
    public static void main(String[] args) {
        int y = readVariable("count of rows: ");
        int x = readVariable("count of columns: ");
        if (x < y) {
            throw new RuntimeException("Number of rows must be more or equal than number of columns");
        }
        int[][] a = new int[x][y];
        Random random = new Random();


        for (int i = 0; i < x; i++) {
            List<Long> ids = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                ids.add((long) j);
            }
            for (int k = 0; k < y - i; k++) {
                if (ids.size() > 0) {
                    int id = random.nextInt(ids.size());
                    ids.remove(id);
                } else {
                    break;
                }
            }
            for (Long strNumber : ids) {
                a[i][strNumber.intValue()] = 1;
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
