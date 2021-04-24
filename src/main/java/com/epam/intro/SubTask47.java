package com.epam.intro;

import java.util.Scanner;

public class SubTask47 {
    public static void main(String[] args) {
        int n = readVariable("Number: ");
        for (int i = n; i < 2*n; i++) {
            if (isSimple(i) && isSimple(i+2)) {
                System.out.println(i + " " + (i+2));
            }
        }
    }

    private static boolean isSimple(int i) {
        boolean result = true;
        for (int j = 2; j < i; j++) {
            if (i%j == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
