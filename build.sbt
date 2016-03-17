import sbt.Keys._
lazy val commonSettings = Seq(
  organization := "com.chucho",
  version := "0.1.0"
)

lazy val root = project.in(file(".")).
  aggregate(testJS, testJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val test = crossProject.in(file(".")).
  settings(commonSettings: _*).
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
	).enablePlugins(ScalaJSPlugin)

	lazy val testJVM = test.jvm
	lazy val testJS = test.js


