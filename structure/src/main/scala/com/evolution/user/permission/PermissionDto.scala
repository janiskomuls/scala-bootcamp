package com.evolution.user.permission

import com.evolution.user.permission.domain.Permission

final case class PermissionDto(name: String)

object PermissionDto {
  def from(perm: Permission): PermissionDto = apply(perm.name.value)
}
