package me.hyec.kmeans

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{rand, udf}

object Application extends App {

  val spark = SparkSession.builder()
    .appName("SparkKMeans")
    .master("local[*]")
    .getOrCreate()

  import spark.implicits._

  val df = Seq[(Double, Double)](
    (0, 0), (1, 1),
    (2, 2), (1, 2),
    (2, 1), (-1, -1),
    (-2, -2), (-1, -2))
    .toDF("x", "y")

  df.show()
  df.printSchema()

  val N = 3

  val randomPoints = df.orderBy(rand()).take(N).map(a => new Point2(a.getDouble(0), a.getDouble(1)))

  var centers = spark.sparkContext.broadcast(randomPoints)

  def cluster(x: Double, y: Double, centers: Broadcast[Array[Point]]): Int = {

    0
  }

}
