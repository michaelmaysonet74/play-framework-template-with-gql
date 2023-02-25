package modules

import akka.stream.Materializer
import com.softwaremill.macwire.wire
import controllers.GraphQLController

import scala.concurrent.ExecutionContext

trait GraphQLModule extends TemplateModule {

  implicit def ec: ExecutionContext

  implicit def mat: Materializer

  lazy val graphQLController: GraphQLController = wire[GraphQLController]

}
