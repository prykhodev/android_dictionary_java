package com.prykhodev.android_dictionary.model.source.local;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Insert;

import com.prykhodev.android_dictionary.model.Meaning;
import com.prykhodev.android_dictionary.model.Word;
import com.prykhodev.android_dictionary.model.WordWithMeanings;

import java.util.List;

@Dao
public interface WordsDao {
    @Transaction
    @Query("SELECT * FROM words WHERE word = :query")
    WordWithMeanings getWordWithMeanings(String query);

    @Transaction
    @Insert
    void addWordWithMeanings(Word word, List<Meaning> meanings);
}
