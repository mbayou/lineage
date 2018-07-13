package com.youb.lineage

import com.youb.lineage.service.ServiceModule
import com.youb.lineage.service.query.impl.TestQueryServiceImpl
import com.youb.lineage.web.rest.TestResource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class])
interface AppComponent {
    fun getApp(): App

    fun inject(serviceRunner: TestQueryServiceImpl)
    fun inject(serviceRunner: TestResource)
}