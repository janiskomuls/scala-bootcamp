package com.evolution.user.report

import com.evolution.user.{AbstractRepository, UserRepository}
import com.evolution.user.domain.UserId

class UserReportsRepository(repository: UserRepository)
    extends AbstractRepository {
  def report(userId: UserId, reportId: ReportId): Option[Report] = None
}
