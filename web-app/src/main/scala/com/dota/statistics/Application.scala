package com.dota.statistics

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * Main application class
  */
@SpringBootApplication
class Application {
}

object Application extends App {
  SpringApplication.run(classOf[Application], args:_*)
}