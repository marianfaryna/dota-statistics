package com.dota.statistics.repository

import com.dota.statistics.domain.Match
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

/**
  * repository layer for Match documents
  */
@Component
trait MatchRepository extends MongoRepository[Match, String]
