package com.dota.engine

import com.mongodb.spark.MongoSpark
import com.mongodb.spark.config.{ReadConfig, WriteConfig}
import org.apache.spark.sql.SparkSession

/**
  * Main Spark class for processing data in Mongo
  */


case class PlayerMongo(accountId: String,
                       heroId: Long,
                       kills: Int,
                       deaths: Int,
                       assists: Int,
                       denies: Int,
                       goldPerMinute: Int,
                       xpPerMinute: Int,
                       level: Int,
                       heroDamage: Int,
                       heroHealing: Int,
                       goldCurrent: Int,
                       goldSpent: Int,
                       isDire: Boolean)


case class MatchMongo(_id: String,
                      radiantWin: Boolean,
                      duration: Long,
                      startTime: Long,
                      gameMode: Int,
                      direScore: Int,
                      players: List[PlayerMongo])

case class ModeSums(gameMode: Int,
                    sum: Int)

object GameModeApplication {

  def main(args: Array[String]): Unit = {
    val spark = getSparkSession

    val mongoHost : String = System.getProperty("mongo.host")
    val mongoDbName : String = System.getProperty("mongo.db.name")
    val mongoReadCollection : String = System.getProperty("mongo.read.collection")
    val mongoWriteCollection : String = System.getProperty("mongo.write.collection")

    if(mongoHost.isEmpty || mongoDbName.isEmpty || mongoReadCollection.isEmpty || mongoWriteCollection.isEmpty) {
      throw new RuntimeException("Not all required params are set!")
    }

    val readConfig = ReadConfig(Map("uri" -> s"mongodb://$mongoHost/$mongoDbName.$mongoReadCollection?readPreference=primaryPreferred"))
    val writeConfig = WriteConfig(Map("uri" -> s"mongodb://$mongoHost/$mongoDbName.$mongoWriteCollection"))

    val matchesRDD = MongoSpark.load[MatchMongo](spark, readConfig)

    import spark.implicits._
    val modeSumsDF = matchesRDD
      .rdd
      .map(elem => {
        (elem.getAs[Int]("gameMode"),1)
      }).groupByKey().map(row => {
      new ModeSums(row._1, row._2.size)
    }).toDF()

    MongoSpark.save(modeSumsDF, writeConfig)

  }

  def getSparkSession: SparkSession = {

    SparkSession.builder()
      .appName("MongoSparkConnectorIntro")
      .master("local[*]")
      .appName("testApp")
      .getOrCreate()
  }

}
