package com.evolution.user

import com.evolution.user.assignment.AssignmentController
import com.evolution.user.group.{GroupController, GroupService}
import com.evolution.user.permission.{PermissionController, PermissionService}
import com.evolution.user.report.{
  UserAnalysisRepository,
  UserReportController,
  UserReportService,
  UserReportsRepository
}

class UserModule {

  private val userConfig = UserConfig()

  private val userRepository = new UserRepository
  private val userAnalysisRepository = new UserAnalysisRepository(
    userRepository)
  private val userReportsRepository = new UserReportsRepository(userRepository)
  private val userReportService =
    new UserReportService(userAnalysisRepository, userReportsRepository)
  private val userService = new UserService(
    userRepository,
    userConfig
  )
  private val permissionService = new PermissionService(userRepository)
  private val groupService = new GroupService(userRepository)

  val assignmentController = new AssignmentController(userService)
  val userController = new UserController(userService)
  val permissionController = new PermissionController(permissionService)
  val groupController = new GroupController(groupService)
  val userReportController =
    new UserReportController(userService, userReportService)
}
