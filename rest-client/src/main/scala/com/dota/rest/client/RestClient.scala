package com.dota.rest.client

import javax.ws.rs.client.ClientBuilder

import com.dota.rest.entity.abilities.{AbilitiesResponse, Ability}
import com.dota.rest.entity.heroes.{Hero, HeroesResponse}
import com.dota.rest.entity.items.{Item, ItemsResponse}
import com.dota.rest.entity.matches.{Match, Response, Result, _}
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.commons.lang3.StringUtils

class RestClient {

}

object RestClient {
  var LatestMatchId :String = _ //start_at_match_id=${match_id}

  var steamKey :String = _
//todo constant StartAtMatchId
  val StartAtMatchId = "?start_at_match_id="
  val DotaBasicRestUrl = "https://api.steampowered.com/IDOTA2Match_570/"
  val DotaEconBasicRestUrl = "https://api.steampowered.com/IEconDOTA2_570/"
  val MatchHistoryUrl = DotaBasicRestUrl + "GetMatchHistory/V001/?key=%s"
  val MatchHistoryUrlStartAt = DotaBasicRestUrl + "GetMatchHistory/V001/?key=%s&start_at_match_id=%s"
  val MatchDetailsUrl = DotaBasicRestUrl +"GetMatchDetails/V001/?match_id=%s&key=%s"
  val ItemsUrl = DotaEconBasicRestUrl + "GetGameItems/V001/?key=%s"
  val HeroesUrl = DotaEconBasicRestUrl + "GetHeroes/V001/?key=%s"
  val AbilitiesUrl = "https://github.com/kronusme/dota2-api/blob/master/data/abilities.json"

  def getMatches: Result = {
    val client = ClientBuilder.newBuilder().build()
      var matchesUrl: String = ""
//todo don't use var at all atleast try to do this
    // ""== latestMatchId
//    s"bla bla $matchesUrl"
    if(StringUtils.isEmpty(LatestMatchId)) {
      matchesUrl = String.format(MatchHistoryUrl, steamKey)
    } else {
      matchesUrl = String.format(MatchHistoryUrlStartAt, steamKey, LatestMatchId)
    }

    val target = client.target(matchesUrl)
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[Response]).result
  }

  def getMatchHistory(matchId : Long): Match = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(String.format(MatchDetailsUrl, matchId.toString, steamKey))
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[DetailsResponse]).result

  }

def getGameItems: List[Item] = {
  val client = ClientBuilder.newBuilder().build()
  val target = client.target(String.format(ItemsUrl, steamKey))
  val response = target.request().get()

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  mapper.readValue(response.readEntity(classOf[String]), classOf[ItemsResponse]).result.items
}

  def getGameHeroes: List[Hero] = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(String.format(HeroesUrl, steamKey))
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[HeroesResponse]).result.heroes
  }

  def getHeroAbilities: List[Ability] = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(AbilitiesUrl)
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[AbilitiesResponse]).abilities
  }
}
