import sbt._
import Keys._

object ApplicationBuild extends Build {
  import sbtrelease.ReleasePlugin._

  val buildName         = "play-json-zipper"    

  val mandubianRepo = Seq(
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Mandubian repository snapshots" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/",
    "Mandubian repository releases" at "https://github.com/mandubian/mandubian-mvn/raw/master/releases/"
  )

  lazy val playJsZipper = Project(
    buildName, file("."),
    settings = Defaults.defaultSettings ++ releaseSettings ++ Seq(
      resolvers ++= mandubianRepo,
      scalaVersion := "2.10.2",
      libraryDependencies ++= Seq(
        "com.typesafe.play"   %% "play-json"  % "2.2.0"          ,
        "org.specs2"          %% "specs2"     % "1.13"   % "test",
        "junit"                % "junit"      % "4.8"    % "test"
      )
    )
  )
}
