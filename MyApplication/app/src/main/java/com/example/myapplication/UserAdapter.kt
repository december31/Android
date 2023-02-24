package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LayoutRecyclerItemBinding

class UserAdapter(private val context: Context): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

	inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
		val binding = LayoutInflater.from(context).inflate(R.layout.layout_recycler_item, parent, false)
		return UserViewHolder(binding.root)
	}

	override fun getItemCount(): Int {
		TODO("Not yet implemented")
	}

	override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
		TODO("Not yet implemented")
	}

}