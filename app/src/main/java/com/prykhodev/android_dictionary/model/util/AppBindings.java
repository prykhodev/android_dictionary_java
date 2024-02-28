package com.prykhodev.android_dictionary.model.util;

import com.prykhodev.android_dictionary.model.Meaning;
import com.prykhodev.android_dictionary.ui.main.searchFragment.MeaningListAdapter;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class AppBindings {
    @BindingAdapter("app:items")
    public static void setMeanings(RecyclerView view, List<Meaning> meanings) {
        if(meanings != null) {
            MeaningListAdapter adapter = (MeaningListAdapter) view.getAdapter();
            if(adapter != null) adapter.submitList(meanings);
        }
    }

    private AppBindings() {}
}
