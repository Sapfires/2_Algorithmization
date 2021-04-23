package com.epam.intro;

import java.util.Scanner;

public class SubTask38 {
    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {
        int countOfElements = readVariable("Count of points: ");
        Point[] points = new Point[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            points[i] = new Point();
            points[i].x = readDoubleVariable("x: ");
            points[i].y = readDoubleVariable("y: ");
        }
        double maxDistance = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            Point checkPoint = points[i];
            for (int j = i + 1; j < points.length; j++) {
                maxDistance = Math.max(maxDistance, getDistance(checkPoint, points[j]));
            }
        }
        System.out.println("Max distance: " + maxDistance);
    }

    private static double getDistance(Point checkPoint, Point currentPoint) {
        return Math.sqrt(sqr(checkPoint.x - currentPoint.x) + sqr(checkPoint.y - currentPoint.y));
    }

    private static double sqr(Double delta) {
        return Math.pow(delta, 2);
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static double readDoubleVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
