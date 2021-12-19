package com.prykhodev.android_dictionary.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prykhodev.android_dictionary.model.WordWithMeanings
import com.prykhodev.android_dictionary.model.source.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _wordWithMeanings = MutableLiveData<WordWithMeanings>()
    val wordWithMeanings: LiveData<WordWithMeanings?> = _wordWithMeanings

    //fun getDefinitionOf(word: String) =
}