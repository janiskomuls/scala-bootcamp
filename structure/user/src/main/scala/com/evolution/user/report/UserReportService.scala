package com.evolution.user.report

import com.evolution.user.domain.User

class UserReportService(
    userAnalysisRepository: UserAnalysisRepository,
    userReportsRepository: UserReportsRepository,
) {
  def report(user: User, reportId: ReportId): Option[Report] =
    userReportsRepository.report(user.id, reportId)

  def analysis(user: User): Option[Analysis] =
    userAnalysisRepository.analysis(user.id)
}
