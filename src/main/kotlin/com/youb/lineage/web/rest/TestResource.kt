package com.youb.lineage.web.rest

import com.ftpix.sparknnotation.annotations.SparkController
import com.ftpix.sparknnotation.annotations.SparkGet
import com.youb.lineage.ServiceRunner
import com.youb.lineage.service.query.TestQueryService
import com.youb.lineage.service.query.dto.test.TestDetailDto
import com.youb.lineage.web.JsonTransformer
import com.youb.lineage.web.rest.model.test.Test
import javax.inject.Inject

@SparkController("/tests")
class TestResource {

    @Inject
    lateinit var testQueryService: TestQueryService

    @Inject
    constructor()


    init {
        ServiceRunner.serviceComponent.inject(this)
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
}