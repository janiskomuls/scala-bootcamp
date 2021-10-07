package com.evolution.casino

object CasinoMain extends App {
  val casino = new CasinoModule
  import casino._

  val httpServer = new HttpServer(
    casinoController,
  )

  httpServer.start()
  scheduledUpdates.start()
}

trait Controller

class HttpServer(controllers: Controller*) {
  def start(): Unit = println(s"Server Started for $controllers")
}
