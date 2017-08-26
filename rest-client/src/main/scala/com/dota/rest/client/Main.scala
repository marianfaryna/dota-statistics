package com.dota.rest.client

class Main {}

object Main extends App {
  val DotaKey = "34DE638F08E3997DEF092DF09C1C5090"

  val client = RestClient
  val dataHandler = DataHandler
  client.steamKey = DotaKey

  var counter: Int = 0

  while (counter < Configuration.getIntValue(Configuration.BatchSize)) {

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