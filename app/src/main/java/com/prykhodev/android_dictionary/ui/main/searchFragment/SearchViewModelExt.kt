@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.prykhodev.android_dictionary.ui.main.searchFragment

import androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

fun SearchViewModel.onQueryTextSubmit(): OnQueryTextSubmit = OnQueryTextSubmit {
        it?.let { viewModelScope.launch { _wordWithMeanings.value = _repository.searchWord(it) } }
        true
    }