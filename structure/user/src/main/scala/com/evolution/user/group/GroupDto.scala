package com.evolution.user.group

import com.evolution.user.group.domain.Group

final case class GroupDto(name: String)

object GroupDto {
  def from(group: Group): GroupDto = apply(group.name.value)
}
