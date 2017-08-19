package com.dota.rest.client

class Main {}

object Main extends App {
  val DOTA_KEY = "34DE638F08E3997DEF092DF09C1C5090"


  val client = RestClient
  val dataHandler = DataHandler
  client.steamKey = DOTA_KEY

  var counter: Int = 0

  while (counter < 10000) {

    val restResponse = client.getMatches
    var latestId : String = ""
    for (playedMatch <- restResponse.matches) {
      val matchDetails = client.getMatchHistory(playedMatch.matchId)
      dataHandler.put(matchDetails)
      latestId = String.valueOf(playedMatch.matchId)

      counter += 1
    }
    client.LatestMatchId = latestId
  }
}