package com.prykhodev.android_dictionary.model.source.remote

import com.prykhodev.android_dictionary.model.SerializableWord
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET("/api/v2/entries/en/{query}")
    suspend fun getWordDefinition(@Path("query") query: String):
            Response<List<SerializableWord?>>
}