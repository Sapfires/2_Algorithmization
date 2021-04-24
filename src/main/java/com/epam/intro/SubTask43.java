package com.epam.intro;

import java.util.Scanner;

public class SubTask43 {
    public static void main(String[] args) {
        double x = readVariable("x: ");
        double y = readVariable("y: ");
        double z = readVariable("z: ");
        double t = readVariable("t: ");
        double hypotenuse = Math.sqrt(x * x + y * y);
        double squareOfFirstPart = x*y/2;
        double squareOfSecondPart = getSquareOfSecondPart(z,t,hypotenuse);
        if (Double.isNaN(squareOfSecondPart)) {
            throw new RuntimeException("Lengths of sides are incorrect");
        }
        System.out.println("Square could be: " + (squareOfFirstPart - squareOfSecondPart > 0
                ? (squareOfFirstPart + squareOfSecondPart) + " or " + (squareOfFirstPart - squareOfSecondPart)
                : squareOfFirstPart + squareOfSecondPart));
    }

    private static double getSquareOfSecondPart(double a, double b, double c) {
        double semiPerimeter = getSemiPerimeter(a,b,c);
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    private static double getSemiPerimeter(double a, double b, double c) {
        return (a + b + c)/2;
    }

    public static double readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
