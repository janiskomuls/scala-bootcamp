package com.evolution.user.report

import com.evolution.infrastructure.http.Controller
import com.evolution.user.UserService
import com.evolution.user.domain.UserId

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
