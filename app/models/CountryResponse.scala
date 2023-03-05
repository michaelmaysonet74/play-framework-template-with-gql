package models

import com.rallyhealth.weepickle.v1.WeePickle.{macroFromTo, FromTo}

final case class CountryResponse(
  name: String,
  emoji: String
)

object CountryResponse {

  implicit val rw: FromTo[CountryResponse] = macroFromTo[CountryResponse]

}
