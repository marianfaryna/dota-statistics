package com.dota.rest.entity.matches

/**
  * Object to get all matches as response result
  */
class Result {
  var status : Long = 0L
  var matches : List[MatchMeta] = List()
}
