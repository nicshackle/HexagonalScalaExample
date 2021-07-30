name := "exampleHexagonalScalaService"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  "net.debasishg" %% "redisclient" % "3.30",
  "com.typesafe.akka" %% "akka-stream" % "2.6.8",
  "com.typesafe.akka" %% "akka-http" % "10.2.1"
)

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

// set the main class for 'sbt run'
mainClass in (Compile, run) := Some("SensorApp")