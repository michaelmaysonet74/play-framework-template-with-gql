package modules

import clients.TemplateClient
import controllers.TemplateController
import services.{TemplateService, TemplateServiceImpl}
import com.softwaremill.macwire.wire
import graphql.schema.TemplateSchema
import play.api.Logger
import play.api.mvc.ControllerComponents
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext

trait TemplateModule extends ControllerModule with ClientModule {

  lazy val templateClient: TemplateClient = wire[TemplateClient]
  lazy val templateService: TemplateService = wire[TemplateServiceImpl]
  lazy val templateController: TemplateController = wire[TemplateController]
  lazy val templateSchema: TemplateSchema = wire[TemplateSchema]

}
