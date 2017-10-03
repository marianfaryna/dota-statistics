package com.dota.statistics.entity.matches

import com.dota.statistics.entity.Player
import com.fasterxml.jackson.annotation.JsonProperty

case class MatchMeta(
                      @JsonProperty("match_id")
                      matchId: Long,
                      match_seq_num: Long,
                      startTime: Long,
                      players: List[Player] = Nil
                    )
