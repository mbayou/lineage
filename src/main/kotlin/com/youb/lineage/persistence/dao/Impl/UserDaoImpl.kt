package com.youb.lineage.persistence.dao.Impl

import com.youb.lineage.ServiceRunner
import com.youb.lineage.persistence.dao.UserDao
import com.youb.lineage.persistence.domain.User
import javax.inject.Inject
import javax.persistence.EntityManager

class UserDaoImpl : UserDao {

    @Inject
    lateinit var em: EntityManager

    init {
        ServiceRunner.serviceComponent.inject(this)
    }

    override fun findById(): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}