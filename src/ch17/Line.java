package ch17;

import java.io.Serializable;

public class Line extends AbstractShape implements Serializable,Cloneable {
    private final static long serialVersionUID = 1L;
    private double length;

    public Line(long id, double length) {
        super(id);
        this.length = length;
    }

    public Line(Line line) {
        super(line);
        this.length = line.getLength();
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Double.compare(length, line.length) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(length);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }
}
