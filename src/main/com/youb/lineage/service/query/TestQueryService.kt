package com.youb.lineage.service.query

import com.youb.lineage.service.query.dto.test.TestDetailDto

interface TestQueryService {
    fun findAllTests(): List<TestDetailDto>
}