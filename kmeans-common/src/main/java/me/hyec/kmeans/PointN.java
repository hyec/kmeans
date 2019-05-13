package me.hyec.kmeans;

import java.util.Arrays;
import java.util.stream.Stream;

public class PointN implements Point {

    private double[] coordinates;

    public PointN(int n) {
        coordinates = new double[n];
    }

    public void set(int n, double a) {
        coordinates[n] = a;
    }

    public double get(int n) {
        return coordinates[n];
    }

    public int size() {
        return coordinates.length;
    }

    @Override
    public Point clone() {
        PointN pointN = new PointN(this.size());
        pointN.coordinates = Arrays.copyOf(this.coordinates, this.size());
        return pointN;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point[").append(size()).append("](");
        for (int i = 0; i < size(); i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(get(i));
        }
        sb.append(")");
        return sb.toString();
    }
}
