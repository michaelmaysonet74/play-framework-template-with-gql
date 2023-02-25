package graphql.schema

import caliban.GraphQL

trait Schema {

  def api: GraphQL[Any]

}
