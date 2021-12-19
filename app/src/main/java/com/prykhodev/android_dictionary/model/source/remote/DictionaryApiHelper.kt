package com.prykhodev.android_dictionary.model.source.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DictionaryApiHelper {
    private const val BASE_URL = "https://api.dictionaryapi.dev"
    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}