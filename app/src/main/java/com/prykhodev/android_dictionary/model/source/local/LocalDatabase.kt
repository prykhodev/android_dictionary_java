package com.prykhodev.android_dictionary.model.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prykhodev.android_dictionary.model.Meaning
import com.prykhodev.android_dictionary.model.Word

@Database(entities = [Word::class, Meaning::class], version = 3, exportSchema = false)
abstract class LocalDatabase : RoomDatabase(){
    abstract fun wordsDao(): WordsDao
}