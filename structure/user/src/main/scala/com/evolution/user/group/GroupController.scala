package com.evolution.user.group

import com.evolution.user.Controller
import com.evolution.user.group.domain.{Group, GroupName}

class GroupController(groupService: GroupService) extends Controller {
  // post: api/group
  def addGroup(group: GroupDto): Unit =
    groupService.addGroup(Group(GroupName(group.name)))

  // delete: api/group
  def deleteGroup(group: GroupDto): Unit =
    groupService.deleteGroup(Group(GroupName(group.name)))
}
