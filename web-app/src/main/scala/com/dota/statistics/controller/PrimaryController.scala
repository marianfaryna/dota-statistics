package com.dota.statistics.controller

import com.dota.statistics.domain.Match
import com.dota.statistics.repository.MatchRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, ResponseBody}

/**
  * Controller class for web app
  */
@Controller
class PrimaryController @Autowired() (private val matchRepository: MatchRepository) {

  var mapper = new ObjectMapper()

  @RequestMapping(Array("/greeting"))
  @ResponseBody
  def greeting(@RequestParam(value = "name", required = false, defaultValue = "World") name: String, model: Model): String = {

    val matches : java.util.List[Match] = matchRepository.findAll()

    mapper.writer().writeValueAsString(matches)
  }
}
