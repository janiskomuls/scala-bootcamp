package com.evolution.user.group

import com.evolution.user.domain._
import com.evolution.user.group.domain.Group
import com.evolution.user.UserRepository

class GroupService(userRepository: UserRepository) {
  def addGroup(group: Group): Unit = userRepository.addGroup(group)
  def deleteGroup(group: Group): Unit = userRepository.deleteGroup(group)
}
