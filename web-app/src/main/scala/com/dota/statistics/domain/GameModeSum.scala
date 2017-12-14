package com.dota.statistics.domain

import java.util

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
  * Game Mode sum Mongo document
  */
@Document(collection="test_results")
class GameModeSum {

  @Id
  @JsonProperty
  var id : String = _
  @JsonProperty
  var gameMode : Int = _
  @JsonProperty
  var sum : Int = _

}
