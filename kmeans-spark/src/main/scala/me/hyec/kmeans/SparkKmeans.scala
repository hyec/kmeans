package me.hyec.kmeans
import java.util

import org.apache.spark.rdd.RDD

class SparkKmeans extends AbstractKMeans[RDD[Point], RDD[Cluster]] {
  override def run(points: RDD[Point], k: Int, maxIteration: Int): RDD[Cluster] = {
    null
  }
}
