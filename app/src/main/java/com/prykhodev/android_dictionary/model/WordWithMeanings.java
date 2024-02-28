package com.prykhodev.android_dictionary.model;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class WordWithMeanings {
    @Embedded
    private final Word word;
    @Relation(parentColumn = "id", entityColumn = "wordId")
    private final List<Meaning> meanings;

    public WordWithMeanings(Word word, List<Meaning> meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public Word getWord() {
        return word;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }
}
