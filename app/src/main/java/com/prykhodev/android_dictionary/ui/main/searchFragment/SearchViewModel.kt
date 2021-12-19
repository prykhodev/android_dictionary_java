package com.prykhodev.android_dictionary.ui.main.searchFragment

import androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit
import androidx.lifecycle.*
import com.prykhodev.android_dictionary.model.WordWithMeanings
import com.prykhodev.android_dictionary.model.source.Repository
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: Repository) : ViewModel() {
    private val _wordWithMeanings = MutableLiveData<WordWithMeanings?>()
    val wordWithMeanings: LiveData<WordWithMeanings?> = _wordWithMeanings

    val textVisibility : LiveData<Boolean> = _wordWithMeanings.map { it != null }

    val onQueryTextSubmit get() = OnQueryTextSubmit {
        viewModelScope.launch {
            _wordWithMeanings.value = repository.searchWord(it) }
        return@OnQueryTextSubmit true}

}
