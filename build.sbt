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
		version := "0.1.0"
	).
	jvmSettings(
    // Add JVM-specific settings here
	).
	jsSettings(
		libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"
	)

	lazy val testJVM = test.jvm
	lazy val testJS = test.js
/*
artifactPath in fastOptJS :=
	(resourceManaged in testJVM in Compile).value /
		((moduleName in fastOptJS).value + "-fastopt.js")*/