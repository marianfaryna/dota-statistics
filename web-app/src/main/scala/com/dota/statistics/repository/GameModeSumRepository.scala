package com.dota.statistics.repository

import com.dota.statistics.domain.GameModeSum
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

/**
  * repository layer for game mode sums documents
  */
@Component
trait GameModeSumRepository extends MongoRepository[GameModeSum, ObjectId]
