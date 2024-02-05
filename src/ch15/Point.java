package ch15;

public class Point {
    private double x;

    public Point() {
    }

    public Point(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "(" + x + ")";
    }

    protected void movePlusOne() {
        x += 1;
    }

    protected void movePlus10() {
        x += 10;
    }

    protected void printTypeOf() {
        System.out.println(this.getClass().getSimpleName());
    }

    private void reset() {
        x = 0;
    }

    public double getDistanceFromOrigin () {
        return Math.abs(x);
    }

}
