package com.kotlin.arun;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kotlin.arun.databinding.ListItemBinding;

import java.util.List;

/**
 * Created by wy on 2017/6/15.
 */

public class MyListAdapter extends RecyclerView.Adapter {
    private List<User2> list;

    public MyListAdapter(List<User2> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
        return new ItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            ItemHolder itemHolder = (ItemHolder) holder;
            itemHolder.setData(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static class ItemHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding = null;

        public ItemHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void setData(User2 user) {
            binding.setUser(user);
        }
    }
}
