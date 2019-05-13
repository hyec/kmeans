package me.hyec.kmeans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaKMeans extends AbstractKMeans<List<Point>, List<Cluster>> {

    protected List<Point> randomPoints(List<Point> points, int k) {
        return points.stream().limit(k).collect(Collectors.toList());
    }

    protected List<Cluster> stage(List<Point> points, List<Point> centers) {

        assert centers != null && centers.size() > 0;

        final int dimension = centers.get(0).size();

        List<Cluster> clusters = new ArrayList<>();

        for (Point center : centers) {
            Cluster cluster = new Cluster(center);
            clusters.add(cluster);
        }

        for (Point point : points) {
            Cluster cluster = null;
            double distance = Double.MAX_VALUE;

            for (Cluster cluster1 : clusters) {

                double distance1 = getDistance().getDistance(cluster1.getCenter(), point);
                if (cluster == null || distance1 < distance) {
                    cluster = cluster1;
                    distance = distance1;
                }
            }

            assert cluster != null;
            cluster.add(point);
        }

        return clusters;
    }

    protected List<Point> center(List<Cluster> clusters) {
        List<Point> result = new ArrayList<>();

        for (Cluster cluster : clusters) {
            if (cluster.size() == 0) {
                result.add(cluster.getCenter());
                continue;
            }

            final int dimension = cluster.getCenter().size();

            double[] coordinates = new double[dimension];

            for (Point point : cluster) {
                for (int i = 0; i < dimension; i++) {
                    coordinates[i] += point.get(i);
                }
            }

            Point center = cluster.getCenter().clone();
            for (int i = 0; i < dimension; i++) {

                center.set(i, coordinates[i] / cluster.size());
            }

            cluster.setCenter(center);
            result.add(center);
        }

        return result;
    }

    public List<Cluster> run(List<Point> points, int k, int maxIteration) {

        assert points != null && points.size() >= k;

        List<Point> centers = randomPoints(points, k);
        List<Cluster> clusters = null;

        for (int i = 0; i < maxIteration; i++) {
            clusters = stage(points, centers);
            centers = center(clusters);
        }

        return clusters;
    }
}
