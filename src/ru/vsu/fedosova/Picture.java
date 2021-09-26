package ru.vsu.fedosova;

public class Picture
{
    private final Parabola verticalParabola;
    private final Parabola leftParabola;
    private final Parabola rightParabola;
    private final Circle circle;

    public Picture(Parabola verticalParabola, Parabola leftParabola, Parabola rightParabola, Circle circle)
    {
        this.verticalParabola = verticalParabola;
        this.leftParabola = leftParabola;
        this.rightParabola = rightParabola;
        this.circle = circle;
    }

    public SimpleColor getColor(Point point)
    {
        if (rightParabola.isPointInside(point))
            return SimpleColor.GRAY;
        if (leftParabola.isPointInside(point))
            return SimpleColor.BLUE;
        if (verticalParabola.isPointInside(point) && !rightParabola.isPointInside(point)
                || circle.isPointInside(point))
            return SimpleColor.WHITE;
        return SimpleColor.GREEN;
    }
}
