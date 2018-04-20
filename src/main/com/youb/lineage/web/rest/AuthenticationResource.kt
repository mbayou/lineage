package com.youb.lineage.web.rest

import com.ftpix.sparknnotation.annotations.SparkController
import com.ftpix.sparknnotation.annotations.SparkGet
import com.ftpix.sparknnotation.annotations.SparkQueryParam
import javax.inject.Inject

@SparkController(value = "/authentication")
class AuthenticationResource {

    @Inject
    constructor()

    @SparkGet(value = "")
    public fun authentication(@SparkQueryParam("name") username: String, @SparkQueryParam("pwd") password: String) {

    }
}