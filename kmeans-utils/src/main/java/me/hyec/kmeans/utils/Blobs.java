package me.hyec.kmeans.utils;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import me.hyec.kmeans.Point;
import me.hyec.kmeans.Point2;
import me.hyec.kmeans.PointN;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@Builder
public class Blobs {

    private final Point center;

    @Builder.Default
    private final double radius = 10.0d;

    @Builder.Default
    private final double variance = 1.0d;

    @Builder.Default
    private final long randomSeed = Long.MIN_VALUE;

    @Getter(AccessLevel.NONE)
    private Random random;

    @SuppressWarnings("ConstantConditions")
    private Random random() {
        if (random == null) {
            synchronized (this) {
                if (random != null) {
                    return random;
                }
                if (randomSeed != Long.MIN_VALUE) {
                    random = new Random(randomSeed);
                } else {
                    random = new Random();
                }
            }
        }

        return random;
    }

    public Point generatePoint() {

        final int n = center.size();
        final Point point = new PointN(n);

        for (int i = 0; i < n; i++) {
            double a = Math.sqrt(variance) * random().nextGaussian();
            point.set(i, a + center.get(i));
        }

        return point;
    }



    @SuppressWarnings("SameParameterValue")
    private static List<Point> makeCenters(int count) {
        System.out.println(count);
        return null;
    }

    public static void main(String[] args) {
        Blobs.builder().center(new Point2(1, 1)).build();
    }

}
