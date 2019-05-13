package me.hyec.kmeans;

import java.util.ArrayList;
import java.util.List;

public class Cluster extends ArrayList<Point> {

    public Cluster(Point center) {
        this.center = center;
    }

    private Point center;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        assert this.center.size() == center.size();

        this.center = center;
    }
}
