package com.prykhodev.android_dictionary.model.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.prykhodev.android_dictionary.model.Meaning
import com.prykhodev.android_dictionary.model.Word
import com.prykhodev.android_dictionary.model.WordWithMeanings

@Dao
interface WordsDao {
    @Transaction
    @Query("SELECT * FROM words WHERE word = :query")
    fun getWordWithMeanings(query: String): WordWithMeanings?

    @Transaction
    @Insert
    fun addWordWithMeanings(word: Word, meanings: List<Meaning>)
}