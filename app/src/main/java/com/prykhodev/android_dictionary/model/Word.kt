package com.prykhodev.android_dictionary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "words")
data class Word @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo(name = "id") val id: String = UUID.randomUUID().toString(),
    @ColumnInfo val word: String = "",
    @ColumnInfo val phonetic: String = "") {
    constructor(serializableWord: SerializableWord): this(
        word = serializableWord.word,
        phonetic = serializableWord.phonetic?: ""
    )
}
