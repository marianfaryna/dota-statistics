package com.dota.rest.client

import java.util.Properties

/**
  * Configuration class that reads properties from file
  * and converts them into Properties object
  */
object Configuration {
  val ConfigFile = "configuration.properties"

  val BatchSize = "batch.size"
  val MongoUrl = "mongo.url"
  val MongoDb = "mongo.db"
  val MongoCollection = "mongo.collection"
  val MongoCallBackDuration = "mongo.callback.duration"

  def loadConfiguration(): Properties = {
    val prop = new Properties()
    prop.load(this.getClass.getClassLoader
      getResourceAsStream ConfigFile)
    prop
  }

  val configuration : Properties = loadConfiguration()

  /**
    * returns value from configuration by provided key
    *
    * @param key property name
    * @return value by provided key as String
    */
  def getValue(key : String) : String = {
    configuration.getProperty(key)
  }

  /**
    * returns numeric value from configuration by provided key
    *
    * @param key property name
    * @return value by provided key as numeric value
    */
  def getIntValue(key : String) : Int = {
    getValue(key).toInt
  }

}

