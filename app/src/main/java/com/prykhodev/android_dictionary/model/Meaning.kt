package com.prykhodev.android_dictionary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meanings")
data class Meaning(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo val partOfSpeech: String,
    @ColumnInfo val definitions: String,
    @ColumnInfo val wordId: Long)