package com.evolution.casino.updater

import akka.actor.ActorSystem
import com.evolution.casino.CasinoService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class CasinoScheduledUpdates(
    client: CasinoHttpClient,
    casinoService: CasinoService,
    system: ActorSystem
) {
  def start(): Unit =
    system.scheduler.schedule(initialDelay = 1.second, interval = 5.seconds)(
      casinoService.saveAll(client.retrieveCasinos)
    )
}
