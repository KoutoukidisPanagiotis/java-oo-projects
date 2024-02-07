package ch16.exercise2;

public class Circle extends AbstractShape implements ICircle  {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getDiameter() {
       return 2 * radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
