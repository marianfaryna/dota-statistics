package com.dota.rest.entity.heroes

/**
  * Object to get all heroes as response result
  */
class HeroesResult {
  var status : Long = 0L
  var heroes : List[Hero] = List()
}
