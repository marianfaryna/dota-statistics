package com.dota.rest.client

class Main {}

/**
  * Program entry point
  */
object Main extends App {
  val DotaKey = Configuration.getValue("rest.dota.key")

  val client = RestClient
  val dataHandler = DataHandler
  client.steamKey = DotaKey

  if(client.steamKey.isEmpty) {
    throw new RuntimeException("No Steam WEBAPI key provided")
  }

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