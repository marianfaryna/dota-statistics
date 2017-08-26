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

  def getMatches: Result = {
    val client = ClientBuilder.newBuilder().build()
      var matchesUrl: String = ""
//todo don't use var at all atleast try to do this
    // ""== latestMatchId
//    s"bla bla $matchesUrl"
    if(StringUtils.isEmpty(LatestMatchId)) {
      matchesUrl = String.format(Constants.RestMatchHistoryUrl, steamKey)
    } else {
      matchesUrl = String.format(Constants.RestMatchHistoryUrlStartAt, steamKey, LatestMatchId)
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
    val target = client.target(String.format(Constants.RestMatchDetailsUrl, matchId.toString, steamKey))
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[DetailsResponse]).result

  }

def getGameItems: List[Item] = {
  val client = ClientBuilder.newBuilder().build()
  val target = client.target(String.format(Constants.RestItemsUrl, steamKey))
  val response = target.request().get()

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  mapper.readValue(response.readEntity(classOf[String]), classOf[ItemsResponse]).result.items
}

  def getGameHeroes: List[Hero] = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(String.format(Constants.RestHeroesUrl, steamKey))
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[HeroesResponse]).result.heroes
  }

  def getHeroAbilities: List[Ability] = {
    val client = ClientBuilder.newBuilder().build()
    val target = client.target(Constants.RestAbilitiesUrl)
    val response = target.request().get()

    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue(response.readEntity(classOf[String]), classOf[AbilitiesResponse]).abilities
  }
}
