
name := "layer17"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.1"

resolvers += "Akka Release Repository" at "http://repo.akka.io/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.3",
  "org.specs2" % "specs2_2.10" % "1.14" % "test"
)
