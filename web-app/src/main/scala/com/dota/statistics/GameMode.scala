package com.dota.statistics

/**
  * Enumeration for Dota 2 game mods
  */
object GameMode extends Enumeration {
  type GameMode = Value

  val NONE = Value(0, "None")
  val ALL_PICK = Value(1, "All Pick")
  val CAPTAIN_MODE = Value(2, "Captain's Mode")
  val RANDOM_DRAFT = Value(3, "Random Draft")
  val SINGLE_DRAFT = Value(4, "Single Draft")
  val ALL_RANDOM = Value(5, "All Random")
  val INTRO = Value(6, "Intro")
  val DIRETIDE = Value(7, "Diretide")
  val REVERSE_CAPTAIN_MODE = Value(8, "Reverse Captain's Mode")
  val GREEVILING = Value(9, "The Greeviling")
  val TUTORIAL = Value(10, "Tutorial")
  val MID_ONLY = Value(11, "Mid Only")
  val LEAST_PLAYED = Value(12, "Least Played")
  val NEW_PLAYER_POOL = Value(13, "New Player Pool")
  val COMPENDIUM_MATCHMAKING = Value(14, "Compendium Matchmaking")
  val COOP_VS_BOTS = Value(15, "Co-op vs Bots")
  val CAPTAINS_DRAFT = Value(16, "Captains Draft")
  val ABILITY_DRAFT = Value(18, "Ability Draft")
  val ALL_RANDOM_DEATHMATCH = Value(20, "All Random Deathmatch")
  val ONE_VS_ONE_MID = Value(21, "1v1 Mid Only")
  val RANKED_MATCHMAKING = Value(22, "Ranked Matchmaking")
  val UNKNOWN = Value(999, "Unidentified match mode")

  def getByModeId(gameMode : Int): GameMode = {
    for(mode <- GameMode.values) {
      if(gameMode == mode.id) {
        return mode
      }
    }
    GameMode.UNKNOWN
  }

}
