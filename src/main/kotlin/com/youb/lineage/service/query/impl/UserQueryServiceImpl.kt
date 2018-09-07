package com.youb.lineage.service.query.impl

import com.youb.lineage.ServiceRunner
import com.youb.lineage.persistence.dao.UserDao
import com.youb.lineage.persistence.domain.User
import com.youb.lineage.service.query.UserQueryService
import com.youb.lineage.service.query.dto.user.UserDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserQueryServiceImpl : UserQueryService {

    @Inject
    lateinit var userDao: UserDao

    @Inject
    constructor()

    init {
        ServiceRunner.serviceComponent.inject(this)
    }

    override fun findAllUsers(): List<UserDto> {
        val userDtos: MutableList<UserDto> = ArrayList()
        val users: List<User> = userDao.findAll()

        for (user in users) {
            val userDto = UserDto()
            userDto.id = user.id
            userDtos.add(userDto)
        }

        return userDtos
    }
}