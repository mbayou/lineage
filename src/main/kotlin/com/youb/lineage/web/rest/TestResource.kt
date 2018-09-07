package com.youb.lineage.web.rest

import com.ftpix.sparknnotation.annotations.SparkAfter
import com.ftpix.sparknnotation.annotations.SparkBefore
import com.ftpix.sparknnotation.annotations.SparkController
import com.ftpix.sparknnotation.annotations.SparkGet
import com.youb.lineage.ServiceRunner
import com.youb.lineage.service.query.TestQueryService
import com.youb.lineage.service.query.UserQueryService
import com.youb.lineage.service.query.dto.test.TestDetailDto
import com.youb.lineage.service.query.dto.user.UserDto
import com.youb.lineage.web.JsonTransformer
import com.youb.lineage.web.rest.model.test.Test
import com.youb.lineage.web.rest.model.user.User
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.transaction.TransactionManager

@SparkController("/tests")
class TestResource {

    @Inject
    lateinit var testQueryService: TestQueryService

    @Inject
    lateinit var userQueryService: UserQueryService

    var transactionManager: TransactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager()

    @Inject
    lateinit var em: EntityManager


    @Inject
    constructor()


    init {
        ServiceRunner.serviceComponent.inject(this)
    }

    @SparkBefore("/*")
    fun beforeRequest() {
        this.transactionManager.begin()
        em.joinTransaction()
    }

    @SparkAfter("/*")
    fun afterRequest() {
        this.transactionManager.commit()
    }


    @SparkGet(value = "", transformer = JsonTransformer::class)
    fun findTests(): MutableList<Test> {
        val testListDtos = testQueryService.findAllTests()
        val testList: MutableList<Test> = ArrayList()

        for (testDto: TestDetailDto in testListDtos) {
            val test = Test()
            test.item1 = testDto.item1
            test.item3 = testDto.item3
            testList.add(test)
        }

        return testList
    }

    @SparkGet(value = "/toto", transformer = JsonTransformer::class)
    fun findUsers(): MutableList<User> {
        val userListDtos = userQueryService.findAllUsers()
        val userList: MutableList<User> = ArrayList()

        for (userDto: UserDto in userListDtos) {
            val user = User()
            user.id = userDto.id
            userList.add(user)
        }

        return userList
    }
}