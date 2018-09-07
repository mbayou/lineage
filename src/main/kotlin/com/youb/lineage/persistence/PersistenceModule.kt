package com.youb.lineage.persistence

import com.arjuna.ats.jta.TransactionManager
import com.youb.lineage.persistence.dao.UserDao
import com.youb.lineage.persistence.dao.impl.UserDaoImpl
import dagger.Module
import dagger.Provides
import eu.infomas.annotation.AnnotationDetector
import org.hibernate.jpa.AvailableSettings
import javax.inject.Singleton
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

@Module
class PersistenceModule {

    private val emf: EntityManagerFactory

    constructor() {
        val entities = mutableListOf<Class<*>>()
        AnnotationDetector(object : AnnotationDetector.TypeReporter {
            override fun reportTypeAnnotation(annotation: Class<out Annotation>?, className: String?) {
                entities.add(Class.forName(className))
            }

            override fun annotations(): Array<out Class<out Annotation>> = arrayOf(Entity::class.java)
        }).detect("com.youb.lineage.persistence.domain")

        this.emf = Persistence.createEntityManagerFactory(
            "ogm-jpa-tutorial",
            mapOf(AvailableSettings.LOADED_CLASSES to entities)
        )
    }


    @Provides
    @Singleton
    fun provideEntityManager(): EntityManager {
        //build the EntityManagerFactory as you would build in in Hibernate ORM
        val transactionManager = TransactionManager.transactionManager()
        transactionManager.begin()
        val em: EntityManager = this.emf.createEntityManager()
        em.joinTransaction()
        transactionManager.commit()

        return em
    }

    @Provides
    @Singleton
    fun provideTestQueryService(): UserDao {
        return UserDaoImpl()
    }
}