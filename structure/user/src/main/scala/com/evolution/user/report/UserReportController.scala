package com.evolution.user.report

import com.evolution.user.domain.UserId
import com.evolution.user.{Controller, UserService}

class UserReportController(
    userService: UserService,
    reportService: UserReportService
) extends Controller {
  // get: api/user/$userId/report/$reportId
  def report(userId: String, reportId: String): Option[_] =
    userService.userById(UserId(userId)).flatMap { user =>
      reportService.report(user, ReportId(reportId))
    }

  // get: api/user/$userId/analysis
  def analysis(userId: String): Option[_] =
    userService.userById(UserId(userId)).flatMap { user =>
      reportService.analysis(user)
    }
}
