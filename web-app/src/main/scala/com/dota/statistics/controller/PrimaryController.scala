package com.dota.statistics.controller

import java.util.{Collections, Comparator}

import com.dota.statistics.GameMode
import com.dota.statistics.domain.GameModeSum
import com.dota.statistics.repository.GameModeSumRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}

/**
  * Controller class for web app
  */
@Controller
class PrimaryController @Autowired()(private val gameModeSumRepository: GameModeSumRepository) {

  val reversedComparator = new Comparator[GameModeSum] {
    def compare(x: GameModeSum, y: GameModeSum) = -(x.sum compareTo y.sum)
  }

  var mapper = new ObjectMapper()

  /**
    * returns data related to calculated game mode played matches
    *
    * @return calculated game mods as JSON
    */
  @RequestMapping(Array("/game-mods-data"))
  @ResponseBody
  def getGameModsData: String = {

    val gameModeSums: java.util.List[GameModeSum] = gameModeSumRepository.findAll()
    Collections.sort(gameModeSums, reversedComparator)

    mapper.writer().writeValueAsString(gameModeSums)
  }

  /**
    * return existent game modes
    *
    * @return existent game mods as JSON array of strings
    */
  @RequestMapping(Array("/game-mods"))
  @ResponseBody
  def getGameModes: String = {

    val gameModeSums: java.util.List[GameModeSum] = gameModeSumRepository.findAll()
    Collections.sort(gameModeSums, reversedComparator)


    val gameModeNames: java.util.List[String] = new java. util. ArrayList[String]()

    import scala.collection.JavaConversions._
    gameModeSums.foreach(modeSum => gameModeNames.add(GameMode.getByModeId(modeSum.gameMode).toString))

    mapper.writer().writeValueAsString(gameModeNames)
  }
}
