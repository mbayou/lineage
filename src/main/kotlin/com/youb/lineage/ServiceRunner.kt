package com.youb.lineage

import com.youb.lineage.service.ServiceModule
import org.slf4j.LoggerFactory

class ServiceRunner {
    companion object {
        private val logger = LoggerFactory.getLogger(
                ServiceRunner::class.java)

        //platformStatic allow access it from java code
        @JvmStatic
        lateinit var serviceComponent: AppComponent
    }

    init {
        serviceComponent = DaggerAppComponent.builder()
                .serviceModule(ServiceModule())
                .build()
    }

}