package com.dota.statistics.entity.matches

import com.dota.statistics.entity.Player
import com.fasterxml.jackson.annotation.JsonProperty

case class Match(
                  @JsonProperty("match_id")
                  matchId: Long,
                  @JsonProperty("radiant_win")
                  radiantWin: Boolean,
                  duration: Long,
                  startTime: Long,
                  @JsonProperty("game_mode")
                  gameMode: Int,
                  @JsonProperty("radiant_score")
                  radiantScore: Int,
                  @JsonProperty("dire_score")
                  direScore: Int,
                  @JsonProperty("barracks_status_radiant")
                  barracksStatusRadiant: Int,
                  @JsonProperty("barracks_status_dire")
                  barracksStatusDire: Int,
                  players: List[Player] = Nil
                )
