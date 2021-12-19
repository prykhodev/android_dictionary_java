package com.prykhodev.android_dictionary.model

data class SerializableWord(val word: String, val phonetic: String, val meanings: List<SerializableMeaning>)
data class SerializableMeaning(val partOfSpeech: String, val definitions: List<Definition>)
@JvmInline value class Definition(private val definition: String) {
    override fun toString() = definition
}