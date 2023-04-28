val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "PP",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test, 
    libraryDependencies += "com.github.piotr-kalanski" % "splot" % "0.2.0",
    libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.32.0"
   
  )