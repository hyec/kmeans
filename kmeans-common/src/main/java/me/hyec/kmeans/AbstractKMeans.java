package me.hyec.kmeans;

import java.util.List;

public abstract class AbstractKMeans<P, C> implements KMeans<P, C> {

    protected Distance distance;

    public AbstractKMeans() {
        this.distance = new EuclideanDistance();
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Distance getDistance() {
        return this.distance;
    }
}
