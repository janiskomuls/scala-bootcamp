package com.evolution.user

object UserMain extends App {
  val user = new UserModule
  import user._

  val httpServer = new HttpServer(
    assignmentController,
    userController,
    groupController,
    permissionController,
    userReportController,
  )

  httpServer.start()
}

trait Controller

class HttpServer(controllers: Controller*) {
  def start(): Unit = println(s"Server Started for $controllers")
}
