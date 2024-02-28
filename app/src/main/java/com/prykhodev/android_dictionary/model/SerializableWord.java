package com.prykhodev.android_dictionary.model;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SerializableWord {
    @NonNull
    private final String word;
    private final String phonetic;
    @NonNull
    private final List<SerializableMeaning> meanings;

    public SerializableWord(
            @NonNull String word,
            String phonetic,
            @NonNull List<SerializableMeaning> meanings
    ) {
        this.word = word;
        this.phonetic = phonetic;
        this.meanings = meanings;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    @Nullable
    public String getPhonetic() {
        return phonetic;
    }

    @NonNull
    public List<SerializableMeaning> getMeanings() {
        return meanings;
    }
}
