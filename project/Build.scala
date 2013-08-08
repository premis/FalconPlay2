import sbt._
import sbt.Keys._
import play.Project._
import java.util._

object ApplicationBuild extends Build {

  val appName         = "FalconPlay"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.typesafe" %% "play-plugins-redis" % "2.1-1-RC2",
    javaCore,
    javaJdbc,
    javaEbean
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers += "Sedis Repo" at "http://pk11-scratch.googlecode.com/svn/trunk",
    templatesImport += "java.util._"
  )

}
