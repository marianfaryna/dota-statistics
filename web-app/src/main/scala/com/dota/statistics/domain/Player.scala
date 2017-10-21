package com.dota.statistics.domain

import com.fasterxml.jackson.annotation.{JsonAutoDetect, JsonProperty}
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
  * Player Mongo document
  */
@Document(collection="test_collection")
@JsonAutoDetect
class Player {

  @Id
  @JsonProperty
  var id : String = _
  @JsonProperty
  var heroId : Long = _
  @JsonProperty
  var kills : Int = _
  @JsonProperty
  var deaths : Int = _
  @JsonProperty
  var assists : Int = _
  @JsonProperty
  var denies : Int = _
  @JsonProperty
  var goldPerMinute : Int = _
  @JsonProperty
  var xpPerMinute : Int = _
  @JsonProperty
  var level : Int = _
  @JsonProperty
  var heroDamage : Int = _
  @JsonProperty
  var heroHealing : Int = _
  @JsonProperty
  var goldCurrent : Int = _
  @JsonProperty
  var goldSpent : Int = _
  @JsonProperty
  var isDire : Boolean = _

}
