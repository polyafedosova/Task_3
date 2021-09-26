package ru.vsu.fedosova;

public class Circle
{
    Point center;
    double radius;

    public Circle(Point center, double radius)
    {
        this.center = center;
        this.radius = radius;
    }

    public boolean isPointInside(Point point)
    {
        return Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2) <= radius * radius;
    }
}
