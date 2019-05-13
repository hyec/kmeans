package me.hyec.kmeans;

public class Point2 implements Point {

    protected double x, y;

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set(int n, double a) {
        switch (n) {
            case 0:
                this.x = a;
                break;
            case 1:
                this.y = a;
                break;
            default:
                throw new ArrayIndexOutOfBoundsException(n);
        }
    }

    public double get(int n) {
        switch (n) {
            case 0:
                return x;
            case 1:
                return y;
            default:
                throw new ArrayIndexOutOfBoundsException(n);
        }
    }

    public int size() {
        return 2;
    }

    @Override
    public String toString() {
        return "Point[" + x + "," + y + "]";
    }

    @Override
    public Point clone() {

        return new Point2(x, y);
    }
}
