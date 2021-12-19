package com.prykhodev.android_dictionary.model

import androidx.room.Embedded
import androidx.room.Relation

data class WordWithMeanings(
    @Embedded val word: Word,
    @Relation(parentColumn = "id", entityColumn = "wordId") val meanings: List<Meaning> )