package ru.vsu.fedosova;

public class Parabola
{
    Point apex;
    double quadraticCoefficient;
    String type;

    public Parabola(Point apex, double quadraticCoefficient, String type)
    {
        this.apex = apex;
        this.quadraticCoefficient = quadraticCoefficient;
        this.type = type;
    }

    public boolean isPointInside(Point point)
    {
        if (type.equals("horizontal_right"))
        {
            return point.getX() > quadraticCoefficient * Math.pow(point.getY() - apex.getY(), 2) + apex.getX();
        }
        if (type.equals("horizontal_left"))
        {
            return point.getX() < quadraticCoefficient * Math.pow(point.getY() - apex.getY(), 2) + apex.getX();
        }
        if (type.equals("vertical"))
        {
            return point.getY() < quadraticCoefficient * Math.pow(point.getX() - apex.getX(), 2) + apex.getY();
        }
        return false;
    }
}