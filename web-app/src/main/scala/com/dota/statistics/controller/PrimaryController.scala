package com.dota.statistics.controller

import java.util

import com.dota.statistics.domain.Match
import com.dota.statistics.repository.MatchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam}

/**
  * Controller class for web app
  */
@Controller
class PrimaryController @Autowired() (private val matchRepository: MatchRepository) {
  @RequestMapping(Array("/greeting"))
  def greeting(@RequestParam(value = "name", required = false, defaultValue = "World") name: String, model: Model): String = {

    val matches : util.List[Match] = matchRepository.findAll()
    model.addAttribute("name", name)
    "greeting"
  }
}
