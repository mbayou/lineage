package com.youb.lineage.web

import com.google.gson.Gson
import spark.ResponseTransformer

class JsonTransformer : ResponseTransformer {
    var gson: Gson = Gson()

    override fun render(model: Any?): String {
        return gson.toJson(model)
    }
}