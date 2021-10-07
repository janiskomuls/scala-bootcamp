package com.evolution.casino

import akka.actor.ActorSystem
import com.evolution.casino.updater._

class CasinoModule {
  private val system = ActorSystem("System")
  private val httpClient = new HttpClient
  private val httpConfig = HttpConfig("http://localhost")

  private val casinoRepository = new CasinoRepository
  private val casinoService = new CasinoService(casinoRepository)

  val casinoController = new CasinoController(casinoService)

  private val appHttpClient = new CasinoHttpClient(
    casinoService,
    httpClient,
    httpConfig,
    new JsonParser
  )
  val scheduledUpdates =
    new CasinoScheduledUpdates(appHttpClient, casinoService, system)
}
