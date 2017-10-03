package com.dota.statistics.engine

import com.dota.statistics.entity.matches.Match
import com.mongodb.spark.MongoSpark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col,collect_list}


object Main {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      //todo oss move to config file
      .appName("MongoSparkConnectorIntro")
      .master("local[*]")
      .config("spark.mongodb.input.uri", "mongodb://localhost:27017")
      .config("spark.mongodb.input.database", "local")
      .config("spark.mongodb.input.collection", "test_collection")
      .getOrCreate()
    import sparkSession.implicits._
    val dataset = MongoSpark.load[Match](sparkSession).as[Match]

    val result = dataset.groupBy(col("gameMode")).agg(collect_list(col("players"))).collect()

val i =0
    sparkSession.stop()
  }
}
