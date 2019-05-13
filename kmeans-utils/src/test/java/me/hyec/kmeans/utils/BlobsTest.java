package me.hyec.kmeans.utils;

import me.hyec.kmeans.Point;
import me.hyec.kmeans.Point2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlobsTest {

    private Blobs blobs;

    @BeforeAll
    public void init() {
        blobs = Blobs.builder().center(new Point2(1, 1)).build();
    }

    @Test
    public void run() {
        Point point = blobs.generatePoint();
        System.out.println(point);
    }

    @Test
    public void multiRun() {
        System.out.println("points = [");
        for (int i = 0; i < 1000; i++) {
            if (i != 0) {
                System.out.println(", ");
            }
            Point point = blobs.generatePoint();
            System.out.print("[");
            System.out.print(point.get(0));
            System.out.print(", ");
            System.out.print(point.get(1));
            System.out.print("]");
        }
        System.out.println("]");
    }
}
