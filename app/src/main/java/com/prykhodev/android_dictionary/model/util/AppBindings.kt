package com.prykhodev.android_dictionary.model.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prykhodev.android_dictionary.model.Meaning
import com.prykhodev.android_dictionary.ui.main.searchFragment.MeaningListAdapter

@BindingAdapter("app:items")
fun setMeanings(view: RecyclerView, meanings: List<Meaning>?) {
    meanings?.let { (view.adapter as MeaningListAdapter).submitList(it) }
}