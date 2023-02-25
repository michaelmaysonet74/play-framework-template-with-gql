import sbt._

object Dependencies {

  private val macwireVersion = "2.5.7"
  private val calibanVersion = "2.0.2"

  lazy val scalaTest = "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0"
  lazy val macwireMacros = "com.softwaremill.macwire" %% "macros" % macwireVersion
  lazy val macwireUtil = "com.softwaremill.macwire" %% "util" % macwireVersion
  lazy val caliban = "com.github.ghostdogpr" %% "caliban" % calibanVersion
  lazy val calibanPlay = "com.github.ghostdogpr" %% "caliban-play" % calibanVersion

}
