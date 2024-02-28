package com.prykhodev.android_dictionary.ui.main.searchFragment;

import androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit;
import androidx.lifecycle.*;
import com.prykhodev.android_dictionary.model.WordWithMeanings;
import com.prykhodev.android_dictionary.model.source.Repository;

import java.util.Objects;

public class SearchViewModel extends ViewModel {
    public Repository _repository;
    public MutableLiveData<WordWithMeanings> _wordWithMeanings = new MutableLiveData<>();
    public LiveData<WordWithMeanings> getWordWithMeanings() {
        return _wordWithMeanings;
    }

    public LiveData<Boolean> getTextVisibility() {
        return Transformations.map(_wordWithMeanings, Objects::nonNull);
    }

    public OnQueryTextSubmit onQueryTextSubmit() {
        return SearchViewModelExtKt.onQueryTextSubmit(this);
    }

        public SearchViewModel(Repository repository) {
            this._repository = repository;
        }
}
