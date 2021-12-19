package com.prykhodev.android_dictionary.ui.main.searchFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prykhodev.android_dictionary.databinding.SearchFragmentBinding
import com.prykhodev.android_dictionary.model.util.getViewModelFactory

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val viewModel by viewModels<SearchViewModel> { getViewModelFactory() }
    private val binding by lazy { SearchFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        with(binding){
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@SearchFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listOfMeanings.adapter = MeaningListAdapter()
    }

}