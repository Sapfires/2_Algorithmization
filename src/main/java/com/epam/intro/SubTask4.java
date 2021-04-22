package com.epam.intro;

import java.util.Scanner;

public class SubTask4 {
    static class Limit {
        int position = 0;
        double value = 0;

        public Limit(int position, double value) {
            this.position = position;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Limit{" +
                    "position=" + position +
                    ", value=" + value +
                    '}';
        }
    }
    static class Limits {
        Limit min;
        Limit max;

        public Limits(Limit min, Limit max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Limits{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n = readVariable("number of elements");
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = readDoubleVariable("a[" + i + "]");
        }
        Limits limits = new Limits(new Limit(0, a[0]), new Limit(0, a[0]));
        for (int i = 0; i < n; i++) {
            if (a[i] > limits.max.value) {
                limits.max.value = a[i];
                limits.max.position = i;
            }
            if (a[i]<limits.min.value){
                limits.min.value = a[i];
                limits.min.position = i;
            }
        }
        System.out.println("The result is: " + limits);

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
