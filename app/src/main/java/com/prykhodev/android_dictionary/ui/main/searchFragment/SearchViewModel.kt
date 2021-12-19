package com.prykhodev.android_dictionary.ui.main.searchFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prykhodev.android_dictionary.model.WordWithMeanings
import com.prykhodev.android_dictionary.model.source.Repository
import androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: Repository) : ViewModel() {
    private val _wordWithMeanings = MutableLiveData<WordWithMeanings?>()
    val wordWithMeanings: LiveData<WordWithMeanings?> = _wordWithMeanings

    val onQueryTextSubmit get() = OnQueryTextSubmit {
        viewModelScope.launch {
            _wordWithMeanings.value = repository.searchWord(it) }
    true}
}
