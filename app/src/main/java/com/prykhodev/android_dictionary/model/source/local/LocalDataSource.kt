package com.prykhodev.android_dictionary.model.source.local

import com.prykhodev.android_dictionary.model.WordWithMeanings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource @JvmOverloads internal constructor(
    private val wordsDao: WordsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun getWordWithMeanings(query: String): WordWithMeanings? =
        withContext(ioDispatcher) {
            wordsDao.getWordWithMeanings(query)
    }

    suspend fun addWordWithMeanings(wordWithMeanings: WordWithMeanings) = withContext(ioDispatcher){
        wordsDao.addWordWithMeanings(wordWithMeanings.word, wordWithMeanings.meanings)
    }
}