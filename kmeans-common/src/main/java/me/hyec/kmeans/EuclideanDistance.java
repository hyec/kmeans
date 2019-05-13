package me.hyec.kmeans;

public class EuclideanDistance implements Distance {

    public double getDistance(Point point1, Point point2) {

        assert point1 != null && point2 != null && point1.size() == point2.size();

        double distance = 0;

        for (int i = 0; i < point1.size(); i++) {
            double differ = point1.get(i) - point2.get(i);
            distance += Math.pow(differ, 2);
        }

        return Math.sqrt(distance);
    }
}
