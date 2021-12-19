package com.prykhodev.android_dictionary.model.source.local

import com.prykhodev.android_dictionary.model.Meaning
import com.prykhodev.android_dictionary.model.Word
import com.prykhodev.android_dictionary.model.WordWithMeanings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource internal constructor(
    private val wordsDao: WordsDao,
    private val meaningsDao: MeaningsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun getWordWithMeanings(query: String): WordWithMeanings? = withContext(ioDispatcher) {
        // TODO: 19.12.2021 change to database ivnocation
        //Test mock
        WordWithMeanings(
            Word(0, "word", "[phonetic]"),
            listOf(Meaning(0, "partOfSpeech", "definition 1\ndefinition 2", 0)))
        //wordsDao.getWordWithMeanings(query)
    }
}