package com.dota.rest.client

import org.mongodb.scala.{Completed, _}

class DataHandler {

}

object DataHandler {
  def put(id: Int, value:String): Unit = {

    val client: MongoClient = MongoClient("mongodb://admins-MacBook-Pro.local:27017/") //the acrtual host name of parent machine

    val listNamesObservable: Observable[String] = client.listDatabaseNames()

    listNamesObservable.subscribe(new Observer[String] {

      override def onError(e: Throwable): Unit = println(s"onError listNamesObservable: $e")
      override def onComplete(): Unit = println("listNamesObservable onComplete")
      override def onNext(result: String): Unit = println(s"onNext listNamesObservable: $result")
    })

    println("==========> BEFORE PUT")
    println("==========> id")
    println(id)
    println("==========> value")
    println(value)

    val database = client.getDatabase("local")
    val collection: MongoCollection[Document] = database.getCollection("test_collection")
    Thread.sleep(5000)
    val document: Document = Document("_id" -> id, "value" -> value)
    val insertObservable: Observable[Completed] = collection.insertOne(document)
    Thread.sleep(5000)
    insertObservable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext insertObservable: $result")
      override def onError(e: Throwable): Unit = println(s"onError insertObservable: $e")
      override def onComplete(): Unit = println("insertObservable onComplete")
    })
  }
}
