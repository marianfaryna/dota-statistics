package com.dota.statistics.repository

import com.dota.statistics.domain.Player
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

/**
  * Repository layer for Player document
  */
@Component
trait PlayerRepository extends MongoRepository[Player, String]
