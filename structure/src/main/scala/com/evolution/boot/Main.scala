package com.evolution.boot

import com.evolution.casino._
import com.evolution.infrastructure.http.HttpServer
import com.evolution.user._

object Main extends App {
  val user = new UserModule
  val casino = new CasinoModule
  import casino._
  import user._

  val httpServer = new HttpServer(
    assignmentController,
    userController,
    casinoController,
    groupController,
    permissionController,
    userReportController,
  )

  httpServer.start()
  scheduledUpdates.start()
}
