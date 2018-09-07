package com.youb.lineage.persistence.dao.impl

import com.youb.lineage.ServiceRunner
import com.youb.lineage.persistence.dao.UserDao
import com.youb.lineage.persistence.domain.User
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.transaction.Transactional

class UserDaoImpl @Inject constructor() : UserDao {

    @Inject
    lateinit var em: EntityManager

    init {
        ServiceRunner.serviceComponent.inject(this)
    }

    @Transactional
    override fun findAll(): List<User> {
        val user = User()
        em.persist(user)

        val query = this.em.criteriaBuilder.createQuery(User::class.java)
        query.from(User::class.java)
        return this.em.createQuery(query).resultList
    }

    @Transactional
    override fun findById(): User {
        val user = User()
        this.em.persist(user)

        return this.em.find(User::class.java, 1)
    }

}