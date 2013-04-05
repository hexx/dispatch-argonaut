import sbt._,Keys._

object Build extends Build {
  lazy val baseSettings = Seq(
    scalaVersion := "2.10.1",
    organization := "com.github.hexx",
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")
  )

  lazy val dispatchArgonaut = Project(
    id = "dispatch-argonaut",
    base = file(".")
  ).settings(
    baseSettings ++ seq(
      name := "dispatch-argonaut",
      version := "0.0.1",
      libraryDependencies ++= Seq(
        "net.databinder.dispatch" %% "dispatch-core" % "0.10.0-beta2",
        "io.argonaut" %% "argonaut" % "6.0-M3"
      ),
      initialCommands in console += Seq(
        "argonaut._",
        "Argonaut._",
        "dispatch._",
        "scala.concurrent.ExecutionContext.Implicits.global"
      ).map("import " + _ + "\n").mkString
    ) : _*
  )
}
