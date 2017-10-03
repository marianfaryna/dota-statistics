package com.dota.statistics.entity.items

import com.fasterxml.jackson.annotation.JsonProperty

case class Item(
                 id: Long,
                 name: String,
                 readableName: String,
                 cost: Int,
                 @JsonProperty("secret_shop")
                 isSecretShop: Boolean,
                 @JsonProperty("side_shop")
                 isSideShop: Boolean,
                 @JsonProperty("recipe")
                 hasRecipe: Boolean
               )
