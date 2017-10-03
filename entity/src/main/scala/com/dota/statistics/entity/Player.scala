package com.dota.statistics.entity

import com.fasterxml.jackson.annotation.JsonProperty

case class Player(
                   @JsonProperty("account_id")
                   accountId: Long,
                   @JsonProperty("hero_id")
                   heroId: Long,
                   @JsonProperty("player_slot")
                   slot: Int,
                   kills: Int,
                   deaths: Int,
                   assists: Int,
                   denies: Int,
                   @JsonProperty("gold_per_min")
                   goldPerMinute: Int,
                   @JsonProperty("xp_per_min")
                   xpPerMinute: Int,
                   level: Int,
                   @JsonProperty("hero_damage")
                   heroDamage: Int,
                   @JsonProperty("hero_healing")
                   heroHealing: Int,
                   @JsonProperty("gold")
                   goldCurrent: Int,
                   @JsonProperty("gold_spent")
                   goldSpent: Int,
                   @JsonProperty("item_0")
                   //TODO persist items into mongo
                   itemOne: Int,
                   @JsonProperty("item_1")
                   itemTwo: Int,
                   @JsonProperty("item_2")
                   itemThree: Int,
                   @JsonProperty("item_3")
                   itemFour: Int,
                   @JsonProperty("item_4")
                   itemFive: Int,
                   @JsonProperty("item_5")
                   itemSix: Int,
                   @JsonProperty("ability_upgrades")
                   abilityUpgrades: List[AbilityMeta] = Nil
                 ) {
  def isDire: Boolean = this.slot >= 128
}
