package com.dota.statistics.domain

import java.util

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
  * Match Mongo document
  */
@Document(collection="test_collection")
class Match {

  @Id
  var id : String = _
  var radiantWin : Boolean = _
  var duration : Long = _
  var startTime : Long = _
  var gameMode : Int = _
  var direScore : Int = _
  var players : util.List[Player] = _

}
