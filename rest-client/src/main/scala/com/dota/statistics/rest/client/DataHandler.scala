package com.dota.statistics.rest.client

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.dota.statistics.entity.Player
import com.dota.statistics.entity.matches.Match
import org.mongodb.scala._
import org.mongodb.scala.bson.collection.immutable.Document
import org.mongodb.scala.model.Filters._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class DataHandler(configuration: Properties) {}

object DataHandler {
  val client: MongoClient = MongoClient(Configuration.getValue(Configuration.MongoUrl)) //the actual host name of parent machine

  val database = client.getDatabase(Configuration.getValue(Configuration.MongoDb))
  val collection: MongoCollection[Document] = database.getCollection(Configuration.getValue(Configuration.MongoCollection))
  val callbackDuration : Int = Configuration.getIntValue(Configuration.MongoCallBackDuration)

  def prepareDocument(matchToPersist: Match): Document = {
    Document(DocumentSchema.Id -> matchToPersist.matchId,
      DocumentSchema.RadiantWin -> matchToPersist.radiantWin,
      DocumentSchema.Duration -> matchToPersist.duration,
      DocumentSchema.StartTime -> matchToPersist.startTime,
      DocumentSchema.GameMode -> matchToPersist.gameMode,
      DocumentSchema.DireScore -> matchToPersist.direScore,
      DocumentSchema.Players -> preparePlayersDocument(matchToPersist.players))
  }

  def preparePlayersDocument(players: List[Player]): List[Document] = {
    var playersList = List[Document]()
    for (player <- players) {
      playersList = playersList :+ Document(DocumentSchema.AccountId -> player.accountId,
        DocumentSchema.HeroId -> player.heroId,
        DocumentSchema.Kills -> player.kills,
        DocumentSchema.Deaths -> player.deaths,
        DocumentSchema.Assists -> player.assists,
        DocumentSchema.Denies -> player.denies,
        DocumentSchema.GoldPerMinute -> player.goldPerMinute,
        DocumentSchema.XpPerMinute -> player.xpPerMinute,
        DocumentSchema.Level -> player.level,
        DocumentSchema.HeroDamage -> player.heroDamage,
        DocumentSchema.HeroHealing -> player.heroHealing,
        DocumentSchema.GoldCurrent -> player.goldCurrent,
        DocumentSchema.GoldSpent -> player.goldSpent,
        DocumentSchema.IsDire -> player.isDire
      )
    }
    playersList
  }

  def put(matchToPersist: Match): Unit = {
    val findObservable = collection.find(equal(DocumentSchema.Id, matchToPersist.matchId)).first()

    val foundDocument = Await.result(findObservable.toFuture(), Duration(callbackDuration, TimeUnit.SECONDS))
    if(foundDocument.isEmpty) {
      val documentToPersist = prepareDocument(matchToPersist)
      val insertObservable = collection.insertOne(documentToPersist)
      Await.result(insertObservable.toFuture(), Duration(callbackDuration, TimeUnit.SECONDS))
    }


  }
}

