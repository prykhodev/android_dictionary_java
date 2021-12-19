package com.prykhodev.android_dictionary.model.source

import com.prykhodev.android_dictionary.model.source.local.LocalDataSource
import com.prykhodev.android_dictionary.model.source.remote.RemoteDataSource
import kotlinx.coroutines.coroutineScope
import kotlin.reflect.KSuspendFunction1

class Repository(private val localDataSource: LocalDataSource,private val remoteDataSource: RemoteDataSource) {
    suspend fun searchWord(query: String) = coroutineScope {
        localDataSource.getWordWithMeanings(query)
            ?:withCaching(remoteDataSource.getWordWithMeanings(query),
                localDataSource::addWordWithMeanings)
    }

    private suspend fun <T> withCaching(value: T?, cacheFun: KSuspendFunction1<T, Unit>): T? {
        value?.let { cacheFun(it) }
        return value
    }
}