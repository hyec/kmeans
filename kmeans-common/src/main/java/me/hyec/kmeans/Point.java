package me.hyec.kmeans;

public interface Point extends Cloneable {

    void set(int n, double a);

    double get(int n);

    int size();

    Point clone();
}
