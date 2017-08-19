package com.dota.rest.client

import java.util.concurrent.TimeUnit

import com.dota.rest.entity.Player
import com.dota.rest.entity.matches.Match
import org.mongodb.scala._
import org.mongodb.scala.bson.collection.immutable.Document
import org.mongodb.scala.model.Filters._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class DataHandler {
//ask about constructor params that are accesible from object
}

object DataHandler {
  val client: MongoClient = MongoClient("mongodb://localhost:27017") //the actual host name of parent machine

  val database = client.getDatabase("local")
  val collection: MongoCollection[Document] = database.getCollection("test_collection")

  def prepareDocument(matchToPersist: Match): Document = {
    Document("_id" -> matchToPersist.matchId,
      "radiantWin" -> matchToPersist.radiantWin,
      "duration" -> matchToPersist.duration,
      "startTime" -> matchToPersist.startTime,
      "gameMode" -> matchToPersist.gameMode,
      "direScore" -> matchToPersist.direScore,
      "players" -> preparePlayersDocument(matchToPersist.players))
  }

  def preparePlayersDocument(players: List[Player]): List[Document] = {
    var playersList = List[Document]()
    for (player <- players) {
      player.defineSide()
      playersList = playersList :+ Document("accountId" -> player.accountId,
        "heroId" -> player.heroId,
        "kills" -> player.kills,
        "deaths" -> player.deaths,
        "assists" -> player.assists,
        "denies" -> player.denies,
        "goldPerMinute" -> player.goldPerMinute,
        "xpPerMinute" -> player.xpPerMinute,
        "level" -> player.level,
        "heroDamage" -> player.heroDamage,
        "heroHealing" -> player.heroHealing,
        "goldCurrent" -> player.goldCurrent,
        "goldSpent" -> player.goldSpent,
        "isDire" -> player.isDire
      )
    }
    playersList
  }

  def put(matchToPersist: Match): Unit = {
    val findObservable = collection.find(equal("_id", matchToPersist.matchId)).first()

    val foundDocument = Await.result(findObservable.toFuture(), Duration(10, TimeUnit.SECONDS))
    if(foundDocument.isEmpty) {
      val documentToPersist = prepareDocument(matchToPersist)
      val insertObservable = collection.insertOne(documentToPersist)
      Await.result(insertObservable.toFuture(), Duration(10, TimeUnit.SECONDS))
    }


  }
}

