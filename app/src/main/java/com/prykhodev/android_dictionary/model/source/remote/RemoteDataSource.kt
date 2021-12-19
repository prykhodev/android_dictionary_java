package com.prykhodev.android_dictionary.model.source.remote

import com.prykhodev.android_dictionary.model.Meaning
import com.prykhodev.android_dictionary.model.Word
import com.prykhodev.android_dictionary.model.WordWithMeanings

class RemoteDataSource {
    fun getWordWithMeanings(query: String) : WordWithMeanings? =
        // TODO: 19.12.2021 add word request
        //Test mock
        WordWithMeanings(Word(0, "word", "[phonetic]"),
            listOf(Meaning(0, "partOfSpeech", "definition 1\ndefinition 2", 0)))
}