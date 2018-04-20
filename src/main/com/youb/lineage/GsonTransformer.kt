package com.youb.lineage

import com.ftpix.sparknnotation.interfaces.BodyTransformer
import com.google.gson.Gson

class GsonTransformer : BodyTransformer {
    private val gson: Gson = Gson()

    override fun <T : Any?> transform(p0: String?, p1: Class<T>?): T {
        return gson.fromJson(p0, p1)
    }
}