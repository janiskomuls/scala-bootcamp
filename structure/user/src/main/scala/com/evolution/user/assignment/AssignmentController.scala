package com.evolution.user.assignment

import com.evolution.user.group.domain.GroupName
import com.evolution.user.permission.domain.PermissionName
import com.evolution.user.{Controller, UserService}

class AssignmentController(
    userService: UserService,
) extends Controller {
  // post: api/group/$groupId/permissions
  def assignPermissions(groupId: String, permissionIds: List[String]): Unit =
    userService.assignPermissions(
      GroupName(Extractor.extractId(groupId)),
      permissionIds.map(PermissionName)
    )

  // post: api/user/$userId/groups
  def assignGroups(userId: String, groupIds: List[String]): Unit = ()
}

object Extractor {
  def extractId(value: String): String = value
}
