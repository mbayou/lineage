package com.youb.lineage.service

import com.youb.lineage.service.command.TestCommandService
import com.youb.lineage.service.command.impl.TestCommandServiceImpl
import com.youb.lineage.service.query.TestQueryService
import com.youb.lineage.service.query.impl.TestQueryServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideTestQueryService(): TestQueryService {
        return TestQueryServiceImpl()
    }

    @Provides
    @Singleton
    fun provideTestCommandService(): TestCommandService {
        return TestCommandServiceImpl()
    }
}