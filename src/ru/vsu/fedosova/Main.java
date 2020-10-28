package ru.vsu.fedosova;

import java.util.Locale;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        Point VerticalParabolaApex = new Point(1, -3);
        double VerticalParabolaQuadraticCoefficient = -1;
        String VerticalParabolaType = "vertical";

        Point LeftParabolaApex = new Point(1, 3);
        double LeftParabolaQuadraticCoefficient = -1;
        String LeftParabolaType = "horizontal_left";

        Point RightParabolaApex = new Point(-5, -4);
        double RightParabolaQuadraticCoefficient = 1;
        String RightParabolaType = "horizontal_right";

        Point Circle = new Point(6, 6);
        double Radius = 2;

        Picture picture = new Picture(
                new Parabola(VerticalParabolaApex, VerticalParabolaQuadraticCoefficient, VerticalParabolaType),

                new Parabola(LeftParabolaApex, LeftParabolaQuadraticCoefficient, LeftParabolaType),

                new Parabola(RightParabolaApex, RightParabolaQuadraticCoefficient, RightParabolaType),

                new Circle(Circle, Radius)
        );

        if (runTest(picture)) {
            readCoordinatesAndPrintColor(picture);
        } else {
            System.out.println("The program does not work correctly");
        }
    }

    private static boolean runTest(Picture picture)
    {
        SimpleColor[] expectedColors = {SimpleColor.GREEN, SimpleColor.WHITE,
                SimpleColor.BLUE, SimpleColor.GRAY, SimpleColor.WHITE};

        Point[] points = {new Point(4, 2), new Point(1, -8), new Point(-3, 3),
                new Point(2, -4), new Point(5, 6)};

        boolean result = true;

        for (int i = 0; i < expectedColors.length; i++)
        {
            SimpleColor color = picture.getColor(points[i]);
            SimpleColor expectedColor = expectedColors[i];

            if (color != expectedColor) {
                printResult(points[i], color, expectedColor, "incorrect");
                result = false;
            } else {
                printResult(points[i], color, expectedColor, "correct");
            }
        }
        return result;
    }

    private static void readCoordinatesAndPrintColor(Picture picture)
    {
        double x = readCoordinate("x");
        double y = readCoordinate("y");

        Point point = new Point(x, y);

        SimpleColor color = picture.getColor(point);
        printColor(point, color);
    }

    private static double readCoordinate(String point)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s", point);
        return scanner.nextDouble();
    }

    private static void printResult(Point point, SimpleColor color, SimpleColor expectedColor, String conclusion)
    {
        System.out.printf("Point(%.2f ; %.2f) => Color: %s;  Expected color: %s; Тhe result is %s.\n",
                point.getX(), point.getY(), color, expectedColor, conclusion);
    }

    private static void printColor(Point point, SimpleColor color)
    {
        System.out.printf("Point(%.2f, %.2f) => Color: %s\n", point.getX(), point.getY(), color);
    }
}