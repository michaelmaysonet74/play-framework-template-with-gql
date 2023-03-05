package models

import com.rallyhealth.weepickle.v1.WeePickle.{macroTo, To}

final case class CountryByCodeResponse(
  data: CountryByCodeData
)

object CountryByCodeResponse {

  implicit val r: To[CountryByCodeResponse] = macroTo[CountryByCodeResponse]

}

final case class CountryByCodeData(
  country: CountryResponse
)

object CountryByCodeData {

  implicit val r: To[CountryByCodeData] = macroTo[CountryByCodeData]

}
