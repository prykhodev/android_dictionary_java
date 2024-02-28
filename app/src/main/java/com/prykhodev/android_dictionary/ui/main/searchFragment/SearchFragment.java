package com.prykhodev.android_dictionary.ui.main.searchFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;

import com.prykhodev.android_dictionary.databinding.SearchFragmentBinding;

import static com.prykhodev.android_dictionary.model.util.FragmentExtKt.getViewModelFactory;

public class SearchFragment extends Fragment {
    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private SearchViewModel viewModel;
    private SearchFragmentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        if(binding == null) binding = SearchFragmentBinding.inflate(getLayoutInflater());
        if(viewModel == null) viewModel = new ViewModelProvider(
                this, getViewModelFactory(this)
        ).get(SearchViewModel.class);

        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.listOfMeanings.setAdapter(new MeaningListAdapter());
    }

}