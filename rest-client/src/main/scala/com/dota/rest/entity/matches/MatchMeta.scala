package com.dota.rest.entity.matches

import com.dota.rest.entity.Player
import com.fasterxml.jackson.annotation.JsonProperty

/**
  * Created by admin on 3/18/17.
  */
class MatchMeta {
  @JsonProperty("match_id")
    var matchId : Long = 0L
    var match_seq_num : Long = 0L
    var startTime : Long = 0L
   var players : List[Player] = List()
}
