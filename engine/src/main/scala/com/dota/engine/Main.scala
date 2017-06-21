package com.dota.engine

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("MongoSparkConnectorIntro")
      .config("spark.mongodb.input.uri", "mongodb://localhost/test.myCollection")
      .config("spark.mongodb.output.uri", "mongodb://localhost/test.myCollection")
      .getOrCreate()


  }
}
