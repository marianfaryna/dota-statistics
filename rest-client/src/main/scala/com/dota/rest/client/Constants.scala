package com.dota.rest.client

/**
  * Constants that are used in applicaiton that are not configurable
  */
object Constants {
  val RestStartAtMatchId = "?start_at_match_id="
  val RestDotaBasicRestUrl = "https://api.steampowered.com/IDOTA2Match_570/"
  val RestDotaEconBasicRestUrl = "https://api.steampowered.com/IEconDOTA2_570/"
  val RestMatchHistoryUrl = RestDotaBasicRestUrl + "GetMatchHistory/V001/?key=%s"
  val RestMatchHistoryUrlStartAt = RestDotaBasicRestUrl + "GetMatchHistory/V001/?key=%s&start_at_match_id=%s"
  val RestMatchDetailsUrl = RestDotaBasicRestUrl +"GetMatchDetails/V001/?match_id=%s&key=%s"
  val RestItemsUrl = RestDotaEconBasicRestUrl + "GetGameItems/V001/?key=%s"
  val RestHeroesUrl = RestDotaEconBasicRestUrl + "GetHeroes/V001/?key=%s"
  val RestAbilitiesUrl = "https://github.com/kronusme/dota2-api/blob/master/data/abilities.json"

}
