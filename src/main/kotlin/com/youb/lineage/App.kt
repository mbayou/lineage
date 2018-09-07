package com.youb.lineage

import com.ftpix.sparknnotation.Sparknotation
import com.ftpix.sparknnotation.annotations.SparkAfter
import com.ftpix.sparknnotation.annotations.SparkBefore
import com.youb.lineage.web.rest.AuthenticationResource
import com.youb.lineage.web.rest.TestResource
import spark.kotlin.port
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.TransactionManager

@Singleton
class App {

    private var testResource: TestResource

    private var authenticationResource: AuthenticationResource

    private var transactionManager: TransactionManager

    private var em: EntityManager

    @Inject
    constructor(testResource: TestResource, authenticationResource: AuthenticationResource, em: EntityManager) {
        port(2134)
        Sparknotation.init(GsonTransformer())
        this.testResource = testResource
        this.authenticationResource = authenticationResource
        this.transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager()
        this.em = em

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
}