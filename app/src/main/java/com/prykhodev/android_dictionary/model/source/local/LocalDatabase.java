package com.prykhodev.android_dictionary.model.source.local;


import com.prykhodev.android_dictionary.model.Meaning;
import com.prykhodev.android_dictionary.model.Word;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class, Meaning.class}, version = 3, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {
public abstract WordsDao wordsDao();
}
