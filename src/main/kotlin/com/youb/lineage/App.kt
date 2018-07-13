package com.youb.lineage

import com.ftpix.sparknnotation.Sparknotation
import com.youb.lineage.web.rest.AuthenticationResource
import com.youb.lineage.web.rest.TestResource
import spark.kotlin.port
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class App {

    private var testResource: TestResource

    private var authenticationResource: AuthenticationResource

    @Inject
    constructor(testResource: TestResource, authenticationResource: AuthenticationResource) {
        port(2134)
        Sparknotation.init(GsonTransformer())
        this.testResource = testResource
        this.authenticationResource = authenticationResource
    }
}