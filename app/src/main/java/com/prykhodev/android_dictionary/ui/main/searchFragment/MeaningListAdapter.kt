package com.prykhodev.android_dictionary.ui.main.searchFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prykhodev.android_dictionary.databinding.MeaningItemBinding
import com.prykhodev.android_dictionary.model.Meaning

class MeaningListAdapter: ListAdapter<Meaning, MeaningListAdapter.ViewHolder>(MeaningDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) = holder.bind(getItem(pos))

    class ViewHolder private constructor(private val binding: MeaningItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(meaning: Meaning) {
                binding.meaning = meaning
                binding.executePendingBindings()
            }
        companion object {
            fun from(parent: ViewGroup): ViewHolder =
                ViewHolder(
                    MeaningItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false)
                )
        }
    }

    class MeaningDiffCallback: DiffUtil.ItemCallback<Meaning>() {
        override fun areItemsTheSame(oldItem: Meaning, newItem: Meaning): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Meaning, newItem: Meaning): Boolean {
             return oldItem == newItem
        }

    }
}