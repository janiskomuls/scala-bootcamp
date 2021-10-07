package com.evolution.casino

import com.evolution.casino.domain.{Casino, CasinoId, CasinoName}

import java.time.Instant

class CasinoRepository extends AbstractCasinoRepository {
  def lastUpdated: Instant = Instant.now()
  def casinos: List[Casino] = Nil
  def casinoById(id: String): Option[Casino] =
    Some(Casino(CasinoId(id), CasinoName("Test")))
  def save(casino: Casino): Unit = ()
}
