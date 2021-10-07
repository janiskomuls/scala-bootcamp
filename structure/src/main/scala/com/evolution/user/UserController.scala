package com.evolution.user

import com.evolution.user.group.GroupDto
import com.evolution.infrastructure.http.Controller
import com.evolution.user.permission.PermissionDto
import com.evolution.user.domain._
import com.evolution.user.report.ReportId

import java.util.UUID

class UserController(
    userService: UserService,
) extends Controller {
  // get: api/user/$userId
  def userById(id: String): Option[UserDto] =
    userService.userById(UserId(id)).map(UserDto.from)

  // get: api/user/$userId/permissions
  def userPermissions(id: String): List[PermissionDto] =
    userService.userById(UserId(id)).toList.flatMap { user =>
      userService.userPermissions(user).map(PermissionDto.from)
    }

  // get: api/user/$userId/groups
  def userGroups(id: String): List[GroupDto] =
    userService.userById(UserId(id)).toList.flatMap { user =>
      userService.userGroups(user).map(GroupDto.from)
    }

  // post: api/user
  def addUser(user: UserDto): Unit =
    userService.addUser(
      User(
        UserId(UUID.randomUUID().toString),
        UserLogin(user.login),
        UserFirstName(user.name),
        UserLastName(user.lastName)
      )
    )

}
