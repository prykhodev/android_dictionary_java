package com.prykhodev.android_dictionary.model.source

import com.prykhodev.android_dictionary.model.WordWithMeanings
import com.prykhodev.android_dictionary.model.source.local.LocalDataSource
import com.prykhodev.android_dictionary.model.source.remote.RemoteDataSource
import kotlinx.coroutines.coroutineScope

class Repository(private val localDataSource: LocalDataSource,private val remoteDataSource: RemoteDataSource) {
    suspend fun searchWord(query: String) = coroutineScope {
        localDataSource.getWordWithMeanings(query) ?: remoteDataSource.getWordWithMeanings(query)
    }
}