package com.prykhodev.android_dictionary.model.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.prykhodev.android_dictionary.model.WordWithMeanings

@Dao
interface WordsDao {
    @Transaction
    @Query("SELECT * FROM words WHERE value = :query")
    fun getWordWithMeanings(query: String): WordWithMeanings?
}