package com.prykhodev.android_dictionary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "meanings")
data class Meaning @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo(name = "id") val id: String = UUID.randomUUID().toString(),
    @ColumnInfo val partOfSpeech: String = "",
    @ColumnInfo val definitions: String = "",
    @ColumnInfo val wordId: String = "") {
    constructor(serializableMeaning: SerializableMeaning, wordId: String) :
            this(
                partOfSpeech = serializableMeaning.partOfSpeech,
                definitions = serializableMeaning.definitions.joinToString("\n"),
                wordId = wordId)
}