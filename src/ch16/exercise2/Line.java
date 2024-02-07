package ch16.exercise2;

public class Line extends AbstractShape implements ILine{
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
