package com.epam.intro;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubTask11 {
    private static final String TEMPLATE = "\s";
    public static void main(String[] args) {
        int x = readVariable("count of columns: ");
        int y = readVariable("count of rows: ");
        int[][] a = readArray(x, y);
        boolean[] columnsToShow = new boolean[x];
        for (int i = 0; i < x; i++) {
            columnsToShow[i] = false;
        }
        for (int i = 1; i < x; i += 2) {
            if (a[i][0] > a[i][y - 1]) {
                columnsToShow[i] = true;
            }
        }
        for (int j = 0; j < y; j++) {
            for (int i = 1; i < x; i += 2) {
                if(columnsToShow[i]){
                    System.out.print(a[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    private static int[][] readArray(int x, int y) {
        int[][] a = new int[x][y];
        for (int j = 0; j < y; j++) {
            String row = readStringVariable(" row : " + j);
            String[] elements = row.split(TEMPLATE);
            if(elements.length< x){
                throw new RuntimeException("Incorrect length of row");
            }
            int i=0;
            for (String str:elements){
                a[i++][j] = Integer.parseInt(str);
            }
        }
        return a;
    }

    private static String readStringVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
