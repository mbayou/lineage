package com.youb.lineage.persistence

import com.youb.lineage.persistence.dao.Impl.UserDaoImpl
import com.youb.lineage.persistence.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideEntityManager(): EntityManager {
        //build the EntityManagerFactory as you would build in in Hibernate ORM
        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("ogm-jpa-tutorial")
        return emf.createEntityManager()
    }

    @Provides
    @Singleton
    fun provideTestQueryService(): UserDao {
        return UserDaoImpl()
    }
}