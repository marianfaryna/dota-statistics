package com.dota.rest.client

class Main {}

object Main extends App {
 val client = RestClient

//  val restResponse = client.getMatches()
//  println("=======> REST RESPONSE")
//  println(restResponse)

// for(playedMatch <- restResponse.matches) {
//
//
//   val matchDetails = client.getMatchHistory(playedMatch.matchId)
//   println("=======> REST RESPONSE")
//   println(matchDetails.matchId)
//   println(matchDetails.gameMode)
//   println("=======> KILLS")
//   println(matchDetails.players.head.kills)
//   println("=======> DEATHS")
//   println(matchDetails.players.head.deaths)
//   println("=======> GOLD")
//   println(matchDetails.players.head.goldCurrent)
//   println(matchDetails.players.head.goldSpent)
//   println(matchDetails.players.head.goldPerMinute)
//   println(matchDetails.players.head.goldPerMinute)
//   println("=======> DAMAGE")
//   println(matchDetails.players.head.heroDamage)
//   println(matchDetails.players.head.heroHealing)
//   println(matchDetails.players.head.xpPerMinute)
//   println("=======> ITEMS")
//   println(matchDetails.players.head.itemOne)
//   println(matchDetails.players.head.itemTwo)
//   println(matchDetails.players.head.itemThree)
//   println(matchDetails.players.head.itemFour)
//   println(matchDetails.players.head.itemFive)
//   println("=======> ABILITIES")
//   if(matchDetails.players.head.abilityUpgrades.nonEmpty) {
//     println(matchDetails.players.head.abilityUpgrades.head.ability)
//     println(matchDetails.players.head.abilityUpgrades.head.level)
//     println(matchDetails.players.head.abilityUpgrades.head.time)
//   }
// }
//  println("=======> ITEMS")
//  val restItemsResponse = client.getGameItems
//    println("=======> REST RESPONSE")
//  for(item <- restItemsResponse) {
//    println("=======> ITEM")
//    println(item.id)
//    println(item.name)
//    println(item.cost)
//    println(item.isSecretShop)
//    println(item.isSideShop)
//    println(item.hasRecipe)
//  }
//
//  println("=======> HEROES")
//  val restHeroesResponse = client.getGameHeroes
//  println("=======> REST RESPONSE")
//  for(hero <- restHeroesResponse) {
//    println("=======> HERO")
//    println(hero.id)
//    println(hero.name)
//  }

  println("=======> ABILITIES")
  val restAbilitiesResponse = client.getHeroAbilities
  println("=======> REST RESPONSE")
  for(ability <- restAbilitiesResponse) {
    println("=======> ITEM")
    println(ability.id)
    println(ability.name)
  }
}