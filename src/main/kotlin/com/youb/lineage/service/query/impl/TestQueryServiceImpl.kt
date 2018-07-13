package com.youb.lineage.service.query.impl

import com.youb.lineage.ServiceRunner
import com.youb.lineage.persistence.dao.UserDao
import com.youb.lineage.service.query.TestQueryService
import com.youb.lineage.service.query.dto.test.TestDetailDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestQueryServiceImpl : TestQueryService {

    @Inject
    lateinit var userDao: UserDao

    @Inject
    constructor()

    init {
        ServiceRunner.serviceComponent.inject(this)
    }

    override fun findAllTests(): List<TestDetailDto> {
        val testList: MutableList<TestDetailDto> = ArrayList()

        for (i in 0..10) {
            var test: TestDetailDto = TestDetailDto()
            test.item1 = "toto$i"
            test.item2 = i
            test.item3 = i % 2 == 0
            testList.add(test)
        }

        return testList
    }
}