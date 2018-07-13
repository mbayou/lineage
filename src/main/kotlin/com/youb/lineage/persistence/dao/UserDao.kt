package com.youb.lineage.persistence.dao

import com.youb.lineage.persistence.domain.User

interface UserDao {

    fun findById(): User
}