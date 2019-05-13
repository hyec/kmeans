package me.hyec.kmeans;

import java.util.List;

public interface KMeans<P, C> {

    Distance getDistance();

    C run(P points, int k, int maxIteration);
}
