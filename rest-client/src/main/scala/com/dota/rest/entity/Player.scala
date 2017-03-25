package com.dota.rest.entity

import com.fasterxml.jackson.annotation.JsonProperty

/**
  * Created by admin on 3/18/17.
  */
class Player {
  @JsonProperty("account_id")
   var accountId : Long = 0L
  @JsonProperty("hero_id")
   var heroId : Long = 0L
  var kills: Int = 0
  var deaths: Int = 0
  var assists: Int = 0
  var denies: Int = 0
  @JsonProperty("gold_per_min")
  var goldPerMinute: Int = 0
  @JsonProperty("xp_per_min")
  var xpPerMinute: Int = 0
  var level: Int = 0
  @JsonProperty("hero_damage")
  var heroDamage: Int = 0
  @JsonProperty("hero_healing")
  var heroHealing: Int = 0
  @JsonProperty("gold")
  var goldCurrent: Int = 0
  @JsonProperty("gold_spent")
  var goldSpent: Int = 0
  @JsonProperty("item_0")
  var itemOne: Int = 0
  @JsonProperty("item_1")
  var itemTwo: Int = 0
  @JsonProperty("item_2")
  var itemThree: Int = 0
  @JsonProperty("item_3")
  var itemFour: Int = 0
  @JsonProperty("item_4")
  var itemFive: Int = 0
  @JsonProperty("item_5")
  var itemSix: Int = 0
  @JsonProperty("ability_upgrades")
  var abilityUpgrades: List[AbilityMeta] = List()
}
