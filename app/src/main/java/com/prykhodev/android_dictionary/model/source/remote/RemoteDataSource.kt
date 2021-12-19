package com.prykhodev.android_dictionary.model.source.remote

import com.prykhodev.android_dictionary.model.Meaning
import com.prykhodev.android_dictionary.model.Word
import com.prykhodev.android_dictionary.model.WordWithMeanings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource internal constructor(
    private val dictionaryApi: DictionaryApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun getWordWithMeanings(query: String) : WordWithMeanings? =
        withContext(ioDispatcher) {
            dictionaryApi.getWordDefinition(query).body()?.firstOrNull()?.let {
                Word(it).let { word ->
                    WordWithMeanings(word,it.meanings.map { meaning -> Meaning(meaning, word.id) })
                }
            }

        }
}