package com.epam.intro;

import java.util.Scanner;

public class SubTask3 {
    static class Statistics {
        int lessZero = 0;
        int zero = 0;
        int moreZero = 0;

        @Override
        public String toString() {
            return "Statistics{" +
                    "lessZero=" + lessZero +
                    ", zero=" + zero +
                    ", moreZero=" + moreZero +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n = readVariable("number of elements");
        Statistics statistics = new Statistics();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = readDoubleVariable("a[" + i + "]");
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                statistics.moreZero++;
            }else if (a[i]<0){
                statistics.lessZero++;
            }else {
                statistics.zero++;
            }
        }
        System.out.println("The result is: " + statistics);

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result < 0) {
            throw new RuntimeException("It must be more than 0");
        }
        return result;
    }

    public static double readDoubleVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
