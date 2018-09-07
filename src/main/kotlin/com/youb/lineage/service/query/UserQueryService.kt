package com.youb.lineage.service.query

import com.youb.lineage.service.query.dto.user.UserDto

interface UserQueryService {
    fun findAllUsers(): List<UserDto>
}