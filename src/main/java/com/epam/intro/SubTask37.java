package com.epam.intro;

import java.util.Scanner;

public class SubTask37 {
    public static void main(String[] args) {
        double a = readVariable("Side: ");
        double triangleSquare = getTriangleSquare(a);
        double hexagonSquare = getHexagonSquare(triangleSquare);
        System.out.println(hexagonSquare);
    }

    private static double getHexagonSquare(double triangleSquare) {
        return 3 * triangleSquare;
    }

    private static double getTriangleSquare(double a) {
        return a * a *Math.sqrt(3)/2;
    }

    public static double readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
