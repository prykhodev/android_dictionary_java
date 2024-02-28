package com.prykhodev.android_dictionary.model;

import java.util.List;

public class SerializableMeaning {
    private final String partOfSpeech;
    private final List<Definition> definitions;

    public SerializableMeaning(String partOfSpeech, List<Definition> definitions) {
        this.partOfSpeech = partOfSpeech;
        this.definitions = definitions;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}
