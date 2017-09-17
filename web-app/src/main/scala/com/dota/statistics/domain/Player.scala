package com.dota.statistics.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
  * Player Mongo document
  */
@Document(collection="test_collection")
class Player {

  @Id
  var id : String = _
  var heroId : Long = _
  var kills : Int = _
  var deaths : Int = _
  var assists : Int = _
  var denies : Int = _
  var goldPerMinute : Int = _
  var xpPerMinute : Int = _
  var level : Int = _
  var heroDamage : Int = _
  var heroHealing : Int = _
  var goldCurrent : Int = _
  var goldSpent : Int = _
  var isDire : Boolean = _

}
