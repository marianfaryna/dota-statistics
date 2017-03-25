package com.dota.rest.entity.items

import com.fasterxml.jackson.annotation.JsonProperty

/**
  * Created by admin on 3/25/17.
  */
class Item {
  var id: Long = 0L
  var name: String = ""
  var readableName : String = ""
  var cost: Int = 0
  @JsonProperty("secret_shop")
  var isSecretShop: Boolean = false
  @JsonProperty("side_shop")
  var isSideShop: Boolean = false
  @JsonProperty("recipe")
  var hasRecipe: Boolean = false
}
