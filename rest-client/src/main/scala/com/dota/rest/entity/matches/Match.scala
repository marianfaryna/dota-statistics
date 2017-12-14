package com.dota.rest.entity.matches

import com.dota.rest.entity.Player
import com.fasterxml.jackson.annotation.JsonProperty

/**
  * DOTA Match entity
  */
class Match {
  @JsonProperty("match_id")
  var matchId: Long = 0L
  @JsonProperty("radiant_win")
  var radiantWin: Boolean = false
  var duration: Long = 0L
  var startTime: Long = 0L
  @JsonProperty("game_mode")
  var gameMode: Int = 0
  @JsonProperty("radiant_score")
  var radiantScore: Int = 0
  @JsonProperty("dire_score")
  var direScore: Int = 0
  @JsonProperty("barracks_status_radiant")
  var barracksStatusRadiant: Int = 0
  @JsonProperty("barracks_status_dire")
  var barracksStatusDire: Int = 0
  var players : List[Player] = List()
}
