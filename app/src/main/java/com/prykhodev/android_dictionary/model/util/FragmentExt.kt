package com.prykhodev.android_dictionary.model.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prykhodev.android_dictionary.App
import com.prykhodev.android_dictionary.ui.main.MainViewModel

@Suppress("UNCHECKED_CAST")
fun Fragment.getViewModelFactory(): ViewModelProvider.Factory {
    val repository = (requireContext().applicationContext as App).repository
    return object : AbstractSavedStateViewModelFactory(this, null) {
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ) = with(modelClass){
            when{
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}