package com.dota.statistics.domain

import java.util

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
  * Match Mongo document
  */
@Document(collection="test_collection")
class Match {

  @Id
  @JsonProperty
  var id : String = _
  @JsonProperty
  var radiantWin : Boolean = _
  @JsonProperty
  var duration : Long = _
  @JsonProperty
  var startTime : Long = _
  @JsonProperty
  var gameMode : Int = _
  @JsonProperty
  var direScore : Int = _
  @JsonProperty
  var players : util.List[Player] = _

}
