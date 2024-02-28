package com.prykhodev.android_dictionary.ui.main.searchFragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.prykhodev.android_dictionary.databinding.MeaningItemBinding;
import com.prykhodev.android_dictionary.model.Meaning;

public class MeaningListAdapter extends ListAdapter<Meaning, MeaningListAdapter.ViewHolder> {
    protected MeaningListAdapter() {
        super(new MeaningDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                MeaningItemBinding.inflate(LayoutInflater.from(parent.getContext()))
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        holder.bind(getItem(pos));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final @NonNull MeaningItemBinding binding;

        private ViewHolder(@NonNull MeaningItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(@NonNull Meaning meaning) {
            binding.setMeaning(meaning);
            binding.executePendingBindings();
        }
    }
}

class MeaningDiffCallback extends DiffUtil.ItemCallback<Meaning> {
    @Override
    public boolean areItemsTheSame(Meaning oldItem, Meaning newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Meaning oldItem, @NonNull Meaning newItem) {
        return oldItem.equals(newItem);
    }
}