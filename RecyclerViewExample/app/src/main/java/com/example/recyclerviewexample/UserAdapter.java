package com.example.recyclerviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.recyclerviewexample.databinding.LayoutRecyclerItemBinding;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

	private ArrayList<User> users;
	private Context context;

	UserAdapter (ArrayList<User> users, Context context) {
		this.users = users;
		this.context = context;
	}

	@NonNull @NotNull @Override
	public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
		return new UserAdapter.UserViewHolder(
				DataBindingUtil.inflate(
						LayoutInflater.from(parent.getContext()),
						R.layout.layout_recycler_item,
						parent
						, false)
		);
	}

	@Override
	public void onBindViewHolder(@NonNull @NotNull UserAdapter.UserViewHolder holder, int position) {
		holder.binding.setData(users.get(position));
		holder.binding.getRoot().setOnClickListener(v -> {
			((MainActivity)context).onItemClick(users.get(position));
		});
	}

	@Override
	public int getItemCount() {
		return users.size();
	}

	static class UserViewHolder extends RecyclerView.ViewHolder {
		LayoutRecyclerItemBinding binding;
		public UserViewHolder(@NonNull @NotNull ViewBinding binding) {
			super(binding.getRoot());
			this.binding = (LayoutRecyclerItemBinding) binding;
		}
	}
}
