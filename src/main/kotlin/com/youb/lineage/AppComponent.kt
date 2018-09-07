package com.youb.lineage

import com.youb.lineage.persistence.PersistenceModule
import com.youb.lineage.persistence.dao.impl.UserDaoImpl
import com.youb.lineage.service.ServiceModule
import com.youb.lineage.service.query.impl.TestQueryServiceImpl
import com.youb.lineage.service.query.impl.UserQueryServiceImpl
import com.youb.lineage.web.rest.TestResource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, PersistenceModule::class])
interface AppComponent {
    fun getApp(): App

    fun inject(serviceRunner: TestQueryServiceImpl)
    fun inject(serviceRunner: TestResource)
    fun inject(serviceRunner: UserDaoImpl)
    fun inject(serviceRunner: UserQueryServiceImpl)
}
