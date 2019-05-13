package me.hyec.kmeans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaKMeansTest {

    private static final double[] POINTS = {
            0, 0, 1, 1, 2, 2, 1, 2, 2, 1, -1, -1, -2, -2, -1, 2
    };

    @Test
    public void testRun() {

        JavaKMeans kMeans = new JavaKMeans();

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < POINTS.length; ) {
            points.add(new Point2(POINTS[i++], POINTS[i++]));
        }

        List<Cluster> result = kMeans.run(points, 3, 1000);

        for (Cluster cluster : result) {
            System.out.println("Cluster[" + cluster.getCenter() + "]:");
            for (Point point : cluster) {
                System.out.println("\t" + point);
            }

            System.out.println();
        }

        kMeans.getDistance();
    }
}
