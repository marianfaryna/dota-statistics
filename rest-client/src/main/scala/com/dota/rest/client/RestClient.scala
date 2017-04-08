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
  var latestMatchId :String = "" //start_at_match_id=${match_id}

  val DOTA_KEY = "34DE638F08E3997DEF092DF09C1C5090"
  val START_AT_MATCH_ID = "?start_at_match_id="
  val DOTA_BASIC_REST_URL = "https://api.steampowered.com/IDOTA2Match_570/"
  val DOTA_ECON_BASIC_REST_URL = "https://api.steampowered.com/IEconDOTA2_570/"
  val MATCH_HISTORY_URL = DOTA_BASIC_REST_URL + "GetMatchHistory/V001/?key=%s"
  val MATCH_HISTORY_URL_START_AT = DOTA_BASIC_REST_URL + "GetMatchHistory/V001/?key=%s&start_at_match_id=%s"
  val MATCH_DETAILS_URL = DOTA_BASIC_REST_URL +"GetMatchDetails/V001/?match_id=%s&key=%s"
  val ITEMS_URL = DOTA_ECON_BASIC_REST_URL + "GetGameItems/V001/?key=%s"
  val HEROES_URL = DOTA_ECON_BASIC_REST_URL + "GetHeroes/V001/?key=%s"
  val ABILITIES_URL = "https://github.com/kronusme/dota2-api/blob/master/data/abilities.json"

  def getMatches: Result = {
    val client = ClientBuilder.newBuilder().build()
    var matchesUrl: String = ""

    if(StringUtils.isEmpty(latestMatchId)) {
      matchesUrl = String.format(MATCH_HISTORY_URL, DOTA_KEY)
    } else {
      matchesUrl = String.format(MATCH_HISTORY_URL_START_AT, DOTA_KEY, latestMatchId)
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
    val target = client.target(String.format(MATCH_DETAILS_URL, matchId.toString, DOTA_KEY))
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[DetailsResponse]).result

  }

def getGameItems: List[Item] = {
  val client = ClientBuilder.newBuilder().build()
  val target = client.target(String.format(ITEMS_URL, DOTA_KEY))
  val response = target.request().get()

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  mapper.readValue(response.readEntity(classOf[String]), classOf[ItemsResponse]).result.items
}

  def getGameHeroes: List[Hero] = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(String.format(HEROES_URL, DOTA_KEY))
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[HeroesResponse]).result.heroes
  }

  def getHeroAbilities: List[Ability] = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(ABILITIES_URL)
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[AbilitiesResponse]).abilities
  }
}
