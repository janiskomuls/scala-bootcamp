package com.evolution.user.report

import com.evolution.user.{AbstractRepository, UserRepository}
import com.evolution.user.domain.UserId

class UserAnalysisRepository(repository: UserRepository)
    extends AbstractRepository {
  def analysis(userId: UserId): Option[Analysis] = None
}
