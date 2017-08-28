package com.dota.rest.client

/**
  * Schema(fields name) for Document object which we persist to Mongo
  */
object DocumentSchema {
  val Id = "_id"
  val RadiantWin = "radiantWin"
  val Duration = "duration"
  val StartTime = "startTime"
  val GameMode = "gameMode"
  val DireScore = "direScore"
  val Players = "players"

  val AccountId = "accountId"
  val HeroId = "heroId"
  val Kills = "kills"
  val Deaths = "deaths"
  val Assists = "assists"
  val Denies = "denies"
  val GoldPerMinute = "goldPerMinute"
  val XpPerMinute = "xpPerMinute"
  val Level = "level"
  val HeroDamage = "heroDamage"
  val HeroHealing = "heroHealing"
  val GoldCurrent = "goldCurrent"
  val GoldSpent = "goldSpent"
  val IsDire = "isDire"
}
