package clients

import caliban.client.Operations.RootQuery
import caliban.client.SelectionBuilder
import com.rallyhealth.weejson.v1.jackson.FromJson
import com.rallyhealth.weepickle.v1.WeePickle.ToScala
import graphql.clients.CoutriesClient.{Country, Query}
import models.{CountryByCodeResponse, CountryResponse}
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
import sttp.client3.UriContext
import sttp.tapir.static.StaticErrorOutput.NotFound

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Success

class CountriesClient(
  ws: WSClient
)(implicit
  ec: ExecutionContext
) {

  def getCountryByCode(code: String): Future[Option[CountryResponse]] = {
    val query: SelectionBuilder[RootQuery, Option[CountryResponse]] = Query.country(code) {
      (Country.name ~ Country.emoji).map { case (name, emoji) => CountryResponse(name, emoji) }
    }

    val request = query.toRequest(uri"https://countries.trevorblades.com/graphql")
    val data = Json.parse(request.body.show.replaceFirst("string: ", ""))

    ws.url(request.uri.toString()).post(data).map { response =>
      val tryCountryByCode =
        FromJson(response.body).validate[CountryByCodeResponse](ToScala[CountryByCodeResponse])

      tryCountryByCode match {
        case Success(countryByCode) =>
          Some(
            CountryResponse(
              name = countryByCode.data.country.name,
              emoji = countryByCode.data.country.emoji
            )
          )
        case _ => None
      }
    }
  }

}
