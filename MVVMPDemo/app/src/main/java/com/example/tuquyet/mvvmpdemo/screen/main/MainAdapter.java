package com.example.tuquyet.mvvmpdemo.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tuquyet.mvvmpdemo.R;
import com.example.tuquyet.mvvmpdemo.databinding.ItemTaskBinding;
import com.example.tuquyet.mvvmpdemo.screen.ViewModel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<ItemViewModel> mTaskList = new ArrayList<>();


    public void updateData(List<ItemViewModel> list) {
        if (list == null) return;
        mTaskList.addAll(list);
        notifyDataSetChanged();
    }

    public void updateData(ItemViewModel itemViewModel) {
        int index;
        if (mTaskList.contains(itemViewModel)) {
            index = mTaskList.indexOf(itemViewModel);
            mTaskList.set(index, itemViewModel);
        } else {
            mTaskList.add(itemViewModel);
            index = mTaskList.size() - 1;
            notifyItemChanged(index);
        }
    }

    public void deleteTask(ItemViewModel itemViewModel) {
        int index = mTaskList.indexOf(itemViewModel);
        if (index >= 0) {
            mTaskList.remove(index);
        }
        notifyItemRemoved(index);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTaskBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.item_task, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mTaskList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTaskList != null ? mTaskList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemTaskBinding mItemTaskBinding;

        public ViewHolder(ItemTaskBinding itemTaskBinding) {
            super(itemTaskBinding.getRoot());
            mItemTaskBinding = itemTaskBinding;
        }

        public void bindData(ItemViewModel taskModel) {
            mItemTaskBinding.setViewModel(taskModel);
        }
    }
}
