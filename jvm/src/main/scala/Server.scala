package com.chucho

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.actor.ActorSystem


object Server extends App {
	implicit val system = ActorSystem("my-system")
	implicit val materializer = ActorMaterializer()
	implicit val ec = system.dispatcher

	val route =
		path("hello") {
			get {
				complete {
					"<h1>Say hello to akka-http</h1>"
				}

			}
		}

	val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

	println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
		Console.readLine() // for the future transformations
		bindingFuture
			.flatMap(_.unbind()) // trigger unbinding from the port
			.onComplete(_ ⇒ system.terminate()) // and shutdown when done
}
