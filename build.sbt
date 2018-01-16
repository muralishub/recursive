name := "Recursive1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1", //version changed as these the only versions supported by 2.12
  "org.scala-lang" % "scala-library" % scalaVersion.value
)