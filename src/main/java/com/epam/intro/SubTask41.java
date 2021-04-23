package com.epam.intro;

public class SubTask41 {
    public static void main(String[] args) {
    System.out.println("Sum of factorials: " + sumOfFactorials());
    }

    public static long factorial(Long number) {
        Long result = 1l;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    public static long sumOfFactorials() {
        Long sum = 0l;
        for (int i = 1; i <= 9; i = i + 2) {
            sum = sum + factorial((long) i);
        }
        return sum;
    }
}
