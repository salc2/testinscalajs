import sbt.Keys._

lazy val root = project.in(file(".")).
aggregate(testJS.enablePlugins(ScalaJSPlugin), testJVM).
settings(
	publish := {},
	publishLocal := {}
)

lazy val test = crossProject.in(file(".")).
settings(
	name := "Scala.js Sample",
	organization := "com.chucho",
	version := "0.1.0",
	scalaVersion := "2.11.7"
).
jvmSettings(
	libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.2",
	libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.2"
).
jsSettings(
	libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)

lazy val testJVM = test.jvm
lazy val testJS = test.js
compile <<= (compile in Compile) dependsOn (fastOptJS in Compile in testJS)

